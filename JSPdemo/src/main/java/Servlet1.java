import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet1", value = "/productdiscount")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String ten = request.getParameter("mota");
    float gia = Float.parseFloat(request.getParameter("gianiemyet"));
    float chietkhau = Float.parseFloat(request.getParameter("chietkhau"));
    float lastprice = gia*chietkhau/100;

    PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Giá Sau chiết khấu là</h1>");
        writer.println("<h1>" + lastprice + "</h1>");
        writer.println("</html>");
    }
}
