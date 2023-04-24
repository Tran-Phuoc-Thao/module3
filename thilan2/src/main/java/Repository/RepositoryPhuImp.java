package Repository;

import Bean.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryPhuImp implements RepositoryPhu{

    private String jdbcURL = "jdbc:mysql://localhost:3306/thi?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";


    private static final String SELECT_ALL = "select * from category";
    private static final String SELECT = "select * from category where idType =?";

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

    public List<Category> selectAll() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        java.util.List<Category> categoryList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String idType = rs.getString("idType");
                String name = rs.getString("name");
                Category category = new Category(idType,name);
                categoryList.add(category);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categoryList;
    }



    public Category select(String idType) {
        Category category = null;
        // Step 1: Thiết lập kết nối
        try (Connection connection = getConnection();
             // Step 2:Tạo câu lệnh sử dụng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
            preparedStatement.setString(1, idType);
            System.out.println(preparedStatement);
            // Step 3: Thực hiện truy vấn hoặc cập nhật truy vấn
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String idType1 = rs.getString("idType");
                String name = rs.getString("name");
                category = new Category(idType,name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return category;
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
