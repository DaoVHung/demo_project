package ra.Controller;

import ra.Model.Entity.OrderDetail;
import ra.Model.Entity.Product;
import ra.Model.Service.OrderDetailService;
import ra.Model.Service.OrderService;
import ra.Model.Service.ProductService;
import ra.Model.ServiceImp.OrderDetailServiceImp;
import ra.Model.ServiceImp.OrderServiceImp;
import ra.Model.ServiceImp.ProductVerviceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderDetailServlet", value = "/OrderDetailServlet")
public class OrderDetailServlet extends HttpServlet {
    private OrderDetailService<OrderDetail,String> orderService = new OrderDetailServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action!=null && action.equals("GetAll")){
            Integer orderID = Integer.parseInt(request.getParameter("orderID"));
            List<OrderDetail> list = orderService.getAllDetail(orderID);
            request.setAttribute("Detail", list);
            request.getRequestDispatcher("View/Admin/Bill/billDetail.jsp").forward(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

}
