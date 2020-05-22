package com.test.quanlyxevantai;

public class PhieuPhanCong {
    String id, soPhieu, ngay, xuatPhat, tuyen, tinh, xe;

    public PhieuPhanCong(String id, String soPhieu, String ngay, String xuatPhat, String tuyen, String tinh, String xe) {
        this.id = id;
        this.soPhieu = soPhieu;
        this.ngay = ngay;
        this.xuatPhat = xuatPhat;
        this.tuyen = tuyen;
        this.tinh = tinh;
        this.xe = xe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PhieuPhanCong() {

    }

    public String getSoPhieu() {
        return soPhieu;
    }

    public String getNgay() {
        return ngay;
    }

    public String getXuatPhat() {
        return xuatPhat;
    }

    public String getTuyen() {
        return tuyen;
    }

    public String getTinh() {
        return tinh;
    }

    public String getXe() {
        return xe;
    }

    public void setSoPhieu(String soPhieu) {
        this.soPhieu = soPhieu;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public void setXuatPhat(String xuatPhat) {
        this.xuatPhat = xuatPhat;
    }

    public void setTuyen(String tuyen) {
        this.tuyen = tuyen;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public void setXe(String xe) {
        this.xe = xe;
    }

    @Override
    public String toString() {
        return "PhieuPhanCong{" +
                "id='" + id + '\'' +
                ", soPhieu='" + soPhieu + '\'' +
                ", ngay='" + ngay + '\'' +
                ", xuatPhat='" + xuatPhat + '\'' +
                ", tuyen='" + tuyen + '\'' +
                ", tinh='" + tinh + '\'' +
                ", xe='" + xe + '\'' +
                '}';
    }
}
