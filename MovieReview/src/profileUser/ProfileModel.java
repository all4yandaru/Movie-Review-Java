/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profileUser;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Satya
 */
public class ProfileModel {
    static final String drivernya = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/pbo_movie";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public ProfileModel() {
        try {
             Class.forName(drivernya);
             koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
             System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Koneksi gagal!");
        }
    }
    
    public String tampilkanrank(String username){
        int jmlData=0;
        try {
            statement = (Statement)koneksi.createStatement();
            String query = "SELECT * FROM `review` WHERE `username`= '"+username+"'";
            ResultSet hasilnya = statement.executeQuery(query);
                while (hasilnya.next()){
                    jmlData++;
                }
                System.out.println(jmlData);
            statement = (Statement)koneksi.createStatement();
            if (jmlData<3){
                query = "UPDATE `user` SET  id_ranks = '001' WHERE `username`= '"+username+"'";
                statement.executeUpdate(query);
                return "baby";
            }
                else if(jmlData>=3 && jmlData<=5){
                    query = "UPDATE `user` SET  id_ranks = '005' WHERE `username`= '"+username+"'";
                    statement.executeUpdate(query);
                    return "grown up";
                }
                    else{
                    query = "UPDATE `user` SET  id_ranks = '010' WHERE `username`= '"+username+"'";
                    statement.executeUpdate(query);
                        return "warrior";
                    }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public void updaterank(String username){
        String rank=tampilkanrank(username);
        String idRank;
        if (rank=="baby") {
            idRank = "001";
        }
        else if (rank=="grown up"){
            idRank = "005";
        }
        else{
            idRank = "010";
        }
        try {
            statement = koneksi.createStatement();
            String query = "UPDATE `user` SET `id_ranks`='"+idRank+"' WHERE `username` = '"+username+"'  ";
            statement.executeUpdate(query);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
        }
    }
}
