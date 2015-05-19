package manager;

import java.util.List;

import daoImpl.ProductService;
import model.Product;
import service.IProductService;

/**
 * Created by chen on 15-5-18.
 */
public class ProductManager {
    private IProductService dao = null;
    public ProductManager(){
        dao = new ProductService();
    }
    public List<Product> GetProductByPager(int pageIndex, int pageSize) {
        return this.dao.getByPager(pageIndex, pageSize);
    }
    public List<Product> getProductByName(String name) {
        return this.dao.getByName(name);
    }
    public Product getProductById(int id) {
        return this.dao.getProductById(id);
    }
    public boolean AddProduct(Product p) {
        try {
            this.dao.insert(p);
            return true;
        } catch (Exception e) {
            throw e;
        }

    }
    public boolean AddProduct(int id, String name, double unitPrice, int photo, int categoryId, String note)
            throws Exception{
        Product p = new Product(id, name, unitPrice, photo, categoryId, note);
        return this.AddProduct(p);
    }
    public boolean ModifyProduct(Product p) {
        try {
            this.dao.modify(p);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    public boolean ModifyProduct(int id, String name, int categoryId, int photo, double unitPrice, String note)
        throws Exception {
        Product p = this.getProductById(id);
        p.setName(name);
        p.setCategoryId(categoryId);
        p.setNote(note);
        p.setPhoto(photo);
        p.setUnitPrice(unitPrice);
        return this.ModifyProduct(p);
    }
    public boolean DelProduct(int id) {
        try {
            this.dao.del(id);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean DelProduct(Product p) throws Exception {
        return DelProduct(p.getId());
    }
}
