package service;

import bean.Product;

import java.util.List;

public interface ProductService {
    boolean save(Product product);
    boolean update(Product product);
    Product findById(int id);
    List<Product> findAll();
    boolean delete(int id);
}
