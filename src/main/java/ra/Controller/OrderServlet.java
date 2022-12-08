package ra.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ra.Model.Entity.Order;
import ra.Model.Entity.Product;
import ra.Model.Service.OrderService;
import ra.Model.Service.ProductService;
import ra.Model.ServiceImp.OrderServiceImp;
import ra.Model.ServiceImp.ProductVerviceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    private ProductService<Product, String> productService = new ProductVerviceImp();
    private static final Gson GSON = new GsonBuilder().create();
    private OrderService<Order, String> orderService = new OrderServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("Update")) {
            Integer orderUpdate = Integer.parseInt(request.getParameter("orderID"));
            Order order = orderService.getById(orderUpdate);
            request.setAttribute("order", order);
            request.getRequestDispatcher("View/Admin/Bill/billUpdate.jsp").forward(request, response);
        } else if (action != null && action.equals("Confirmed")) {
            List<Order> orderList = orderService.getConfrim();
            request.setAttribute("order", orderList);
            request.getRequestDispatcher("View/Admin/Bill/billConfirm.jsp").forward(request, response);
            
        } else {
            getAllProduct(request, response);

        }

    }

    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orderList = orderService.getAll();
        request.setAttribute("order", orderList);
        request.getRequestDispatcher("View/Admin/Bill/bill.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("update")) {
            Order catInfo = new Order();
            catInfo.setOrderID(Integer.parseInt(request.getParameter("orderID")));
            catInfo.setOrderStatus(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = orderService.update(catInfo);
            if (result) {
                getAllProduct(request, response);
            }
        } else if (action != null && action.equals("Search")) {
            String userName = request.getParameter("search");
            List<Order> orderList = orderService.searchProByName(userName);
            request.setAttribute("order", orderList);
            request.getRequestDispatcher("View/Admin/Bill/bill.jsp").forward(request, response);
        }      else if (action != null && action.equals("SearchConfirm")) {
            String userName = request.getParameter("searchConfirm");
            List<Order> orderList = orderService.searchConfirm(userName);
            request.setAttribute("order", orderList);
            request.getRequestDispatcher("View/Admin/Bill/billConfirm.jsp").forward(request, response);
        }


    }
}
