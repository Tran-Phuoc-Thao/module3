package Controller;

import Bean.Role;
import Bean.User;
import Bean.UserAndRole;
import Service.ServiceRole;
import Service.ServiceUser;
import Service.ServiceUserAndRole;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "Servlet", value = "/UserAndRole")
public class Servlet extends HttpServlet {

    ServiceRole serviceRole = new ServiceRole();
    ServiceUser serviceUser = new ServiceUser();
    ServiceUserAndRole serviceUserAndRole = new ServiceUserAndRole();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
//        try {

            switch (action) {

                case "delete":
                    delete(request, response);
                    break;
                case "search":
                    searchByName(request,response);
                    break;
                default:
                    list(request, response);
                    break;
            }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {

    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Role> list =serviceRole.findAll();
        request.setAttribute("list", list);
        List<User> list1 = serviceUser.findAll() ;
        request.setAttribute("list1",list1);
        List<UserAndRole> list3 = serviceUserAndRole.findAll() ;
        request.setAttribute("list3",list3);
        request.getRequestDispatcher("list.jsp").forward(request,response);
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

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String code = request.getParameter("code");
        String ngaySinh = request.getParameter("ngaySinh");
        String thoiGian = request.getParameter("thoiGian");
        User user = new User(fullName,code,ngaySinh,thoiGian);
        serviceUser.insert(user);
        int idRole = Integer.parseInt(request.getParameter("idRole"));
        Role role = serviceRole.select(idRole);

        request.setAttribute("list",list);
        List<Locale.Category> list1 = servicePhuImp.selectAll();
        request.setAttribute("list1",list1);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
