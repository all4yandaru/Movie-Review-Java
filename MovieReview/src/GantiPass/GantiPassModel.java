/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GantiPass;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Satya
 */
public class GantiPassModel {
    static final String drivernya = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/pbo_movie";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public GantiPassModel() {
        try {
             Class.forName(drivernya);
             koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
             System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Koneksi gagal!");
        }
    }
    public boolean cekPassLama(String username,String passLama){
        int cek=0;
        try {
            statement = (Statement)koneksi.createStatement();
            String querynya = "SELECT `password` FROM `user` WHERE `username`='"+username+"' AND `password`='"+passLama+"'";
            ResultSet hasilnya = statement.executeQuery(querynya);
            while (hasilnya.next()){
                    cek++;
            }
            if(cek>0){
//                JOptionPane.showMessageDialog(null,"Login Success");
                //mengembalikan nilai true biar di cek di controller nantinya
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null,"Password Lama Salah");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public void gantiPass(String username,String passBaru){
        try {
            statement = (Statement)koneksi.createStatement();
            String querynya = "UPDATE `user` SET `password`='"+passBaru+"' WHERE `username`='"+username+"' ";
            statement.executeUpdate(querynya);
            
            System.out.println("Berhasil diubah");
            JOptionPane.showMessageDialog(null, "Password Berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
        }
    }
}
