package Repository;

import Bean.Category;
import Bean.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RepositoryChinhImp implements RepositoryChinh {

    private String jdbcURL = "jdbc:mysql://localhost:3306/thi?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    RepositoryPhuImp repositoryPhuImp = new RepositoryPhuImp();

    private static final String SELECT_ALL = "select * from product";
    public List<Product> selectAll() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        java.util.List<Product> productList = new ArrayList<>();
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
                String name = rs.getString("name");
                Float gia = rs.getFloat("gia");
                int soLuong = rs.getInt("soLuong");
                String mauSac = rs.getString("mauSac");
                String moTa = rs.getString("moTa");
                String idType = rs.getString("idType");
                Category category = repositoryPhuImp.select(idType);
                Product product = new Product(id,name,gia,soLuong,mauSac,moTa,category);
                productList.add(product);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return productList;
    }


    private static final String SELECT_ID = "select * from product where id =?";
    public Product select(int id) {
        Product product = null;
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
                String name = rs.getString("name");
                Float gia = rs.getFloat("gia");
                int soLuong = rs.getInt("soLuong");
                String mauSac = rs.getString("mauSac");
                String moTa = rs.getString("moTa");
                String idType = rs.getString("idType");
                Category category = repositoryPhuImp.select(idType);
                product = new Product(id1,name,gia,soLuong,mauSac,moTa,category);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

    private static final String INSERT_SQL = "INSERT INTO product" + "  (name,gia,soLuong,mauSac,moTa,idType) VALUES " +
            " (?, ?, ?, ?, ?, ?);";
    public void insert(Product product) throws SQLException {
        System.out.println(INSERT_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL))
        {
            preparedStatement.setString(1,product.getName());
            preparedStatement.setFloat(2,product.getGia());
            preparedStatement.setInt(3,product.getSoLuong());
            preparedStatement.setString(4,product.getMauSac());
            preparedStatement.setString(5,product.getMoTa());
            preparedStatement.setString(6,product.getCategory().getIdType());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private static final String UPDATE = "update product set name =?, gia =?,soLuong =?,mauSac=?,moTa=?,idType=?  where id = ?;";
    public boolean update(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE);) {

            statement.setString(1, product.getName());
            statement.setFloat(2, product.getGia());
            statement.setInt(3, product.getSoLuong());
            statement.setString(4, product.getMauSac());
            statement.setString(5, product.getMoTa());
            statement.setString(6, product.getCategory().getIdType());
            statement.setInt(7,product.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private static final String DELETE = "delete from product where id = ?;";
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    private static final String SEARCH_NAME = "select * from product where name like ?";
    public List<Product> search(String name) {
        List<Product> list = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME);) {
            preparedStatement.setString(1, "%"+name+"%");
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                Float gia = rs.getFloat("gia");
                int soLuong = rs.getInt("soLuong");
                String mauSac = rs.getString("mauSac");
                String moTa = rs.getString("moTa");
                String idType = rs.getString("idType");
                Category category = repositoryPhuImp.select(idType);
                Product product = new Product(id,name1,gia,soLuong,mauSac,moTa,category);
                list.add(product);
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
