package caculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "com.example.demo.Servlet", value = "/calculator")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("calculator.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float a =Float.parseFloat(request.getParameter("a"));
        float b =Float.parseFloat(request.getParameter("b"));
        float c = 0.0F;
        int phepToan = Integer.parseInt(request.getParameter("pheptoan"));
            switch (phepToan) {
                case 1:
                    c = a + b;
                    break;
                case 2:
                    c = a - b;
                    break;
                case 3:
                    c = a * b;
                    break;
                case 4:
                    c = a / b;
                    break;
            }
            request.setAttribute("c",c);
            request.getRequestDispatcher("display.jsp").forward(request, response);
    }
}
