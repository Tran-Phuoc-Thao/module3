package Bean;

import java.util.Locale;

public class Product {
    private int id;
    private String name;
    private float gia;
    private int soLuong;
    private String mauSac;
    private String moTa;
    private Category category;

    public Product(int id, String name, float gia, int soLuong, String mauSac, String moTa, Category category) {
        this.id = id;
        this.name = name;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.category = category;
    }

    public Product(String name, float gia, int soLuong, String mauSac, String moTa, Category category) {
        this.name = name;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.category = category;
    }

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

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
