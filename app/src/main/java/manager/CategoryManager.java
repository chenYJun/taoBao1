package manager;

import java.util.List;

import daoImpl.CategoryService;
import model.Category;
import service.ICategoryService;

/**
 * Created by chen on 15-5-18.
 */
public class CategoryManager {
    private ICategoryService dao;
    public CategoryManager() {
        dao = new CategoryService();
    }
    public List<Category> getAllCategory() {
        return dao.getAllCategory();
    }
    public Category getCategoryById(int categoryId) {
        return dao.getCategoryById(categoryId);
    }

}
