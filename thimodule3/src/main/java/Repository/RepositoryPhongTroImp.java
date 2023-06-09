package Repository;

import Bean.KieuThue;
import Bean.PhongTro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryPhongTroImp implements RepositoryPhongTro {
    private String jdbcURL = "jdbc:mysql://localhost:3306/user?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    RepositoryKieuThueImp repositoryKieuThueImp = new RepositoryKieuThueImp();
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

    private static final String SELECT_ALL = "select * from phongtro";
    public List<PhongTro> selectAll() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        java.util.List<PhongTro> list = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maPhongTro = rs.getInt("maPhongTro");
                String tenNguoiThue = rs.getString("tenNguoiThue");
                String soDienThoai = rs.getString("soDienThoai");
                String ngayBatDauThue = rs.getString("ngayBatDauThue");
                int idThanhToan = rs.getInt("idThanhToan");
                String ghiChu = rs.getString("ghiChu");
                KieuThue kieuThue =  repositoryKieuThueImp.select(idThanhToan);
                PhongTro phongTro = new PhongTro(maPhongTro,tenNguoiThue,soDienThoai,ngayBatDauThue,kieuThue,ghiChu);
                list.add(phongTro);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    private static final String SELECT_ID = "select * from phongTro where maPhongTro =?";
    public PhongTro select(int maPhongTro) {
        PhongTro phongTro = null;
        // Step 1: Thiết lập kết nối
        try (Connection connection = getConnection();
             // Step 2:Tạo câu lệnh sử dụng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID);) {
            preparedStatement.setInt(1, maPhongTro);
            System.out.println(preparedStatement);
            // Step 3: Thực hiện truy vấn hoặc cập nhật truy vấn
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maPhongTro1 = rs.getInt("maPhongTro");
                String tenNguoiThue = rs.getString("tenNguoiThue");
                String soDienThoai = rs.getString("soDienThoai");
                String ngayBatDauThue = rs.getString("ngayBatDauThue");
                int idThanhToan = rs.getInt("idThanhToan");
                String ghiChu = rs.getString("ghiChu");
                KieuThue kieuThue =  repositoryKieuThueImp.select(idThanhToan);
                phongTro = new PhongTro(maPhongTro,tenNguoiThue,soDienThoai,ngayBatDauThue,kieuThue,ghiChu);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return phongTro;
    }

    private static final String INSERT_SQL = "INSERT INTO phongTro" + "  (tenNguoiThue,soDienThoai,ngayBatDauThue,idThanhToan,ghiChu) VALUES " +
            " (?, ?, ?, ?, ?);";
    public void insert(PhongTro phongTro) throws SQLException {
        System.out.println(INSERT_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL))
        {
            preparedStatement.setString(1,phongTro.getTenNguoiThueTro());
            preparedStatement.setString(2,phongTro.getSoDienThoai());
            preparedStatement.setString(3,phongTro.getNgayBatDauThue());
            preparedStatement.setInt(4,phongTro.getKieuThue().getIdThanhToan());
            preparedStatement.setString(5,phongTro.getGhiChu());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private static final String DELETE = "delete from phongTro where maPhongTro = ?;";
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }


    private static final String SEARCH_NAME = "select * from phongTro where maPhongTro like ? and tenNguoiThue like ? and soDienThoai like ?";

    public List<PhongTro> search(int maPhongTro,String tenNguoiThue,String soDienThoai) {
        List<PhongTro> list = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME);) {
            preparedStatement.setString(1,"%"+maPhongTro+"%");
            preparedStatement.setString(2, "%"+tenNguoiThue+"%");
            preparedStatement.setString(3, "%"+soDienThoai+"%");

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maPhongTro1 = rs.getInt("maPhongTro");
                String tenNguoiThue1 = rs.getString("tenNguoiThue");
                String soDienThoai1 = rs.getString("soDienThoai");
                String ngayBatDauThue = rs.getString("ngayBatDauThue");
                int idThanhToan = rs.getInt("idThanhToan");
                String ghiChu = rs.getString("ghiChu");
                KieuThue kieuThue =  repositoryKieuThueImp.select(idThanhToan);
                PhongTro phongTro = new PhongTro(maPhongTro1,tenNguoiThue1,soDienThoai1,ngayBatDauThue,kieuThue,ghiChu);
                list.add(phongTro);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }












}
