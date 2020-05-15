/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Orenji
 */
public class RegisterModel {
    static final String drivernya = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/pbo_movie";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public RegisterModel() {
        try {
             Class.forName(drivernya);
             koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
             System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Koneksi gagal!");
        }
    }
    
    public boolean cekUser(String username){
        int cek = 0;
        try {
            statement = (Statement)koneksi.createStatement();
            String querynya = "SELECT * FROM `user` WHERE `username`='"+username+"'";
            ResultSet hasilnya = statement.executeQuery(querynya);
            while (hasilnya.next()){
                    cek++;
            }
            if(cek>0){
                JOptionPane.showMessageDialog(null,"Username sudah ada");
                //mengembalikan nilai true biar di cek di controller nantinya
                return true;
            }
            else{
                return false;
            }
//            statement.executeUpdate(querynya);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public void registerUser(String username, String pass){
        try{
            statement = (Statement)koneksi.createStatement();
            String querynya = "INSERT INTO user VALUES('" + username + "','" + pass + "',0,'001')";
            
            statement.executeUpdate(querynya); //execute querynya
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
        }
    }
}
