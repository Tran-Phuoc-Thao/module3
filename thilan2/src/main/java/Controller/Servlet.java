package Controller;

import Bean.Category;
import Bean.Product;
import Service.ServiceChinh;
import Service.ServiceChinhImp;
import Service.ServicePhuImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/Product")
public class Servlet extends HttpServlet {

    ServiceChinhImp serviceChinh = new ServiceChinhImp();
    ServicePhuImp servicePhuImp = new ServicePhuImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {

            switch (action) {
                case "create":
                    showCreat(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "search":
                    searchByName(request,response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> list = serviceChinh.search(name);
        request.setAttribute("list",list);
        request.getRequestDispatcher("list.jsp").forward(request,response);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceChinh.delete(id);
        List<Product> list = serviceChinh.findAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = servicePhuImp.selectAll();
        request.setAttribute("list",list);
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = serviceChinh.select(id);
        request.setAttribute("product",product);
        request.getRequestDispatcher("edit.jsp").forward(request,response);

    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list =serviceChinh.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    private void showCreat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = servicePhuImp.selectAll() ;
        request.setAttribute("list",list);
        request.getRequestDispatcher("create.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insert(request, response);
                    break;
                case "edit":
                    update(request, response);
                    break;

            }
        }catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            float gia = Float.parseFloat(request.getParameter("gia"));
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));
            String mauSac = request.getParameter("mauSac");
            String moTa = request.getParameter("moTa");
            String idType = request.getParameter("idType");
            Category category = servicePhuImp.select(idType);
            Product product = new Product(id,name,gia,soLuong,mauSac,moTa,category);
            serviceChinh.update(product);
            List<Product> list = serviceChinh.findAll();
            request.setAttribute("list",list);
            request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
            String name = request.getParameter("name");
            float gia = Float.parseFloat(request.getParameter("gia"));
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));
            String mauSac = request.getParameter("mauSac");
            String moTa = request.getParameter("moTa");
            String idType = request.getParameter("idType");
            Category category = servicePhuImp.select(idType);
            Product product = new Product(name,gia,soLuong,mauSac,moTa,category);
            serviceChinh.insert(product);
            List<Product> list = serviceChinh.findAll();
            request.setAttribute("list",list);
            request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
