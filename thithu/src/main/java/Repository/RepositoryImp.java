package Repository;

import Bean.CongViec;
import Bean.NhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImp {
    private String jdbcURL = "jdbc:mysql://localhost:3306/nhanvien?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";


    private static final String SELECT_ALL = "select * from nhanvien";
    private static final String INSERT_SQL = "INSERT INTO nhanvien" + "  (maNhanVien,hoTen,ngaySinh,diaChi,ngayBatDau,ngayKetThuc,luong,maCongViec) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ID = "select * from nhanvien where maNhanVien =?";

    private static final String UPDATE = "update nhanvien set hoTen = ?,ngaySinh= ?, diaChi =?,ngayBatDau =?,ngayKetThuc=?,luong=?,maCongViec=?  where maNhanVien = ?;";

    private static final String DELETE = "delete from nhanvien where maNhanVien = ?;";
    private static final String SEARCH_NAME = "select * from nhanvien where maNhanVien like ? and hoTen like ?";
    RepositoryImp2 congViecRep = new RepositoryImp2();

    public List<NhanVien> selectAll() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        java.util.List<NhanVien> nhanViens = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String maNhanVien = rs.getString("maNhanVien");
                String hoTen = rs.getString("hoTen");
                String ngaySinh = rs.getString("ngaySinh");
                String diaChi = rs.getString("diaChi");
                String ngayBatDau = rs.getString("ngayBatDau");
                String ngayKetThuc = rs.getString("ngayKetThuc");
                float luong = rs.getFloat("luong");
                String maCongViec = rs.getString("maCongViec");
                CongViec congViec = congViecRep.select(maCongViec);
                NhanVien nhanVien = new NhanVien(maNhanVien,hoTen,ngaySinh,diaChi,ngayBatDau,ngayKetThuc,luong,congViec);
                nhanViens.add(nhanVien);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return nhanViens;
    }

    public NhanVien select(String maNhanVien) {
        NhanVien nhanVien = null;
        // Step 1: Thiết lập kết nối
        try (Connection connection = getConnection();
             // Step 2:Tạo câu lệnh sử dụng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID);) {
            preparedStatement.setString(1, maNhanVien);
            System.out.println(preparedStatement);
            // Step 3: Thực hiện truy vấn hoặc cập nhật truy vấn
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String hoTen = rs.getString("hoTen");
                String ngaySinh = rs.getString("ngaySinh");
                String diaChi = rs.getString("diaChi");
                String ngayBatDau = rs.getString("ngayBatDau");
                String ngayKetThuc = rs.getString("ngayKetThuc");
                float luong = rs.getFloat("luong");
                String maCongViec = rs.getString("maCongViec");
                CongViec congViec = congViecRep.select(maCongViec);
                nhanVien = new NhanVien(maNhanVien,hoTen,ngaySinh,diaChi,ngayBatDau,ngayKetThuc,luong,congViec);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return nhanVien;
    }


    public void insert(NhanVien nhanVien) throws SQLException {
        System.out.println(INSERT_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL))
        {
            preparedStatement.setString(1,nhanVien.getMaNhanVien() );
            preparedStatement.setString(2,nhanVien.getHoTen());
            preparedStatement.setString(3,nhanVien.getNgaySinh());
            preparedStatement.setString(4,nhanVien.getDiaChi());
            preparedStatement.setString(5,nhanVien.getNgayBatDau());
            preparedStatement.setString(6,nhanVien.getNgayKetThuc());
            preparedStatement.setFloat(7,nhanVien.getLuong());
            preparedStatement.setString(8,nhanVien.getCongViec().getMaCongViec());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public boolean update(NhanVien nhanVien) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE);) {

            statement.setString(1, nhanVien.getHoTen());
            statement.setString(2, nhanVien.getNgaySinh());
            statement.setString(3, nhanVien.getDiaChi());
            statement.setString(4, nhanVien.getNgayBatDau());
            statement.setString(5, nhanVien.getNgayKetThuc());
            statement.setFloat(6, nhanVien.getLuong());
            statement.setString(7, nhanVien.getCongViec().getMaCongViec());
            statement.setString(8, nhanVien.getMaNhanVien());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean delete(String maNhanVien) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE);) {
            statement.setString(1, maNhanVien);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }


    public List<NhanVien> search(String maNhanVien,String hoTen) {
        List<NhanVien> list = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME);) {
            preparedStatement.setString(1, maNhanVien+"%");
            preparedStatement.setString(2, hoTen+"%");
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String maNhanVien1 = rs.getString("maNhanVien");
                String hoTen1 = rs.getString("hoTen");
                String ngaySinh = rs.getString("ngaySinh");
                String diaChi = rs.getString("diaChi");
                String ngayBatDau = rs.getString("ngayBatDau");
                String ngayKetThuc = rs.getString("ngayKetThuc");
                float luong = rs.getFloat("luong");
                String maCongViec = rs.getString("maCongViec");
                CongViec congViec = congViecRep.select(maCongViec);
                NhanVien nhanVien = new NhanVien(maNhanVien1,hoTen1,ngaySinh,diaChi,ngayBatDau,ngayKetThuc,luong,congViec);
                list.add(nhanVien);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
