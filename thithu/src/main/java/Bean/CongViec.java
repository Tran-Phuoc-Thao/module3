package Bean;

public class CongViec {
    private String maCongViec;
    private String tenCongViec;
    private float luongThapNhat;
    private float luongCaoNhat;

    public CongViec(String maCongViec, String tenCongViec, float luongThapNhat, float luongCaoNhat) {
        this.maCongViec = maCongViec;
        this.tenCongViec = tenCongViec;
        this.luongThapNhat = luongThapNhat;
        this.luongCaoNhat = luongCaoNhat;
    }

    public String getMaCongViec() {
        return maCongViec;
    }

    public void setMaCongViec(String maCongViec) {
        this.maCongViec = maCongViec;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }

    public float getLuongThapNhat() {
        return luongThapNhat;
    }

    public void setLuongThapNhat(float luongThapNhat) {
        this.luongThapNhat = luongThapNhat;
    }

    public float getLuongCaoNhat() {
        return luongCaoNhat;
    }

    public void setLuongCaoNhat(float luongCaoNhat) {
        this.luongCaoNhat = luongCaoNhat;
    }


}
