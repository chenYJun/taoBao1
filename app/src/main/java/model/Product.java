package model;

/**
 * 产品
 * Created by chen on 15-5-13.
 */
public class Product {
    private int id;
    /**
     * 商品名
     */
    private String name;
    /**
     *
     */
    private int categoryId;
    /**
     * 商品图片
     */
    private int image;
    /**
     * 手机号
     */
    private int photo;
    /**
     * 价格
     */
    private double unitPrice;
    /**
     * 编号
     */
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", image=" + image +
                ", photo=" + photo +
                ", unitPrice=" + unitPrice +
                ", note='" + note + '\'' +
                '}';
    }

    public Product(int id, String name, double unitPrice, int photo, int categoryId, String note) {
        this.id = id;
        this.note = note;
        this.unitPrice = unitPrice;
        this.photo = photo;
        this.categoryId = categoryId;
        this.name = name;
    }
}
