package daoImpl;

import java.util.ArrayList;
import java.util.List;

import model.Category;
import service.ICategoryService;

/**
 * Created by chen on 15-5-18.
 */
public class CategoryService implements ICategoryService {
    List<Category> categories = new ArrayList<Category>();
    @Override
    public List<Category> getAllCategory() {

        categories.add(new Category(1, "手机"));
        categories.add(new Category(2, "电器"));
        categories.add(new Category(3, "服装"));
        categories.add(new Category(4, "图书"));

        return categories;
    }

    @Override
    public Category getCategoryById(int categoryId) {
        if (categories != null)
            return this.categories.get(categoryId - 1);
        else
            return null;

    }
}
