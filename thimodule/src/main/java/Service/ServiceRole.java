package Service;

import Bean.Role;
import Repository.RepositoryRole;

import java.sql.SQLException;
import java.util.List;

public class ServiceRole {
    RepositoryRole repositoryRole = new RepositoryRole();
    public List<Role> findAll() {
        return repositoryRole.selectAll();
    }
    public Role select(int id){
        return repositoryRole.select(id);
    }


}
