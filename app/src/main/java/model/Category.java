package model;

/**
 * 类别实体
 * Created by chen on 15-5-13.
 */
public class Category {
    private int categoryId;
    private String categoryName;



    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

   public Category(int categoryId, String categoryName) {
       super();
       this.categoryId = categoryId;
       this.categoryName = categoryName;
   }

    public Category(){

    }
}
