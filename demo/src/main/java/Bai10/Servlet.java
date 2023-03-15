package Bai10;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Bai9.Servlet", value = "/customer")
public class Servlet extends HttpServlet {
    public ArrayList list = new ArrayList();

    @Override
    public void init() throws ServletException {
        super.init();
        list.add(new Customer("Mai Van Hoang","1983-08-20","ha noi","https://wheeler-centre-heracles.s3.amazonaws.com/wheeler-centre/assets/17/c5f7e0a29e11e48e78db79091b8334/1a16ecc0a29e11e49dbb07376151f609_content_medium.jpg"));
        list.add(new Customer("Nguyen Van Nam","1983-08-21","Bac Giang","https://hinhanhdep.vn/wp-content/uploads/2019/07/hinh-anh-hotboy-nam-sinh-dep-trai-2.jpeg"));
        list.add(new Customer("Mai Van Hoang","1983-08-20","ha noi","https://wheeler-centre-heracles.s3.amazonaws.com/wheeler-centre/assets/17/c5f7e0a29e11e48e78db79091b8334/1a16ecc0a29e11e49dbb07376151f609_content_medium.jpg"));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",list);
        request.getRequestDispatcher("indexcust.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
