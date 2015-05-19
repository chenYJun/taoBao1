package service;

import java.util.List;

import model.Product;

/**
 * Created by chen on 15-5-13.
 */
public interface IProductService {

    /**
     *  得到全部商品
     */
    public List<Product> getAll();

    /**
     * 分页获取商品信息
     * @param pageIndex 第几页，从0开始
     * @param pageSize  每页显示数
     * @return
     */
    public List<Product> getByPager(int pageIndex, int pageSize);
    /**
     * 根据主键id获取商品实体
     * @param productId
     * @return
     */
    public Product getProductById(int productId);

    /**
     * 根据商品名称进模糊查询
     * @param name
     * @return
     */
    public List<Product> getByName(String name);

    /**
     * 添加一个商品
     * @param product
     */
    public void insert(Product product);

    /**
     * 修改一个商品信息
     * @param product
     */
    public void modify(Product product);

    /**
     * 删除一个商品
     * @param id
     */
    public void del(int id);


}
