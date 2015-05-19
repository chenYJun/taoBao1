package daoImpl;

import java.util.ArrayList;
import java.util.List;

import model.Product;
import service.IProductService;
import taobao.cnjun.taobao1.R;

/**
 * Created by chen on 15-5-18.
 */
public class ProductService implements IProductService {
    List<Product> ps = null;
    public ProductService (){
        ps = new ArrayList<Product>();
        for (Product p : ps) {
            ps.add(p);
        }
    }

    private Product[] products = {
            new Product(1, "华为P8（GRA-UL10/高配版/双4G）", 118.00, 1, R.drawable.p1, "网络类型11，操作系统1"),
            new Product(2, "三星GALAXY S6（G9200/全网通）", 128.00, 1, R.drawable.p2, "网络类型12，操作系统1"),
            new Product(3, "nubia Z9（经典版/全网通）", 138.00, 1, R.drawable.p3, "网络类型13，操作系统1"),
            new Product(4, "三星GALAXY S6 Edge（G9250/全网通） ", 168.00, 1, R.drawable.p4, "网络类型14，操作系统1"),
            new Product(5, "魅族魅蓝Note（移动4G）", 168.00, 1, R.drawable.p5, "网络类型15，操作系统1"),
            new Product(6, "华为荣耀畅玩4C（CHM-CL00/电信4G）", 1681.00, 1, R.drawable.p6, "网络类型16，操作系统1"),
            new Product(7, "华硕ZenFone 2（ZE551ML/高配版/双4G）", 1648.00, 1, R.drawable.p7, "网络类型17，操作系统1"),
            new Product(8, "吕1（双4G）", 1638.00, 1, R.drawable.p8, "网络类型18，操作系统1"),
            new Product(9, "苹果iPhone 6 Plus（移动4G） ", 1658.00, 1, R.drawable.p9, "网络类型19，操作系统1"),
            new Product(10, "华硕飞马手机（X002/移动4G）", 1683.00, 1, R.drawable.p10, "网络类型110，操作系统1"),
            new Product(11, "华为荣耀畅玩4C（CHM-TL00H/移动4G）", 1618.00, 1, R.drawable.p11, "网络类型112，操作系统1"),
            new Product(12, "联想乐檬K3 Note（K50-T5/双4G）", 1168.00, 1, R.drawable.p12, "网络类型113，操作系统1")

    };

    @Override
    public List<Product> getByPager(int pageIndex, int pageSize) {
        if (pageIndex < 0)
            pageIndex = 0;
        if (pageIndex * pageSize > this.products.length)
            pageIndex = pageIndex - 1;

        List<Product> result = new ArrayList<Product>();
        for(int i=pageIndex*pageSize; i<(pageIndex+1)*pageSize; i++) {
            result.add(products[i]);
        }
        return result;
    }

    @Override
    public List<Product> getAll() {
        return ps;
    }

    @Override
    public Product getProductById(int productId) {
        for (Product p : this.ps) {
            if (p.getId() == productId) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> getByName(String name) {
        List<Product> result = new ArrayList<Product>();
        for (Product p : this.ps) {
            if (p.getName().indexOf(name) != -1) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public void insert(Product product) {
        this.ps.add(product);
    }

    @Override
    public void modify(Product product) {
        for (int i=0; i<this.ps.size(); i++){
            if(ps.get(i).getId() == product.getId()) {
                ps.set(i, product);

            }
        }
    }

    @Override
    public void del(int id) {
        Product p = this.getProductById(id);
        if (p != null)
            this.ps.remove(p);
    }
}
