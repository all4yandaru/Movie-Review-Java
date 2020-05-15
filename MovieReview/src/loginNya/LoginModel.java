/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginNya;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Satya
 */
public class LoginModel {
    static final String drivernya = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/pbo_movie";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;
    public LoginModel() {
        try {
             Class.forName(drivernya);
             koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
             System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Koneksi gagal!");
        }
    }
    public boolean cekLogin(String username,String pass){
        int cek = 0;
        try {
            statement = (Statement)koneksi.createStatement();
            String querynya = "SELECT * FROM `user` WHERE `username`='"+username+"' AND `password`='"+pass+"'";
            ResultSet hasilnya = statement.executeQuery(querynya);
            while (hasilnya.next()){
                    cek++;
            }
            if(cek>0){
                JOptionPane.showMessageDialog(null,"Login Success");
                //mengembalikan nilai true biar di cek di controller nantinya
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null,"Login Failed");
            }
//            statement.executeUpdate(querynya);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
