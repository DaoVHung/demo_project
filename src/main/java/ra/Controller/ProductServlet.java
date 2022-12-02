package ra.Controller;

import ra.Model.Entity.Catalog;
import ra.Model.Entity.Drinks;
import ra.Model.Service.CatalogService;
import ra.Model.Service.DrinksService;
import ra.Model.ServiceImp.CatalogServiceImp;
import ra.Model.ServiceImp.DrinksVerviceImp;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "DrinksServlet", value = "/DrinksServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10
)
public class DrinksServlet extends HttpServlet {
    private DrinksService<Drinks, String> drinksService = new DrinksVerviceImp();
    private CatalogService<Catalog,String> catalogService = new CatalogServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action!=null&&action.equals("delete")){
            Integer drinksDele = Integer.parseInt(request.getParameter("drinksID"));
            boolean result = drinksService.delete(drinksDele);
            if (result){
                getAllProduct(request,response);
            }else {
                request.getRequestDispatcher("View/Error/error.jsp").forward(request,response);
            }
        }else if(action!=null&&action.equals("Update")){
            List<Catalog> listcat = catalogService.getAll();
            request.setAttribute("listcat",listcat);
            Integer drinksUpdate = Integer.parseInt(request.getParameter("drinksID"));
            Drinks drinksUp = drinksService.getById(drinksUpdate);
            request.setAttribute("drinksUpdate",drinksUp);
            request.getRequestDispatcher("View/Drinks/DrinksUpdate.jsp").forward(request,response);

        } else if (action!=null&&action.equals("newDrinks")) {
            List<Catalog> listcat = catalogService.getAll();
            request.setAttribute("listcat",listcat);
            request.getRequestDispatcher("View/Drinks/drinksCreate.jsp").forward(request,response);
        } else if(action!=null&&action.equals("GetByID")){
            Integer drinksID = Integer.parseInt(request.getParameter("drinksID"));
            Drinks drinks = drinksService.getById(drinksID);
            request.setAttribute("listcat",drinks);
            request.getRequestDispatcher("View/Drinks/drinksDetail.jsp").forward(request,response);
        }

        else{
            getAllProduct(request,response);
        }
    }
    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Drinks> drinksList = drinksService.getAll();
        request.setAttribute("drinksList", drinksList);
        request.getRequestDispatcher("drinks.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action!=null&&action.equals("Create")){
            Drinks drinksNew = new Drinks();
            drinksNew.setDrinksName(request.getParameter("drinksName"));
            drinksNew.setDrinksStatus(Boolean.parseBoolean(request.getParameter("drinksStatus")));
            String pathFolderImage = "D:/MD-3/ProjectMD3/src/main/webapp/images";
            File file = new File(pathFolderImage);
            if(!file.exists()){
                file.mkdir();
            }
            Drinks drinks = new Drinks();
            drinks.setDrinksName(request.getParameter("drinksName"));
            drinks.setCatalogID(request.getParameter("catalogID"));
            drinks.setPrice(Integer.parseInt(request.getParameter("price")));
            drinks.setDrinksStatus(Boolean.parseBoolean(request.getParameter("drinksStatus")));
            drinks.setTitle(request.getParameter("title"));
            for (Part part : request.getParts()){
                if(part.getName().equals("drinksImg")){
                    String drinksImgName = part.getSubmittedFileName();
                    drinks.setDrinksImg(drinksImgName);
                    part.write(pathFolderImage+File.separator+drinksImgName);
                }else if(part.getName().equals("subImg")){
                    String subImgName = part.getSubmittedFileName();
                    drinks.getListImgLinks().add(subImgName);
                    InputStream fileContent = part.getInputStream();
                    part.write(pathFolderImage + File.separator + subImgName);
                }
            }
            boolean result = drinksService.save(drinks);
            if (result){
                getAllProduct(request,response);
            }else {
                request.getRequestDispatcher("View/Error/error.jsp").forward(request, response);

            }
        }else if(action!=null&&action.equals("Update")){
            Drinks drinksNew = new Drinks();
            drinksNew.setDrinksName(request.getParameter("drinksName"));
            drinksNew.setDrinksStatus(Boolean.parseBoolean(request.getParameter("drinksStatus")));
            String pathFolderImage = "D:/MD-3/ProjectMD3/src/main/webapp/images";
            File file = new File(pathFolderImage);
            if(!file.exists()){
                file.mkdir();
            }
            Drinks drinks = new Drinks();
            drinks.setDrinksID(Integer.parseInt(request.getParameter("drinksID")));
            drinks.setDrinksName(request.getParameter("drinksName"));
            drinks.setCatalogID(request.getParameter("catalogID"));
            drinks.setPrice(Integer.parseInt(request.getParameter("price")));
            drinks.setDrinksStatus(Boolean.parseBoolean(request.getParameter("drinksStatus")));
            drinks.setTitle(request.getParameter("title"));
            for (Part part : request.getParts()){
                if(part.getName().equals("drinksImg")){
                    String drinksImgName = part.getSubmittedFileName();
                    drinks.setDrinksImg(drinksImgName);
                    part.write(pathFolderImage+File.separator+drinksImgName);
                }else if(part.getName().equals("subImg")){
                    String subImgName = part.getSubmittedFileName();
                    drinks.getListImgLinks().add(subImgName);
                    InputStream fileContent = part.getInputStream();
                    part.write(pathFolderImage + File.separator + subImgName);
                }
            }
            boolean result = drinksService.update(drinks);
            if (result){
                getAllProduct(request,response);
            }else {
                request.getRequestDispatcher("View/Error/error.jsp").forward(request, response);

            }
        }else if(action!=null&&action.equals("Search")){
            String drinksName = request.getParameter("drinksName");
            List<Drinks> drinksList = drinksService.searchProByName(drinksName);
            request.setAttribute("drinksList", drinksList);
            request.getRequestDispatcher("drinks.jsp").forward(request,response);
        }

    }
}
