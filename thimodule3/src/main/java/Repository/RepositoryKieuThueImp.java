package Repository;

import Bean.KieuThue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryKieuThueImp implements RepositoryKieuThue {
    private String jdbcURL = "jdbc:mysql://localhost:3306/user?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";


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

    private static final String SELECT_ALL = "select * from kieuThue";

    public List<KieuThue> selectAll() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        java.util.List<KieuThue> list = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idThanhToan = rs.getInt("idThanhToan");
                String nameThanhToan = rs.getString("nameThanhToan");
                KieuThue kieuThue = new KieuThue(idThanhToan,nameThanhToan);
                list.add(kieuThue);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }


    private static final String SELECT = "select * from kieuthue where idThanhToan =?";
    public KieuThue select(int idThanhToan) {
        KieuThue kieuThue = null;
        // Step 1: Thiết lập kết nối
        try (Connection connection = getConnection();
             // Step 2:Tạo câu lệnh sử dụng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
            preparedStatement.setInt(1, idThanhToan);
            System.out.println(preparedStatement);
            // Step 3: Thực hiện truy vấn hoặc cập nhật truy vấn
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idThanhToan1 = rs.getInt("idThanhToan");
                String nameThanhToan = rs.getString("nameThanhToan");
                kieuThue = new KieuThue(idThanhToan,nameThanhToan);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return kieuThue;
    }

}
