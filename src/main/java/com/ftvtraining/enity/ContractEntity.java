package com.ftvtraining.enity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "DM_HOPDONG")
public class ContractEntity {

    @Id
    @Column(name = "MA_HOP_DONG", nullable = false , length = 19)
    @NotNull(message = "Mã hợp đồng không được để trống")
    private Integer maHD;

    @Column(name = "LOAI_HOP_DONG" , length = 19)
    private Integer loaiHD;


    @Column(name = "MA_CHU_TRUONG")
    private String maChuTruong;

    @Column(name = "MA_DOT_TRIEN_KHAI")
    private String maDotChienKhai;

    @Column(name = "MA_KENH_TRUYEN")
    private String maKenhTruyen;

    @Column(name = "MA_NCC")
    private String maNCC;

    @Column(name = "MO_TA")
    private String moTa;

    @Column(name = "NGAY_KY")
    private Timestamp ngayKy;

    @Column(name = "NGAY_SUA")
    private Timestamp ngaySua;

    @Column(name = "NGAY_TAO")
    private Timestamp ngayTAO;

    @Column(name = "NGAY_THANH_LY")
    private Timestamp ngayThanhLy;

    @Column(name = "NGUOI_SUA")
    private String nguoiSua;

    @Column(name = "NGUOI_TAO")
    private String nguoiTao;

    @Column(name = "SO_HOP_DONG")
    private String soHongDong;


    @Column(name = "THOI_HAN" , length = 19)
    private Integer thoiHan;

    @Column(name = "TINH_TRANG_KENH_TRUYEN" ,  length = 19)
    private Integer tinhTrangKenhTruyen;

    @Column(name = "TINH_TRANG_THANH_LY" ,  length = 19)
    private Integer tinhTrangThanhLy;

    @Column(name = "TU_DONG_GIA_HAN" ,  length = 19)
    private Integer tuDongGiaHan;

    public Integer getMaHD() {
        return maHD;
    }

    public void setMaHD(Integer maHD) {
        this.maHD = maHD;
    }

    public Integer getLoaiHD() {
        return loaiHD;
    }

    public void setLoaiHD(Integer loaiHD) {
        this.loaiHD = loaiHD;
    }

    public String getMaChuTruong() {
        return maChuTruong;
    }

    public void setMaChuTruong(String maChuTruong) {
        this.maChuTruong = maChuTruong;
    }

    public String getMaDotChienKhai() {
        return maDotChienKhai;
    }

    public void setMaDotChienKhai(String maDotChienKhai) {
        this.maDotChienKhai = maDotChienKhai;
    }

    public String getMaKenhTruyen() {
        return maKenhTruyen;
    }

    public void setMaKenhTruyen(String maKenhTruyen) {
        this.maKenhTruyen = maKenhTruyen;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Timestamp getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(Timestamp ngayKy) {
        this.ngayKy = ngayKy;
    }

    public Timestamp getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Timestamp ngaySua) {
        this.ngaySua = ngaySua;
    }

    public Timestamp getNgayTAO() {
        return ngayTAO;
    }

    public void setNgayTAO(Timestamp ngayTAO) {
        this.ngayTAO = ngayTAO;
    }

    public Timestamp getNgayThanhLy() {
        return ngayThanhLy;
    }

    public void setNgayThanhLy(Timestamp ngayThanhLy) {
        this.ngayThanhLy = ngayThanhLy;
    }

    public String getNguoiSua() {
        return nguoiSua;
    }

    public void setNguoiSua(String nguoiSua) {
        this.nguoiSua = nguoiSua;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getSoHongDong() {
        return soHongDong;
    }

    public void setSoHongDong(String soHongDong) {
        this.soHongDong = soHongDong;
    }

    public Integer getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(Integer thoiHan) {
        this.thoiHan = thoiHan;
    }

    public Integer getTinhTrangKenhTruyen() {
        return tinhTrangKenhTruyen;
    }

    public void setTinhTrangKenhTruyen(Integer tinhTrangKenhTruyen) {
        this.tinhTrangKenhTruyen = tinhTrangKenhTruyen;
    }

    public Integer getTinhTrangThanhLy() {
        return tinhTrangThanhLy;
    }

    public void setTinhTrangThanhLy(Integer tinhTrangThanhLy) {
        this.tinhTrangThanhLy = tinhTrangThanhLy;
    }

    public Integer getTuDongGiaHan() {
        return tuDongGiaHan;
    }

    public void setTuDongGiaHan(Integer tuDongGiaHan) {
        this.tuDongGiaHan = tuDongGiaHan;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "maHD=" + maHD +
                ", loaiHD='" + loaiHD + '\'' +
                ", maChuTruong='" + maChuTruong + '\'' +
                ", maDotChienKhai='" + maDotChienKhai + '\'' +
                ", maKenhTruyen='" + maKenhTruyen + '\'' +
                ", maNCC='" + maNCC + '\'' +
                ", moTa='" + moTa + '\'' +
                ", ngayKy=" + ngayKy +
                ", ngaySua=" + ngaySua +
                ", ngayTAO=" + ngayTAO +
                ", ngayThanhLy=" + ngayThanhLy +
                ", nguoiSua='" + nguoiSua + '\'' +
                ", nguoiTao='" + nguoiTao + '\'' +
                ", soHongDong='" + soHongDong + '\'' +
                ", thoiHan=" + thoiHan +
                ", tinhTrangKenhTruyen=" + tinhTrangKenhTruyen +
                ", tinhTrangThanhLy=" + tinhTrangThanhLy +
                ", tuDongGiaHan=" + tuDongGiaHan +
                '}';
    }
}
