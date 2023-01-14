/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class namabuku {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String id_buku;
    public String nama_buku;
    public String harga;
    public String stok;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO buku(id_buku,nama_buku,harga,stok)VALUE(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_buku);
        pst.setString(2,nama_buku);
        pst.setString(3,harga);
        pst.setString(4,stok);
        pst.execute();
        pst.close();
    }
     public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE buku set nama_buku=?,harga=?, stok=? where id_buku=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nama_buku);
        pst.setString(2,harga);
        pst.setString(3,stok);
        pst.setString(4,id_buku);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from buku where id_buku=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, id_buku);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatebukuTBL()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select id_buku,nama_buku,harga,stok from buku";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
    
}