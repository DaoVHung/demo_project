package ra.Controller;

import ra.Model.Entity.*;
import ra.Model.Service.OrderService;
import ra.Model.Service.ProductService;
import ra.Model.ServiceImp.OrderServiceImp;
import ra.Model.ServiceImp.ProductVerviceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/CartServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10
)
public class CartServlet extends HttpServlet {
    private ProductService<Product, String> productService = new ProductVerviceImp();
    private OrderService<Order, String> orderService = new OrderServiceImp();


    public static Integer size(List<Cart> list) {
        Integer size = 0;
        if (list.isEmpty() || list.size() == 0) {
            size = 0;
        } else {
            size = list.size();
        }
        return size;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action").trim();
        if (action != null && action.equals("Delete")) {
            List<Cart> listCart = (List<Cart>) request.getSession().getAttribute("listCart");
            Integer prodductID = Integer.parseInt(request.getParameter("productID"));
            for (int i = 0; i < listCart.size(); i++) {
                if (listCart.get(i).getProduct().getProductID() == prodductID) {
                    listCart.remove(i);
                }
            }
            request.getSession().setAttribute("listCart", listCart);
            request.getSession().setAttribute("totalAmount", totalAmount(listCart));
            request.getRequestDispatcher("View/User/Cart.jsp").forward(request, response);
        } else if (action != null && action.equals("History")) {
            List<Cart> listCart = (List<Cart>) request.getSession().getAttribute("listCart");
            request.getSession().setAttribute("listCart", listCart);
            request.getRequestDispatcher("View/User/History.jsp").forward(request, response);

        } else if (action != null && action.equals("Buy")) {
            HttpSession session = request.getSession();
            List<Cart> listCart = (List<Cart>) request.getSession().getAttribute("listCart");
            Integer UserID = (Integer) session.getAttribute("UserID");
            User user = (User) session.getAttribute("UserSession");
            if (UserID == null) {
                String Notify = "Vui lòng đăng nhập để sử dụng dịch vụ !";
                request.getSession().setAttribute("Notify", Notify);
                request.getRequestDispatcher("View/User/CheckOut.jsp").forward(request, response);
            } else {
                request.setAttribute("User", user);
                Integer coupon = Integer.parseInt(request.getParameter("coupon"));
                String Notify = "";
                request.getSession().setAttribute("Notify", Notify);
                request.setAttribute("coupon", coupon);
                request.getSession().setAttribute("listCart", listCart);
                request.getSession().setAttribute("totalAmount", totalAmount(listCart));
                request.getRequestDispatcher("View/User/CheckOut.jsp").forward(request, response);
            }


        } else if (action != null && action.equals("addCart")) {
            Integer productID = Integer.parseInt(request.getParameter("productID"));
            Integer discount = Integer.parseInt(request.getParameter("discount"));
            Product product = productService.getById(productID);
            HttpSession session = request.getSession();
            List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
            if (listCart == null) {
                listCart = new ArrayList<>();
                Cart cart = new Cart(product, 1, discount, null);
                listCart.add(cart);
            } else {
                boolean checkExist = false;
                for (Cart cart : listCart) {
                    if (cart.getProduct().getProductID() == productID) {
                        cart.setQuantity(cart.getQuantity() + 1);
                        checkExist = true;
                        break;
                    }
                }
                if (!checkExist) {
                    Cart cart = new Cart(product, 1, discount, null);
                    listCart.add(cart);
                }
            }
            session.setAttribute("listCart", listCart);
            if (listCart.isEmpty() || listCart.size() == 0) {
                Integer size = 0;
                request.getSession().setAttribute("size", size);
            } else {
                request.getSession().setAttribute("size", size(listCart));
            }
            session.setAttribute("totalAmount", totalAmount(listCart));
            session.setAttribute("discount", discount(listCart));
            response.sendRedirect("View/User/Cart.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action").trim();
        if (action != null && action.trim().equals("Add To Cart")) {
            Integer productID = Integer.parseInt(request.getParameter("productID"));
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));
            Integer discount = Integer.parseInt(request.getParameter("discount"));
            String note = request.getParameter("note");

            Product product = productService.getById(productID);


            HttpSession session = request.getSession();


            List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
            if (listCart == null) {
                listCart = new ArrayList<>();
                Cart cart = new Cart(product, quantity, discount, note);
                listCart.add(cart);
            } else {
                boolean checkExist = false;
                for (Cart cart : listCart) {
                    if (cart.getProduct().getProductID() == productID) {
                        cart.setQuantity(cart.getQuantity() + quantity);
                        checkExist = true;
                        break;
                    }
                }
                if (!checkExist) {
                    Cart cart = new Cart(product, quantity, discount, note);
                    listCart.add(cart);
                }
            }
            session.setAttribute("listCart", listCart);
            if (listCart.isEmpty() || listCart.size() == 0) {
                Integer size = 0;
                request.getSession().setAttribute("size", size);
            } else {
                request.getSession().setAttribute("size", size(listCart));
            }
            session.setAttribute("totalAmount", totalAmount(listCart));
            session.setAttribute("discount", discount(listCart));
            response.sendRedirect("View/User/Cart.jsp");
        } else if (action != null && action.equals("Update")) {
            List<Cart> listCart = (List<Cart>) request.getSession().getAttribute("listCart");
            String[] arrQuantity = request.getParameterValues("quantity");
            for (int i = 0; i < listCart.size(); i++) {
                listCart.get(i).setQuantity(Integer.parseInt(arrQuantity[i]));
            }
            request.getSession().setAttribute("listCart", listCart);
            request.getSession().setAttribute("totalAmount", totalAmount(listCart));
            request.getRequestDispatcher("View/User/Cart.jsp").forward(request, response);
        } else if (action != null && action.equals("CheckOut") || action.equals("Buy For Others")) {
            List<Cart> listCart = (List<Cart>) request.getSession().getAttribute("listCart");
            if (listCart == null || listCart.isEmpty()) {
                String notify = "Vui lòng thêm sản phẩm vào giỏ hàng để thanh toán !";
                request.setAttribute("notify", notify);
                request.getRequestDispatcher("View/User/Cart.jsp").forward(request, response);
            } else {
                Integer coupon = Integer.parseInt(request.getParameter("coupon"));
                if(coupon!=null&&coupon==10){
                    request.setAttribute("coupon", coupon);
                    request.getSession().setAttribute("listCart", listCart);
                    request.getSession().setAttribute("totalAmount", totalAmount(listCart));
                    request.getRequestDispatcher("View/User/CheckOut.jsp").forward(request, response);
                }else {
                    coupon = 0;
                    request.setAttribute("coupon", coupon);
                    request.getSession().setAttribute("listCart", listCart);
                    request.getSession().setAttribute("totalAmount", totalAmount(listCart));
                    request.getRequestDispatcher("View/User/CheckOut.jsp").forward(request, response);
                }
                }


        } else if (action != null && action.equals("CheckOutProsses")) {
            HttpSession session = request.getSession();
            List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
            Integer UserID = (Integer) session.getAttribute("UserID");
            Integer coupon = Integer.parseInt(request.getParameter("coupon"));

            if (UserID == null) {
                String Notify = "Vui lòng đăng nhập để sử dụng dịch vụ !";
                request.getSession().setAttribute("Notify", Notify);
                request.getRequestDispatcher("View/User/CheckOut.jsp").forward(request, response);
            } else {
                Order newOrder = new Order();
                newOrder.setUserID(UserID);
                newOrder.setDate(java.time.LocalDate.now());
                newOrder.setTotalAmount(totalAmount(listCart)*(100-coupon)/100);
                newOrder.setNote(request.getParameter("note"));
                newOrder.setFullName(request.getParameter("fullName"));
                newOrder.setAddress(request.getParameter("address"));
                newOrder.setPhoneNumber(Integer.parseInt(request.getParameter("phone")));
                newOrder.setEmail(request.getParameter("email"));
                newOrder.setOrderStatus(false);
                for (Cart cart : listCart) {
                    OrderDetail od = new OrderDetail();
                    od.setProductID(cart.getProduct().getProductID());
                    od.setPrice(cart.getProduct().getPrice() * ((100 - cart.getProduct().getDiscount())) / 100);
                    od.setQuantity(cart.getQuantity());
                    newOrder.getListOrderDetail().add(od);
                }
                boolean result = orderService.save(newOrder);
                if (result) {
                    request.getRequestDispatcher("View/User/alertMessage.jsp").forward(request, response);
                    listCart.clear();
                } else {
                    request.getRequestDispatcher("View/Admin/Error/error.jsp").forward(request, response);
                }
            }

        } else if (action != null && action.equals("Apply coupon")) {
            String coupon = request.getParameter("coupon");
            if (coupon != null && coupon.equals("HungBeoo")) {
                List<Cart> listCart = (List<Cart>) request.getSession().getAttribute("listCart");
                Integer Coupon = 10;
                request.setAttribute("coupon", Coupon);
                request.getSession().setAttribute("listCart", listCart);
                request.getSession().setAttribute("totalAmount", totalAmount(listCart));
                request.getRequestDispatcher("View/User/Cart.jsp").forward(request, response);
            }  else {
                List<Cart> listCart = (List<Cart>) request.getSession().getAttribute("listCart");

                String motify = "Coupon code does not exist !";
                Integer Coupon = 0;
                request.setAttribute("coupon", Coupon);
                request.setAttribute("motify", motify);
                request.getSession().setAttribute("listCart", listCart);
                request.getSession().setAttribute("totalAmount", totalAmount(listCart));
                request.getRequestDispatcher("View/User/Cart.jsp").forward(request, response);
            }


        }

    }

    public static Integer discount(List<Cart> list) {
        Integer total = 0;
        for (Cart ca : list) {
            total += ca.getQuantity() * ca.getProduct().getDiscount();
        }
        return total;
    }

    public static Integer totalAmount(List<Cart> list) {
        Integer total = 0;
        for (Cart ca : list) {
            total += ca.getQuantity() * ca.getProduct().getPrice() * (100 - ca.getProduct().getDiscount()) / 100;

        }
        return total;
    }


}
