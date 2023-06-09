package Service;

import Bean.PhongTro;
import Repository.RepositoryPhongTro;
import Repository.RepositoryPhongTroImp;

import java.sql.SQLException;
import java.util.List;

public class ServicePhongTroImp implements ServicePhongTro {
    private RepositoryPhongTroImp repositoryPhongTro = new RepositoryPhongTroImp();

    public List<PhongTro> findAll() {
        return repositoryPhongTro.selectAll();
    }

    public PhongTro select(int id){
        return repositoryPhongTro.select(id);
    }
    public void insert(PhongTro phongTro) throws SQLException {
        repositoryPhongTro.insert(phongTro);
    }

    public void delete(int id) throws SQLException {
        repositoryPhongTro.delete(id);
    }

    public List<PhongTro> search(int maPhongTro,String tenNguoiThue,String soDienThoai) {
        return repositoryPhongTro.search(maPhongTro, tenNguoiThue, soDienThoai);
    }

}
