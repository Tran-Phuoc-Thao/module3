package bai11.Repository;

import bai11.Bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepImp implements IProductRep {
    private static Map<String, Product> productMap = new HashMap<>();

    static {
        productMap.put("PD01", new Product("PD01","Nhà biệt Thự",2500000,"https://img.thuthuatphanmem.vn/uploads/2018/10/09/anh-nha-3d-dep-mat_041507591.jpg"));
        productMap.put("PD02", new Product("PD02","Villa",2500000,"https://img.thuthuatphanmem.vn/uploads/2018/10/09/anh-nha-dep_041508154.jpg"));
        productMap.put("PD03", new Product("PD03","Nhà cấp 4",2500000,"https://tse1.mm.bing.net/th?id=OIP.8vabXQxFDDhwiLelLLOq1QHaFj&pid=Api&P=0"));
        productMap.put("PD04", new Product("PD04","Nhà tranh",2500000,"https://tse3.mm.bing.net/th?id=OIP.biqo-yR6bg2iFPZxKZVWeAHaE7&pid=Api&P=0"));

    }



    public void create(Product product) {
        if (!productMap.containsKey(product.getId())) {
            productMap.put(product.getId(), product);
        }
    }

    public void delete(String id) {
        productMap.remove(id);
    }


    public List<Product> findAll(){
        return new ArrayList<>(productMap.values());
    }

    public Product findById(String id) {
        return productMap.get(id);
    }

    public void update(Product product) {
        if (productMap.containsKey(product.getId())) {
            productMap.put(product.getId(), product);
        }
    }


}
