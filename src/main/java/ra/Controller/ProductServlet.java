package ra.Controller;

import ra.Model.Entity.*;
import ra.Model.Service.CatalogService;
import ra.Model.Service.ProductService;
import ra.Model.Service.StarService;
import ra.Model.Service.UserService;
import ra.Model.ServiceImp.CatalogServiceImp;
import ra.Model.ServiceImp.ProductVerviceImp;
import ra.Model.ServiceImp.StarServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static ra.Controller.CartServlet.size;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10
)
public class ProductServlet extends HttpServlet {
    private ProductService<Product, String> productService = new ProductVerviceImp();
    private CatalogService<Catalog, String> catalogService = new CatalogServiceImp();
    private UserService<User, String> userService = new ra.Model.ServiceImp.UserServiceImp();

    private StarService<Star, String> starService = new StarServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action != null && action.equals("Update")) {
            List<Catalog> listcat = catalogService.getAll();
            request.setAttribute("listcat", listcat);
            Integer productUpdate = Integer.parseInt(request.getParameter("productID"));
            Product productUp = productService.getById(productUpdate);
            request.setAttribute("productUpdate", productUp);
            request.getRequestDispatcher("View/Admin/Product/ProductUpdate.jsp").forward(request, response);
        } else if (action != null && action.equals("newProduct")) {
            List<Catalog> listcat = catalogService.getAll();
            request.setAttribute("listcat", listcat);
            request.getRequestDispatcher("View/Admin/Product/productCreate.jsp").forward(request, response);
        } else if (action != null && action.equals("GetByID")) {
            Integer productID = Integer.parseInt(request.getParameter("productID"));
            Product product = productService.getById(productID);
            request.setAttribute("proDetail", product);
            request.getRequestDispatcher("View/Admin/Product/productDetail.jsp").forward(request, response);
        } else if (action != null && action.equals("productDetail")) {
            Integer productID = Integer.parseInt(request.getParameter("productID"));
            Product product = productService.getById(productID);
            Integer star = starService.getbyID(productID);
            if(star==0){
                String rate = " Dont have review yet !";
                request.setAttribute("star",rate);
            }else {
                String rate = String.valueOf(star);
                request.setAttribute("star",rate);
            }
            request.setAttribute("proDetail", product);

            request.getRequestDispatcher("View/User/Product-Detail.jsp").forward(request, response);
        } else if (action != null && action.equals("GetAll")) {
            HttpSession session = request.getSession();
            Integer UserID = (Integer) session.getAttribute("UserID");
            if (UserID != null) {
                getAllProductDetail(request, response);
            } else {
                getAllProductDetail(request, response);
            }
        } else if (action != null && action.equals("GetAllFood")) {
            getAllFood(request, response);
        } else if (action != null && action.equals("GetAllMainFood")) {
            getMainFood(request, response);
        } else if (action != null && action.equals("GetAllDrinks")) {
            getDrinks(request, response);
        } else if (action != null && action.equals("GetAllDesserts")) {
            getDesserts(request, response);
        } else if (action != null && action.equals("GetAllSalad")) {
            getSalad(request, response);
        } else if (action != null && action.equals("Admin")) {

        } else {
            getAllProduct(request, response);
        }
    }

    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.getAll();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("View/Admin/Product/product.jsp").forward(request, response);
    }

    public void getAllProductDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
        List<Product> productList = productService.getAll();
        Integer UserID = (Integer) session.getAttribute("UserID");
        request.setAttribute("detail", productList);
        if(listCart==null){
            Integer size = 0;
            request.getSession().setAttribute("size", size);
        }else {
            request.getSession().setAttribute("size", size(listCart));
        }
        request.getRequestDispatcher("View/User/Home.jsp").forward(request, response);
    }

    public void getAllFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.getAll();
        request.setAttribute("detail", productList);
        request.getRequestDispatcher("View/User/Shop.jsp").forward(request, response);
    }

    public void getDrinks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.getAllDrinks();
        request.setAttribute("detail", productList);
        request.getRequestDispatcher("View/User/Drinks.jsp").forward(request, response);
    }

    public void getMainFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.getAllMainFood();
        request.setAttribute("detail", productList);
        request.getRequestDispatcher("View/User/MainFood.jsp").forward(request, response);
    }

    public void getSalad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.getAllSalad();
        request.setAttribute("detail", productList);
        request.getRequestDispatcher("View/User/Salad.jsp").forward(request, response);
    }

    public void getDesserts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.getAllDesserts();
        request.setAttribute("detail", productList);
        request.getRequestDispatcher("View/User/Desserts.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null && action.equals("Create")) {
            Product productNew = new Product();
            String pathFolderImage = "D:/MD-3/ProjectMD3/src/main/webapp/images";
            File file = new File(pathFolderImage);
            if (!file.exists()) {
                file.mkdir();
            }
            Product product = new Product();
            product.setProductName(request.getParameter("productName"));
            product.setCatalogID(request.getParameter("catalogID"));
            product.setPrice(Integer.parseInt(request.getParameter("price")));
            product.setDescription(request.getParameter("descriptions"));
            product.setProductStatus(Boolean.parseBoolean(request.getParameter("status")));
            product.setDiscount(Integer.parseInt(request.getParameter("discount")));

            for (Part part : request.getParts()) {
                if (part.getName().equals("productImg")) {
                    String productImgName = part.getSubmittedFileName();
                    product.setProductImg(productImgName);
                    part.write(pathFolderImage + File.separator + productImgName);
                }
            }


            boolean result = productService.save(product);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("View/Admin/Error/error.jsp").forward(request, response);

            }
        } else if (action != null && action.equals("Update")) {
            String pathFolderImage = "D:/MD-3/ProjectMD3/src/main/webapp/images";
            File file = new File(pathFolderImage);
            if (!file.exists()) {
                file.mkdir();
            }
            Product product = new Product();
            product.setProductID(Integer.parseInt(request.getParameter("productID")));
            product.setProductName(request.getParameter("productName"));
            product.setCatalogID(request.getParameter("catalogID"));
            product.setPrice(Integer.parseInt(request.getParameter("price")));
            product.setDescription(request.getParameter("descriptions"));
            product.setProductStatus(Boolean.parseBoolean(request.getParameter("status")));
            product.setDiscount(Integer.parseInt(request.getParameter("discount")));
            for (Part part : request.getParts()) {


                if (part.getName().equals("productImg")) {
                    String productImgName = part.getSubmittedFileName();
                    if (productImgName == "" || productImgName == null) {
                        product.setProductImg(request.getParameter("oldImage"));
                    } else {
                        product.setProductImg(productImgName);
                        part.write(pathFolderImage + File.separator + productImgName);
                    }
                }
            }
            boolean result = productService.update(product);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("View/Admin/Error/error.jsp").forward(request, response);
            }
        } else if (action != null && action.equals("Search")) {
            String productName = request.getParameter("productName");
            List<Product> productList = productService.searchProByName(productName);
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("View/Admin/Product/product.jsp").forward(request, response);
        } else if (action != null && action.equals("delete")) {
            int productId = Integer.parseInt(request.getParameter("proProductId"));
            boolean result = productService.delete(productId);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("View/Admin/Error/error.jsp").forward(request, response);
            }
        }
    }

    public static Integer totalAmount(List<Cart> list) {
        Integer total = 0;
        for (Cart ca : list) {
            total += ca.getQuantity() * ca.getProduct().getPrice();
        }
        return total;
    }

}
