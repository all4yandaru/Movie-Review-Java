/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputFilm;

import Hitung.RataRataSemua;
import Hitung.RataRataUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Orenji
 */
public class InputFilmModel {

   
    private String username;
    
    static final String drivernya = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/pbo_movie";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public InputFilmModel(String username) {
        try {
            this.username = username;
             Class.forName(drivernya);
             koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
             System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Koneksi gagal!");
        }
    }

    void inputData(String judul, String genre, int intDurasi, String sutradara, int intVisualAudio, int intPlot, int intKarakter, String review) {
        // hitung rata rata baru
        RataRataUser rataUser = new RataRataUser(intPlot, intVisualAudio, intKarakter);
        int rataBaru = rataUser.hitung();
        
        if (filmAda(judul)) { // kalo ada judul yang sama
            if (filmUdahDireview(judul,username)) { // kalo si user udah ngereview
                // gagal input review baru
                JOptionPane.showMessageDialog(null, "Film sudah pernah anda review");
            }
            else {
                try {
                    // ngambil id film
                    String id = "";
                    statement = (Statement)koneksi.createStatement();
                    String querynya = "SELECT * FROM `movie` WHERE `judul`='"+judul+"'";
                    ResultSet hasilnya = statement.executeQuery(querynya);
                    while (hasilnya.next()){
                        id = hasilnya.getString("id_movie");
                    }
                    
                    // ngitung banyaknya film yang udah direview
                    int banyak=0;
                    statement = (Statement)koneksi.createStatement();
                    String querynya2 = "SELECT COUNT(id_movie) as jumlah FROM review WHERE id_movie=(SELECT id_movie FROM movie WHERE judul='" + judul + "')";
                    ResultSet hasil2 = statement.executeQuery(querynya2);
                    while (hasil2.next()){
                        banyak = hasil2.getInt("jumlah");
                        System.out.println(banyak);
                    }
                    
                    // masukin ke entitas review
                    statement = (Statement)koneksi.createStatement();
                    String querynya3 = "INSERT INTO review VALUES('" + username + "','" + id + "','" + intVisualAudio + "','" + intPlot + "','" + intKarakter + "','" + rataBaru + "','" + review + "')";
                    statement.executeUpdate(querynya3);
                    
                    // ambil nilai entitas movie
                    int nilai=0;
                    statement = (Statement)koneksi.createStatement();
                    String querynya4 = "SELECT nilai FROM movie WHERE id_movie='" + id + "'";
                    ResultSet hasil4 = statement.executeQuery(querynya4);
                    while (hasil4.next()){
                        nilai = hasil4.getInt("nilai");
                        System.out.println(nilai);
                    }
                    
                    // hitung nilai entitas baru
                    RataRataSemua rataSemua = new RataRataSemua(nilai, intPlot, intVisualAudio, intKarakter);
                    nilai = rataSemua.hitung();
                    System.out.println(nilai);
                    
                    // update nilai baru entitas movie
                    statement = (Statement)koneksi.createStatement();
                    String querynya5 = "UPDATE movie SET nilai='" + nilai + "' WHERE id_movie = '" + id + "'";
                    statement.executeUpdate(querynya5);
                    
                    // tambah kontribusi ke user
                    statement = (Statement)koneksi.createStatement();
                    String querynya6 = "UPDATE user SET kontribusi = kontribusi +1 WHERE username = '" + username + "'";
                    statement.executeUpdate(querynya6);
                    
                    JOptionPane.showMessageDialog(null, "Film berhasil diinputkan");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }
        }
        else {
            //input film & review baru
            try {
                // insert film dulu
                statement = (Statement)koneksi.createStatement();
                String querynya = "INSERT INTO movie(durasi,judul,genre,sutradara,nilai) VALUES('" + intDurasi + "','" + judul + "','" + genre + "','" + sutradara + "','" + rataBaru + "')";
                statement.executeUpdate(querynya);

                // ngambil id film baru
                String id = "";
                statement = (Statement)koneksi.createStatement();
                String querynya2 = "SELECT * FROM `movie` WHERE `judul`='"+judul+"'";
                ResultSet hasilnya = statement.executeQuery(querynya2);
                while (hasilnya.next()){
                    id = hasilnya.getString("id_movie");
                }
                
                // masukin ke entitas review
                statement = (Statement)koneksi.createStatement();
                String querynya3 = "INSERT INTO review VALUES('" + username + "','" + id + "','" + intVisualAudio + "','" + intPlot + "','" + intKarakter + "','" + rataBaru + "','" + review + "')";
                statement.executeUpdate(querynya3);
                
                // tambah kontribusi ke user
                statement = (Statement)koneksi.createStatement();
                String querynya4 = "UPDATE user SET kontribusi = kontribusi +1 WHERE username = '" + username + "'";
                statement.executeUpdate(querynya4);
                
                JOptionPane.showMessageDialog(null, "Film berhasil diinputkan");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
    }

    private boolean filmAda(String judul) {
        int cek = 0;
        try{
            statement = (Statement)koneksi.createStatement();
            String querynya = "SELECT * FROM `movie` WHERE `judul`='"+judul+"'";
            ResultSet hasilnya = statement.executeQuery(querynya);
            while (hasilnya.next()){
                cek++;
            }
            if (cek>0) {
                return true;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return false;
    }

    private boolean filmUdahDireview(String judul, String username) {
        int cek = 0;
        try{
            statement = (Statement)koneksi.createStatement();
            String querynya = "SELECT * FROM review WHERE username='" + username + "' AND id_movie=(SELECT id_movie FROM movie WHERE judul= '"+ judul + "')";
            ResultSet hasilnya = statement.executeQuery(querynya);
            while (hasilnya.next()){
                cek++;
            }
            if (cek>0) {
                return true;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return false;
    }

}
