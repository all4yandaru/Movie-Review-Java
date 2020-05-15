/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReviewAnda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Orenji
 */
public class ReviewAndaModel {
    static final String drivernya = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/pbo_movie";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;
    
    public ReviewAndaModel() {
        try {
             Class.forName(drivernya);
             koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
             System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Koneksi gagal!");
        }
    }
    
    public int getBanyakData(String username){
        int jmlData = 0;
        try{
            statement = (Statement)koneksi.createStatement();
            String query = "SELECT * FROM review WHERE username = '" + username + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public String[][] readReview(String username){
       try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData(username)][6]; //baris, kolom nya ada 6
            
            statement = (Statement)koneksi.createStatement();
            String query = "SELECT * FROM review LEFT JOIN movie ON movie.id_movie = review.id_movie WHERE username='" + username + "'"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("judul"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("visual_audio");                
                data[jmlData][2] = resultSet.getString("plot");
                data[jmlData][3] = resultSet.getString("karakter");
                data[jmlData][4] = resultSet.getString("keseluruhan");
                data[jmlData][5] = resultSet.getString("review");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public String[][] cariReview(String username, String judul){
        try{
            int jmlData = 0;
            
            statement = (Statement)koneksi.createStatement();
            String query = "SELECT * FROM review LEFT JOIN movie ON movie.id_movie = review.id_movie WHERE username='" + username + "' AND judul LIKE '%" + judul + "%'"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            
            String data[][] = new String[jmlData][6]; //baris, kolom nya ada 6
            
            
            if (jmlData == 0) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
            else {
                jmlData = 0;
                
                statement = (Statement)koneksi.createStatement();
                query = "SELECT * FROM review LEFT JOIN movie ON movie.id_movie = review.id_movie WHERE username='" + username + "' AND judul LIKE '%" + judul + "%'"; 
                resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    data[jmlData][0] = resultSet.getString("judul"); //harus sesuai nama kolom di mysql
                    data[jmlData][1] = resultSet.getString("visual_audio");                
                    data[jmlData][2] = resultSet.getString("plot");
                    data[jmlData][3] = resultSet.getString("karakter");
                    data[jmlData][4] = resultSet.getString("keseluruhan");
                    data[jmlData][5] = resultSet.getString("review");
                    jmlData++;
                }
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
}
