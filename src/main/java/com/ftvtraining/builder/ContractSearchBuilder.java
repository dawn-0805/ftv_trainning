package com.ftvtraining.builder;

public class ContractSearchBuilder {
    private Integer loai_hop_dong;
    private Integer thoi_han;
    private String ma_dot_trien_khai;
    private String ma_ncc;
    private String so_hop_dong;
    private String nguoi_tao;
    private String ma_chu_truong;
    private String ma_kenh_truyen;
    private String  ngay_tao;
    private String  ngay_ky;
    private int page ;
    private  int size;

   
    public ContractSearchBuilder(Builder builder) {
        this.ma_dot_trien_khai = builder.ma_dot_trien_khai;
        this.ma_ncc = builder.ma_ncc;
        this.so_hop_dong = builder.so_hop_dong;
        this.loai_hop_dong = builder.loai_hop_dong;
        this.thoi_han = builder.thoi_han;
        this.nguoi_tao = builder.nguoi_tao;
        this.ma_chu_truong = builder.ma_chu_truong;
        this.ma_kenh_truyen = builder.ma_kenh_truyen;
        this.ngay_ky = builder.ngay_ky;
        this.ngay_tao = builder.ngay_tao;
        this.page = builder.page;
        this.size = builder.size;
    }

    public Integer getLoai_hop_dong() {
        return loai_hop_dong;
    }

    public String getMa_ncc() {
        return ma_ncc;
    }

    public String getNguoi_tao() {
        return nguoi_tao;
    }

    public String getMa_chu_truong() {
        return ma_chu_truong;
    }

    public String getMa_kenh_truyen() {
        return ma_kenh_truyen;
    }

    public Integer getThoi_han() {
        return thoi_han;
    }
    public String getMa_dot_trien_khai() {
        return ma_dot_trien_khai;
    }
    public int getSize() {
        return size;
    }
    public int getPage() {
        return page;
    }
    public String getSo_hop_dong() {
        return so_hop_dong;
    }
    public String getNgay_tao() {
        return ngay_tao;
    }
    public String getNgay_ky() {
        return ngay_ky;
    }

    public  static  class Builder{
        private Integer loai_hop_dong;
        private Integer thoi_han;
        private String ma_dot_trien_khai;
        private String ma_ncc;
        private String so_hop_dong;
        private String ma_chu_truong;
        private String ma_kenh_truyen;
        private String  ngay_tao;
        private String  ngay_ky;
        private String nguoi_tao;
        private int page ;
        private  int size;

        public Builder() {

        }
        public Builder setSize(int size) {
            this.size = size;
            return  this;
        }
        public Builder setPage(int page) {
            this.page = page;
            return  this;
        }

        public Builder setMa_dot_trien_khai(String ma_dot_trien_khai) {
            this.ma_dot_trien_khai = ma_dot_trien_khai;
            return  this;
        }



        public Builder setThoi_han(Integer thoi_han) {
            this.thoi_han = thoi_han;
            return  this;
        }

        public Builder setSo_hop_dong(String so_hop_dong) {
            this.so_hop_dong = so_hop_dong;
            return  this;
        }

        public Builder setNgay_tao(String ngay_tao) {
            this.ngay_tao = ngay_tao;
            return  this;
        }

        public Builder setNgay_ky(String ngay_ky) {
            this.ngay_ky = ngay_ky;
            return  this;
        }

        public Builder setMa_dot_chien_khai(String ma_dot_trien_khai) {
            this.ma_dot_trien_khai = ma_dot_trien_khai;
            return  this;
        }
        public Builder setMa_ncc(String ma_ncc) {
            this.ma_ncc = ma_ncc;
            return  this;
        }

        public Builder setLoai_hop_dong(Integer loai_hop_dong) {
            this.loai_hop_dong = loai_hop_dong;
            return  this;
        }

        public Builder setMa_chu_truong(String ma_chu_truong) {
            this.ma_chu_truong = ma_chu_truong;
            return  this;
        }

        public Builder setMa_kenh_truyen(String ma_kenh_truyen) {
            this.ma_kenh_truyen = ma_kenh_truyen;
            return  this;
        }

        public Builder setNguoi_tao(String nguoi_tao) {
            this.nguoi_tao = nguoi_tao;
            return  this;
        }

        public ContractSearchBuilder build() {
            return new ContractSearchBuilder(this);
        }
    }
}
