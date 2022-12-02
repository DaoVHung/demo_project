package ra.Controller;

import ra.Model.Entity.Catalog;
import ra.Model.Service.CatalogService;
import ra.Model.ServiceImp.CatalogServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CatalogServlet", value = "/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    private CatalogService<Catalog,String> catalogService = new CatalogServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getAllProduct(request,response);
    }
    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Catalog> catalogList = catalogService.getAll();
        request.setAttribute("catalogList", catalogList);
        request.getRequestDispatcher("View/Catalog/catalog.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
