package com.ftvtraining.dto;

public class ContractSearchDto {


    private Integer loaiHD;
    private String maDotTrienKhai;
    private String maChuTruong;
    private String maKenhTruyen;
    private String maNcc;
    private String soHopDong;
    private String nguoiTao;
    private Integer thoiHan;
    private  String ngayTao;
    private  String ngayKy;
    private  int page;
    private  int size;

    public Integer getLoaiHD() {
        return loaiHD;
    }

    public String getMaChuTruong() {
        return maChuTruong;
    }

    public void setMaChuTruong(String maChuTruong) {
        this.maChuTruong = maChuTruong;
    }

    public String getMaKenhTruyen() {
        return maKenhTruyen;
    }

    public void setMaKenhTruyen(String maKenhTruyen) {
        this.maKenhTruyen = maKenhTruyen;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public void setLoaiHD(Integer loaiHD) {
        this.loaiHD = loaiHD;
    }

    public String getMaDotTrienKhai() {
        return maDotTrienKhai;
    }

    public void setMaDotTrienKhai(String maDotTrienKhai) {
        this.maDotTrienKhai = maDotTrienKhai;
    }

    public Integer getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(Integer thoiHan) {
        this.thoiHan = thoiHan;
    }


    public String getMaNcc() {
        return maNcc;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(String ngayKy) {
        this.ngayKy = ngayKy;
    }

    public void setMaNcc(String maNcc) {
        this.maNcc = maNcc;
    }

    public String getSoHopDong() {
        return soHopDong;
    }

    public void setSoHopDong(String soHopDong) {
        this.soHopDong = soHopDong;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
