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
public class transaksipenjualan {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String id_transaksi;
    public String id_buku;
    public String id_pembeli;
    public String tanggal;
    public String harga;
    public String jumlah_buku;
    public String total;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO transaksi (id_transaksi,id_buku,id_pembeli,tanggal,harga,jumlah_buku,total)VALUE(?,?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_transaksi);
        pst.setString(2,id_buku);
        pst.setString(3,id_pembeli);
        pst.setString(4,tanggal);
        pst.setString(5,harga);
        pst.setString(6,jumlah_buku);
        pst.setString(7,total);
        pst.execute();
        pst.close();
    }
     public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE transaksi set id_buku=?, id_pembeli=?, tanggal=?, harga=?, jumlah_buku=?, total=? where id_transaksi=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_buku);
        pst.setString(2,id_pembeli);
        pst.setString(3,tanggal);
        pst.setString(4,harga);
        pst.setString(5,jumlah_buku);
        pst.setString(6,total);
        pst.setString(7,id_transaksi);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from transaksi where id_transaksi=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, id_transaksi);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatetransaksiTBL()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select id_transaksi,id_buku,id_pembeli,tanggal,harga,jumlah_buku,total from transaksi";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
    
}