package ra.Controller;

import ra.Model.Entity.Cart;
import ra.Model.Entity.Order;
import ra.Model.Entity.Product;
import ra.Model.Entity.Table;
import ra.Model.Service.TableService;
import ra.Model.ServiceImp.TableServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@WebServlet(name = "TableServlet", value = "/TableServlet")
public class TableServlet extends HttpServlet {
    private TableService<Table, String> tableService = new TableServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action!=null&&action.equals("Update")){
            Integer tableID = Integer.parseInt(request.getParameter("tableID"));
            Table table = tableService.getById(tableID);
            request.setAttribute("table",table);
            request.getRequestDispatcher("View/Admin/Table/tableUpdate.jsp").forward(request,response);
        } else if (action != null && action.equals("Confirmed")) {
            List<Table> listTable = tableService.getAllConfirm();
            request.setAttribute("table",listTable);
            request.getRequestDispatcher("View/Admin/Table/confirmTable.jsp").forward(request,response);
        }else {
            getAllProduct(request,response);
        }

    }
    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Table> listTable = tableService.getAll();
        request.setAttribute("table",listTable);
        request.getRequestDispatcher("View/Admin/Table/table.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null && action.equals("Book")) {
            HttpSession session = request.getSession();
            List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
            Integer UserID = (Integer) session.getAttribute("UserID");
            Table table = new Table();
            table.setUserID(UserID);
            table.setUserName(request.getParameter("fullName"));
            table.setEmail(request.getParameter("email"));
            table.setPhoneNumber(Integer.parseInt(request.getParameter("phoneNumber")));
            table.setPeople(Integer.parseInt(request.getParameter("people")));
            table.setDate(LocalDate.parse(request.getParameter("date")));
            table.setTime(LocalTime.parse(request.getParameter("time")));
            table.setSubject(request.getParameter("subject"));
            table.setMessege(request.getParameter("message"));
            boolean result = tableService.save(table);
            if (result) {
                request.getRequestDispatcher("View/User/alertMessage.jsp").forward(request, response);

            } else {
                request.getRequestDispatcher("View/Admin/Error/error.jsp").forward(request, response);

            }
        } else if (action != null && action.equals("Search")) {
            String name = request.getParameter("search");
            List<Table> tableList = tableService.searchProByName(name);
            request.setAttribute("table",tableList);
            request.getRequestDispatcher("View/Admin/Table/table.jsp").forward(request,response);
        } else if (action!=null&&action.equals("update")) {
            Table table = new Table();
            table.setTableID(Integer.parseInt(request.getParameter("tableID")));
            table.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = tableService.update(table);
            if(result){
                getAllProduct(request,response);
            }
        } else if (action != null && action.equals("SearchConfirm")) {
            String name = request.getParameter("searchConfirm");
            List<Table> tableList = tableService.searchTableConfirm(name);
            request.setAttribute("table",tableList);
            request.getRequestDispatcher("View/Admin/Table/confirmTable.jsp").forward(request,response);
        }

    }
}
