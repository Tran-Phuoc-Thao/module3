package Bean;

public class KieuThue {
    private int idThanhToan;
    private String nameThanhToan;


    public KieuThue(int idThanhToan, String nameThanhToan) {
        this.idThanhToan = idThanhToan;
        this.nameThanhToan = nameThanhToan;
    }

    public int getIdThanhToan() {
        return idThanhToan;
    }

    public void setIdThanhToan(int idThanhToan) {
        this.idThanhToan = idThanhToan;
    }

    public String getNameThanhToan() {
        return nameThanhToan;
    }

    public void setNameThanhToan(String nameThanhToan) {
        this.nameThanhToan = nameThanhToan;
    }
}
