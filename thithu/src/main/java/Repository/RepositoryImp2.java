package Repository;

import Bean.CongViec;
import Bean.NhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImp2 implements IRepository{
    private String jdbcURL = "jdbc:mysql://localhost:3306/nhanvien?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";


    private static final String SELECT_ALL_CONGVIEC = "select * from congviec";
    private static final String SELECT_USER_BY_MACONGVIEC = "select maCongViec,tenCongViec,luongThapNhat,luongCaoNhat from congviec where maCongViec =?";

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

    public List<CongViec> selectAll() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        java.util.List<CongViec> congViecs = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONGVIEC);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String maCongViec = rs.getString("maCongViec");
                String tenCongViec = rs.getString("tenCongViec");
                float luongThapNhat = Float.parseFloat(rs.getString("luongThapNhat"));
                float luongCaoNhat = Float.parseFloat(rs.getString("luongCaoNhat"));
                CongViec congViec = new CongViec(maCongViec,tenCongViec,luongThapNhat,luongCaoNhat);
                congViecs.add(congViec);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return congViecs;
    }



    public CongViec select(String maCongViec) {
        CongViec congViec = null;
        // Step 1: Thiết lập kết nối
        try (Connection connection = getConnection();
             // Step 2:Tạo câu lệnh sử dụng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_MACONGVIEC);) {
            preparedStatement.setString(1, maCongViec);
            System.out.println(preparedStatement);
            // Step 3: Thực hiện truy vấn hoặc cập nhật truy vấn
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String maCongViec1 = rs.getString("maCongViec");
                String tenCongViec = rs.getString("tenCongViec");
                float luongThapNhat = Float.parseFloat(rs.getString("luongThapNhat"));
                float luongCaoNhat = Float.parseFloat(rs.getString("luongCaoNhat"));
                congViec = new CongViec(maCongViec1,tenCongViec,luongThapNhat,luongCaoNhat);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return congViec;
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
