package Service;


import Bean.UserAndRole;
import Repository.RepositoryUserAndRole;

import java.util.List;

public class ServiceUserAndRole {
    RepositoryUserAndRole repositoryUserAndRole = new RepositoryUserAndRole();
    public List<UserAndRole> findAll() {
        return repositoryUserAndRole.selectAll();
    }
}
