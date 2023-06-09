package Bean;

public class User {
    private int id;
    private String fullName;
    private String code;
    private String ngaySinh;
    private String thoiGian;

    public User(int id, String fullName, String code, String ngaySinh, String thoiGian) {
        this.id = id;
        this.fullName = fullName;
        this.code = code;
        this.ngaySinh = ngaySinh;
        this.thoiGian = thoiGian;
    }

    public User(String fullName, String code, String ngaySinh, String thoiGian) {
        this.fullName = fullName;
        this.code = code;
        this.ngaySinh = ngaySinh;
        this.thoiGian = thoiGian;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
}
