package Controller;

import Bean.KieuThue;
import Bean.PhongTro;
import Service.ServiceKieuThueImp;
import Service.ServicePhongTroImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/Thi")
public class Servlet extends HttpServlet {

    ServiceKieuThueImp serviceKieuThueImp = new ServiceKieuThueImp();
    ServicePhongTroImp servicePhongTroImp = new ServicePhongTroImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {

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
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenNguoiThue = request.getParameter("tenNguoiThue");
        int maPhongTro = Integer.parseInt(request.getParameter("maPhongTro"));
        String soDienThoai = request.getParameter("soDienThoai");
        List<PhongTro> list = servicePhongTroImp.search(maPhongTro,tenNguoiThue,soDienThoai);
        request.setAttribute("list",list);
        List<KieuThue> list1 = serviceKieuThueImp.selectAll() ;
        request.setAttribute("list1",list1);
        request.getRequestDispatcher("list.jsp").forward(request,response);


    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PhongTro> list =servicePhongTroImp.findAll();
        request.setAttribute("list", list);
        List<KieuThue> list1 = serviceKieuThueImp.selectAll() ;
        request.setAttribute("list1",list1);
        request.getRequestDispatcher("list.jsp").forward(request,response);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int maPhongTro = Integer.parseInt(request.getParameter("maPhongTro"));
        servicePhongTroImp.delete(maPhongTro);
        List<PhongTro> list = servicePhongTroImp.findAll();
        request.setAttribute("list",list);
        List<KieuThue> list1 = serviceKieuThueImp.selectAll() ;
        request.setAttribute("list1",list1);
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
            }
        }catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String tenNguoiThueTro = request.getParameter("tenNguoiThueTro");
        String soDienThoai = request.getParameter("soDienThoai");
        String ngayBatDauThue = request.getParameter("ngayBatDauThue");
        int idThanhToan = Integer.parseInt(request.getParameter("idThanhToan"));
        String ghiChu = request.getParameter("ghiChu");
        KieuThue kieuThue = serviceKieuThueImp.select(idThanhToan);
        PhongTro phongTro = new PhongTro(tenNguoiThueTro,soDienThoai,ngayBatDauThue,kieuThue,ghiChu);
        servicePhongTroImp.insert(phongTro);
        List<PhongTro> list = servicePhongTroImp.findAll();
        request.setAttribute("list",list);
        List<KieuThue> list1 = serviceKieuThueImp.selectAll();
        request.setAttribute("list1",list1);
        request.getRequestDispatcher("list.jsp").forward(request,response);

    }
}
