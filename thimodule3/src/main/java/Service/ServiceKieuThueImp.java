package Service;

import Bean.KieuThue;
import Repository.RepositoryKieuThueImp;

import java.util.List;

public class ServiceKieuThueImp {

    private RepositoryKieuThueImp repositoryKieuThueImp = new RepositoryKieuThueImp();

    public List<KieuThue> selectAll() {
        return repositoryKieuThueImp.selectAll();
    }

    public KieuThue select(int idThanhToan) {
        return repositoryKieuThueImp.select(idThanhToan);
    }
}
