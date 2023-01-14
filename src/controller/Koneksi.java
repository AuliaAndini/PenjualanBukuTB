/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Koneksi {
    private static Connection Koneksi;
    public static Connection getKoneksi(){
        if(Koneksi==null){
            try{
                String url;
                url="jdbc:mysql://localhost:3306/2010010241_buku";
                String username = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                Koneksi=DriverManager.getConnection(url,username,password);
            }catch (SQLException t){
                JOptionPane.showMessageDialog(null, "Error Koneksi ");
            }
        }return Koneksi;
    }static Object getConnection(){
        throw new UnsupportedOperationException ("Not yet implemented");
    }
    
}
