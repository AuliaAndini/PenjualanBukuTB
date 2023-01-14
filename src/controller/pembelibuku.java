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
public class pembelibuku {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String id_pembeli;
    public String nama_pembeli;
    public String jenis_kelamin;
    public String no_hp;
    public String alamat;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO pembeli(id_pembeli,nama_pembeli,jenis_kelamin,no_hp,alamat)VALUE(?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_pembeli);
        pst.setString(2,nama_pembeli);
        pst.setString(3,jenis_kelamin);
        pst.setString(4,no_hp);
        pst.setString(5,alamat);
        pst.execute();
        pst.close();
    }
     public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE pembeli set nama_pembeli=?, jenis_kelamin=?, no_hp=?, alamat=? where id_pembeli=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nama_pembeli);
        pst.setString(2,jenis_kelamin);
        pst.setString(3,no_hp);
        pst.setString(4,alamat);
        pst.setString(5,id_pembeli);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from pembeli where id_pembeli=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, id_pembeli);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatepembeliTBL()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select id_pembeli,nama_pembeli,jenis_kelamin,no_hp,alamat from pembeli";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
    
}