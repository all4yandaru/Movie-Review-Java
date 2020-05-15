/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmDetail;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Satya
 */
public class FilmDetailModel {
    static final String drivernya = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/pbo_movie";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public FilmDetailModel() {
        try {
             Class.forName(drivernya);
             koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
             System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Koneksi gagal!");
        }
    }
    
     public String[] tampilkanData(String id_movie){
        try {
            int jmlData=0;
            String data[] = new String[6];
            String query = "SELECT * FROM `movie` WHERE `id_movie`= '"+id_movie+"'";
            statement = (Statement)koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()){
                data[0] = resultSet.getString("id_movie");    
                data[1] = resultSet.getString("durasi");
                data[2] = resultSet.getString("judul");
                data[3] = resultSet.getString("genre");
                data[4] = resultSet.getString("sutradara");
                data[5] = resultSet.getString("nilai");
            }
            return data;
        } catch (Exception errorTampil) {
            JOptionPane.showMessageDialog(null, errorTampil.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
     
     public int banyaknyaReview(String id_movie){
        int jmlData=0;
         try {
                statement = (Statement)koneksi.createStatement();
                String query_banyak = "SELECT * FROM `review` WHERE `id_movie`= '"+id_movie+"'";
                ResultSet hasilnya = statement.executeQuery(query_banyak);
                while (hasilnya.next()){
                    jmlData++;
                }
                return jmlData;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
                return 0;
            }
    }
     
    public String[][] tampilkanReview(String id_movie){
        try {
//            int jmlData=0;
            int dataReview = 0;
            String data[][] = new String[banyaknyaReview(id_movie)][3];
            String query = "Select * from `review` WHERE `id_movie`= '"+id_movie+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[dataReview][0] = resultSet.getString("username");
                data[dataReview][1] = resultSet.getString("keseluruhan");
                data[dataReview][2] = resultSet.getString("review");
                dataReview++;
            }
            return data;
        } catch (Exception errorTampil) {
            JOptionPane.showMessageDialog(null, errorTampil.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
}
