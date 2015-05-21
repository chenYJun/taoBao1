package model;

import taobao.cnjun.taobao1.R;

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
        if (this.id == 1) {
            return R.drawable.p1;
        } else if (this.id == 2) {
            return R.drawable.p2;
        } else if (this.id == 3) {
            return R.drawable.p3;
        } else if (this.id == 4) {
            return R.drawable.p4;
        } else if (this.id == 5) {
            return R.drawable.p5;
        } else if (this.id == 6) {
            return R.drawable.p6;
        } else if (this.id == 7) {
            return R.drawable.p7;
        } else if (this.id == 8) {
            return R.drawable.p8;
        } else if (this.id == 9) {
            return R.drawable.p9;
        } else if (this.id == 10) {
            return R.drawable.p10;
        } else if (this.id == 11) {
            return R.drawable.p11;
        } else if (this.id == 12){
            return R.drawable.p12;
        }
        return R.drawable.p1;

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
