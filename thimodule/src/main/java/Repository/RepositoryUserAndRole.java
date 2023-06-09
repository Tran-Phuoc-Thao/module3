package Repository;

import Bean.Role;
import Bean.User;
import Bean.UserAndRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryUserAndRole {
    private String jdbcURL = "jdbc:mysql://localhost:3306/User?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";


    private static final String SELECT_ALL = "select u.id,u.fullName,u.code,u.ngaySinh,u.thoiGian,r.id,r.roleName  from userandrole ual join user u on u.id = ual.idUser join Role r on r.id = ual.idRole ";

    public List<UserAndRole> selectAll() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        java.util.List<UserAndRole> list = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idUser = rs.getInt(1);
                String fullName = rs.getString(2);
                String code = rs.getString(3);
                String ngaySinh = rs.getString(4);
                String thoiGian = rs.getString(5);
                User user = new User(idUser,fullName,code,ngaySinh,thoiGian);
                int idRole = rs.getInt(6);
                String roleName = rs.getString(7);
                Role role = new Role(idRole,roleName);
                UserAndRole ual = new UserAndRole(role,user);
                list.add(ual);
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
