package bai9;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "com.example.demo.Servlet1", value = "/productdiscount")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("mota");
        float gia = Float.parseFloat(request.getParameter("gianiemyet"));
        float chietkhau = Float.parseFloat(request.getParameter("chietkhau"));
        float lastprice = (float) (gia*chietkhau*0.01);
        float giaphaitra = gia-lastprice;
        request.setAttribute("giaphaitra",giaphaitra);
        request.setAttribute("lastprice",lastprice);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
