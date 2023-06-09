package repository;

import bean.Product;

import java.util.List;

public interface ProductRepository {
    boolean save(Product product);
    boolean update(Product product);
    Product findById(int id);
    List<Product> findAll();
    boolean delete(int id);
}
