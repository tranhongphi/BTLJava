/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author 5SCOMPUTER
 */
public class khachhang {
    private  String makh;
    private String hoten;
    private String ngaysinh;
    private String sdt;
    private String diachi;
    private int gioitinh;    
    private String ghichu;

    public khachhang() {
    }

    public khachhang(String makh, String hoten, String ngaysinh, String sdt, String diachi, int gioitinh, String ghichu) {
        this.makh = makh;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.ghichu = ghichu;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    
}
