/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author 5SCOMPUTER
 */
public class Connect {
    public Connection conn;
    public String DB_NAME = "jdbc:mysql://localhost:3306/nhom17";
    public String DB_USERNAME = "root";
    public String DB_PASSWORD = "";

    public Connect() {
        try {
            conn = (Connection) DriverManager.getConnection(DB_NAME, DB_USERNAME, DB_PASSWORD);
            System.out.println("Kết nối thành công!");
        } catch (Exception e) {
            System.out.println("Kết nối thất bại!");
        }
        
    }
    
    public ArrayList<khachhang> laydanhsach(){
        ArrayList<khachhang> danhsach = new ArrayList<>();
        
        String sql = "SELECT * FROM khachhang";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                khachhang kh = new khachhang();
                
                kh.setMakh(rs.getString("MaKH"));
                kh.setHoten(rs.getString("TenKH"));
                kh.setNgaysinh(rs.getString("NgaySinh"));
                kh.setSdt(rs.getString("Sdt"));
                kh.setDiachi(rs.getString("DiaChi"));
                kh.setGioitinh(rs.getInt("GioiTinh"));
                kh.setGhichu(rs.getString("GhiChu"));
                
                danhsach.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhsach;
    }
    
    public void themMoi(khachhang kh){
        String sql = "INSERT INTO khachhang(MaKH, TenKH, NgaySinh, SDT, DiaChi, GioiTinh, GhiChu) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, kh.getMakh());
            ps.setString(2, kh.getHoten());
            ps.setString(3, kh.getNgaysinh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getDiachi());
            ps.setInt(6, kh.getGioitinh());
            ps.setString(7, kh.getGhichu());
            
            ps.executeUpdate();
            
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public ArrayList<khachhang> timkiemten(String ten){
        ArrayList<khachhang> danhsach = new ArrayList<>();
        String sql = "SELECT * FROM khachhang WHERE TenKH LIKE '%"+ten+"%'";
        
       try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){                
                khachhang kh = new khachhang();
                
                kh.setMakh(rs.getString("MaKH"));
                kh.setHoten(rs.getString("TenKH"));
                kh.setNgaysinh(rs.getString("NgaySinh"));
                kh.setSdt(rs.getString("Sdt"));
                kh.setDiachi(rs.getString("DiaChi"));
                kh.setGioitinh(rs.getInt("GioiTinh"));
                kh.setGhichu(rs.getString("GhiChu"));
                
                danhsach.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return danhsach;
    }
    
    public ArrayList<khachhang> timKiemMa(String MaKH){
        ArrayList<khachhang> danhsach = new ArrayList<>();
        String sql = "SELECT * FROM khachhang WHERE MaKH LIKE'%"+MaKH+"%'";
        
       try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){                
                khachhang kh = new khachhang();
                
                kh.setMakh(rs.getString("MaKH"));
                kh.setHoten(rs.getString("TenKH"));
                kh.setNgaysinh(rs.getString("NgaySinh"));
                kh.setSdt(rs.getString("Sdt"));
                kh.setDiachi(rs.getString("DiaChi"));
                kh.setGioitinh(rs.getInt("GioiTinh"));
                kh.setGhichu(rs.getString("GhiChu"));
                
                danhsach.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return danhsach;
    }
    
    public void sua(khachhang kh){
        String sql = "UPDATE khachhang SET TenKH = ?, NgaySinh = ?, SDT = ?, DiaChi = ?, GioiTinh = ?, GhiChu = ? WHERE MaKH = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, kh.getHoten());
            ps.setString(2, kh.getNgaysinh());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getDiachi());
            ps.setInt(5, kh.getGioitinh());
            ps.setString(6, kh.getGhichu());
            ps.setString(7, kh.getMakh());
            
            ps.executeUpdate();
            
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<doanhthu> laydanhsach1(){
        ArrayList<doanhthu> danhsach = new ArrayList<>();
        
        String sql = "SELECT MaSP, TenSP, SoLuong, DonGia, TenKH, GhiChu, hoadon.MaHD FROM hoadon INNER JOIN chitiethd ON chitiethd.MaHD = hoadon.MaHD";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                doanhthu dt = new doanhthu();
                
                dt.setMaSP(rs.getString("MaSP"));
                dt.setTenSP(rs.getString("TenSP"));
                dt.setSoLuong(rs.getInt("SoLuong"));
                dt.setDonGia(rs.getInt("DonGia"));
                dt.setTenKH(rs.getString("TenKH"));
                dt.setGhiChu(rs.getString("GhiChu"));
                dt.setMaHD(rs.getString("MaHD"));
                
                danhsach.add(dt);
                             
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhsach;
    }
    
    public int tongHD(){
        Integer tong = new Integer(0);        
        String sql = "SELECT count(*) FROM hoadon";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            tong = rs.getInt("count(*)");
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tong;
    }
    
    public int tongKhach(){
        Integer tongk = new Integer(0);
       
        String sql = "SELECT count(*) FROM khachhang";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            tongk = rs.getInt("count(*)");
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tongk;
    }
    
    public int tongDoanhThu(){
        Integer tongDT = new Integer(0);
       
        String sql = "SELECT sum(DonGia) FROM chitiethd";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            tongDT = rs.getInt("sum(DonGia)");
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tongDT;
    }
}
