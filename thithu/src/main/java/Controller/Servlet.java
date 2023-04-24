package Controller;

import Bean.CongViec;
import Bean.NhanVien;
import Repository.RepositoryImp;
import Repository.RepositoryImp2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/NhanVien")
public class Servlet extends HttpServlet {
    RepositoryImp nhanVien = new RepositoryImp();
    RepositoryImp2 congViecs = new RepositoryImp2();
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
                    search(request,response);
                    break;
                default:
                    listNhanVien(request, response);
                    break;
            }
        } catch (SQLException ex) {
        throw new ServletException(ex);
    }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maNhanVien = request.getParameter("maNhanVien");
        String hoTen = request.getParameter("hoTen");
        List<NhanVien> list = nhanVien.search(maNhanVien,hoTen);
        request.setAttribute("list",list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String maNhanVien = request.getParameter("id");
        nhanVien.delete(maNhanVien);
        List<NhanVien> list = nhanVien.selectAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CongViec> list = congViecs.selectAll();
        request.setAttribute("list",list);
        String id = request.getParameter("id");
        NhanVien nhanVien1 = nhanVien.select(id);
        request.setAttribute("nhanVien",nhanVien1);
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }

    private void showCreat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<CongViec> list = congViecs.selectAll();
            request.setAttribute("listCongViec",list);
            request.getRequestDispatcher("create.jsp").forward(request,response);
    }


    private void listNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<NhanVien> listNhanVien = nhanVien.selectAll();
            request.setAttribute("list", listNhanVien);
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


    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String maNhanVien = request.getParameter("maNhanVien");
        String hoTen = request.getParameter("hoTen");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChi = request.getParameter("diaChi");
        String ngayBatDau = request.getParameter("ngayBatDau");
        String ngayKetThuc = request.getParameter("ngayKetThuc");
        float luong = Float.parseFloat(request.getParameter("luong"));
        String maCongViec = request.getParameter("maCongViec");
        CongViec congViec = congViecs.select(maCongViec);
        NhanVien nhanVien1 = new NhanVien(maNhanVien,hoTen,ngaySinh,diaChi,ngayBatDau,ngayKetThuc,luong,congViec);
        nhanVien.update(nhanVien1);
        request.getRequestDispatcher("edit.jsp").forward(request,response);


    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String maNhanVien = request.getParameter("maNhanVien");
        String hoTen = request.getParameter("hoTen");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChi = request.getParameter("diaChi");
        String ngayBatDau = request.getParameter("ngayBatDau");
        String ngayKetThuc = request.getParameter("ngayKetThuc");
        float luong = Float.parseFloat(request.getParameter("luong"));
        String maCongViec = request.getParameter("maCongViec");
        CongViec congViec = congViecs.select(maCongViec);
        NhanVien nhanVien1 = new NhanVien(maNhanVien,hoTen,ngaySinh,diaChi,ngayBatDau,ngayKetThuc,luong,congViec);
        nhanVien.insert(nhanVien1);
        List<NhanVien> list = nhanVien.selectAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
