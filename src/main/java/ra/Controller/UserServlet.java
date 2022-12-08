package ra.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ra.Model.Entity.Product;
import ra.Model.Entity.User;
import ra.Model.Service.ProductService;
import ra.Model.Service.UserService;
import ra.Model.ServiceImp.ProductVerviceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserService<User, String> userService = new ra.Model.ServiceImp.UserServiceImp();
    private static final Gson GSON = new GsonBuilder().create();
    private ProductService<Product, String> productService = new ProductVerviceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action != null && action.equals("Login")) {
            String username = request.getParameter("username");
            String passwords = request.getParameter("passwords");
            boolean result = userService.matchAccAdmin(username, passwords);
            if (result) {
                request.getRequestDispatcher("View/Admin/Home.jsp").include(request, response);
            } else {
                boolean result2 = userService.matchAcc(username, passwords);
                if (result2) {
                    HttpSession session = request.getSession();
                    Integer userID = userService.IsUser(username, passwords);
                    User user = userService.getById(userID);
                    String Notify = " ";
                    request.getSession().setAttribute("NotifyLogin", Notify);
                    session.setAttribute("UserID", userID);
                    session.setAttribute("UserSession", user);
                    request.getRequestDispatcher("ProductServlet?action=GetAll").include(request, response);
                } else {
                    String wrong = "Tài khoản hoặc mật khẩu không hợp lệ !";
                    request.setAttribute("wrong", wrong);
                    request.getRequestDispatcher("View/Login.jsp").forward(request, response);
                }
            }
        } else if (action != null && action.equals("GetById")) {
            int userID = Integer.parseInt(request.getParameter("userID"));
            User userUpdate = userService.getById(userID);
            String json = GSON.toJson(userUpdate);
            response.setStatus(200);
            response.setHeader("Content-Type", "application/json");
            Writer out = response.getWriter();
            out.write(json);
            out.flush();
        }   else if (action != null && action.equals("Update")){
            Integer UserID = Integer.parseInt(request.getParameter("UserID"));
            User user = userService.getById(UserID);
            request.setAttribute("user",user);
            request.getRequestDispatcher("View/Admin/Account/userUpdate.jsp").forward(request,response);
        }
        getAllProduct(request, response);
    }

    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.getAll();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("View/Admin/Account/user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action != null && action.equals("Create")) {
            User u = new User();
            u.setUserName(request.getParameter("userName"));
            u.setPasswords(request.getParameter("passwords"));
            u.setConfirmPass(request.getParameter("confrimPass"));
            u.setFullName(request.getParameter("fullName"));
            u.setEmail(request.getParameter("email"));
            u.setPhoneNumber(request.getParameter("phoneNumber"));
            u.setAddress(request.getParameter("address"));
            boolean result = userService.save(u);
            if (result) {
                String success = "Tạo tài khoản thành công !";
                request.setAttribute("success", success);
                request.getRequestDispatcher("View/Login.jsp").forward(request, response);
            } else {
                String wrong = "Tạo tài khoản thất bại !";
                request.setAttribute("wrong", wrong);
                request.getRequestDispatcher("View/Login.jsp").forward(request, response);
            }
        } else if (action != null && action.equals("Search")) {
            String userName = request.getParameter("UserName");
            List<User> userList = userService.searchProByName(userName);
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("View/Admin/Account/user.jsp").forward(request, response);
        } else if (action != null && action.equals("Update")) {
            User u = new User();
            u.setUserID(Integer.parseInt(request.getParameter("userID")));
            u.setPermission(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = userService.update(u);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("View/Admin/Error/error.jsp").forward(request, response);
            }
        } else if (action != null && action.equals("Delete")) {
            int userID = Integer.parseInt(request.getParameter("userID"));
            boolean result = userService.delete(userID);
            if (result) {
                getAllProduct(request, response);
            } else {
                request.getRequestDispatcher("View/Error/erroe.jsp").forward(request, response);
            }
        }
    }
}