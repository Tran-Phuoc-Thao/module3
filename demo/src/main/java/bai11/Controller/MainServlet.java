package bai11.Controller;

import bai11.Bean.Product;
import bai11.Repository.ProductRepImp;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Bai11.MainServlet", value = "/list")
public class MainServlet extends HttpServlet {
    ProductRepImp productRepImp = new ProductRepImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                showList(request, response);
                break;
            case "create":
                showCreate(request, response);
                break;
            case "update":
                showUpdate(request,response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            default:
                showError(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productRepImp.findAll();
        request.setAttribute("list",productList);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }





    private void showError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("error.jsp").forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("create.jsp").forward(request, response);

    }

    


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showError(request, response);
            return;
        }

        switch (action) {
            case "create":
                doCreate(request, response);
                break;
            case "update":
                doUpdate(request, response);
                break;
            case "delete":
                delete(request,response);
                break;
            default:
                showError(request, response);
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("product", productRepImp.findById(id));
        request.getRequestDispatcher("delete.jsp").forward(request,response);
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        productRepImp.delete(id);

        response.sendRedirect("/list");
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        float gia = Float.parseFloat(request.getParameter("gia"));
        String anh  = request.getParameter("anh");
        Product product = new Product(id,name,gia,anh);
        productRepImp.update(product);
        response.sendRedirect("/list");

    }
    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("product", productRepImp.findById(id));
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        float gia = Float.parseFloat(request.getParameter("gia"));
        String anh  = request.getParameter("anh");
        Product product = new Product(id,name,gia,anh);
        productRepImp.create(product);
        response.sendRedirect("/list");
    }
}
