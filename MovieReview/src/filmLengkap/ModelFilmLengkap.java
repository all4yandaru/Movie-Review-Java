/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmLengkap;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Satya
 */
public class ModelFilmLengkap {
    static final String drivernya = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/pbo_movie";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public ModelFilmLengkap() {
        try {
             Class.forName(drivernya);
             koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
             System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Koneksi gagal!");
        }
    }
    
    public int banyaknyaData(){
        int jmlData=0;
        try {
            statement = (Statement)koneksi.createStatement();
            String query = "SELECT * FROM `movie`";
            ResultSet hasilnya = statement.executeQuery(query);
                while (hasilnya.next()){
                    jmlData++;
                }
            return jmlData;
        } catch (Exception countData) {
            JOptionPane.showMessageDialog(null, countData.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
    
    public String[][] tampilkanData(){
        try {
            int jmlData=0;
            String data[][] = new String[banyaknyaData()][4];
            String query = "Select * from `movie`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("id_movie");
                data[jmlData][1] = resultSet.getString("judul");
                data[jmlData][2] = resultSet.getString("sutradara");
                data[jmlData][3] = resultSet.getString("nilai");
                jmlData++;
            }
            return data;
        } catch (Exception errorTampil) {
            JOptionPane.showMessageDialog(null, errorTampil.getMessage(),"Hasil",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
