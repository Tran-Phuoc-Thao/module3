package Repository;

import Bean.Role;
import Bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryUser {
    private String jdbcURL = "jdbc:mysql://localhost:3306/User?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    private static final String SELECT_ALL = "select * from User";

    public List<User> selectAll() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        java.util.List<User> list = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("fullName");
                String code = rs.getString("code");
                String ngaySinh = rs.getString("ngaySinh");
                String thoiGian = rs.getString  ("thoiGian");
                User user = new User(id,fullName,code,ngaySinh,thoiGian);
                list.add(user);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    private static final String SELECT_ID = "select * from User where id =?";
    public User select(int id) {
        User user  = null;
        // Step 1: Thiết lập kết nối
        try (Connection connection = getConnection();
             // Step 2:Tạo câu lệnh sử dụng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Thực hiện truy vấn hoặc cập nhật truy vấn
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id1 = rs.getInt("id");
                String fullName = rs.getString("fullName");
                String code = rs.getString("code");
                String ngaySinh = rs.getString("ngaySinh");
                String thoiGian = rs.getString("thoiGian");
                user = new User(id,fullName,code,ngaySinh,thoiGian);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }


    private static final String INSERT_SQL = "INSERT INTO User" + "  (fullName,code,ngaySinh,thoiGian) VALUES " +
            " (?, ?, ?, ?);";
    public void insert(User user) throws SQLException {
        System.out.println(INSERT_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL))
        {
            preparedStatement.setString(1,user.getFullName());
            preparedStatement.setString(2,user.getCode());
            preparedStatement.setString(3,user.getNgaySinh());
            preparedStatement.setString(4,user.getThoiGian());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
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
