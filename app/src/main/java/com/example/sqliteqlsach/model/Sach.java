package com.example.sqliteqlsach.model;

public class Sach {
    private int ma;
    private String ten;
    private String tacgia;
    private int namxb;

    public Sach(int ma, String ten, String tacgia, int namxb) {
        this.ma = ma;
        this.ten = ten;
        this.tacgia = tacgia;
        this.namxb = namxb;
    }

    public Sach() {
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public int getNamXB() {
        return namxb;
    }

    public void setNamXB(int namxb) {
        this.namxb = namxb;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "ma=" + ma +
                ", ten='" + ten + '\'' +
                ", tacgia='" + tacgia + '\'' +
                ", namxb=" + namxb +
                '}';
    }
}
