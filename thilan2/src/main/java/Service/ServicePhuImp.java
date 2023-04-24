package Service;

import Bean.Category;
import Repository.RepositoryPhuImp;

import java.util.List;

public class ServicePhuImp implements ServicePhu {

    RepositoryPhuImp repositoryPhuImp = new RepositoryPhuImp();

    public List<Category> selectAll() {
        return repositoryPhuImp.selectAll();
    }

    public Category select(String idType) {
        return repositoryPhuImp.select(idType);
    }

}
