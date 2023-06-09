package Service;

import Bean.Role;
import Bean.User;
import Bean.UserAndRole;
import Repository.RepositoryUser;

import java.sql.SQLException;
import java.util.List;

public class ServiceUser {
    RepositoryUser repositoryUser = new RepositoryUser();
    public List<User> findAll() {
        return repositoryUser.selectAll();
    }
    public User select(int id){
        return repositoryUser.select(id);
    }
    public void insert(User user) throws SQLException {
        repositoryUser.insert(user);
    }
}
