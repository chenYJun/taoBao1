package service;

import java.util.List;

import model.Category;

/**
 * Created by chen on 15-5-13.
 */
public interface ICategoryService {
    /**
     * 得到系统所有类别
     * @return
     */
    public List<Category> getAllCategory();

    /**
     * 根据类别Id获取
     * @param categoryId
     * @return
     */
    public Category getCategoryById(int categoryId);
}
