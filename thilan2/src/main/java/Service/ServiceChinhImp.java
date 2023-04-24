package Service;

import Bean.Product;
import Repository.RepositoryChinhImp;

import java.sql.SQLException;
import java.util.List;

public class ServiceChinhImp implements ServiceChinh{

    private RepositoryChinhImp repositoryChinhImp = new RepositoryChinhImp();

    public List<Product> findAll() {
        return repositoryChinhImp.selectAll();
    }

    public Product select(int id){
        return repositoryChinhImp.select(id);
    }
    public void insert(Product product) throws SQLException {
        repositoryChinhImp.insert(product);
    }
    public void delete(int id) throws SQLException {
        repositoryChinhImp.delete(id);
    }

    public void update(Product product) throws SQLException {
        repositoryChinhImp.update(product);
    }

    public List<Product> search(String name) {
        return repositoryChinhImp.search(name);
    }
}
