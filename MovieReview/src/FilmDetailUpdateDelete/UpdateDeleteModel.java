/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilmDetailUpdateDelete;

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
public class UpdateDeleteModel {

    static final String drivernya = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/pbo_movie";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;
    
    public UpdateDeleteModel() {
        try { 
             Class.forName(drivernya);
             koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
             System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Koneksi gagal!");
        }
    }
    
    public String[] ambilData(String judul, String username){
        String[] data = new String[4];
        try {
            statement = (Statement)koneksi.createStatement();
            String query = "SELECT * FROM review WHERE username='" + username + "' AND id_movie=(SELECT id_movie FROM movie WHERE judul='" + judul + "')";
            ResultSet hasil = statement.executeQuery(query);
            while (hasil.next()){
                data[0] = hasil.getString("visual_audio");
                data[1] = hasil.getString("plot");
                data[2] = hasil.getString("karakter");
                data[3] = hasil.getString("review");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return data;
    }
    
    public void DeleteReview(String judul, String username){
        try {
            int banyakReview=0;
            int nilaiSemua=0, nilaiUser=0;
            // ngecek berapa orang yg ngereview
            statement = (Statement)koneksi.createStatement();
            String query = "SELECT COUNT(id_movie) as banyak FROM review WHERE id_movie=(SELECT id_movie FROM movie WHERE judul='" + judul + "')";
            ResultSet hasil = statement.executeQuery(query);
            while (hasil.next()){
                banyakReview = hasil.getInt("banyak");
            }
            
            if (banyakReview == 1) { //ntar delete tabel movie
                statement = (Statement)koneksi.createStatement();
                query = "DELETE FROM movie WHERE id_movie=(SELECT id_movie FROM movie WHERE judul='" + judul + "')";
                statement.executeUpdate(query);
                
                // tabel di review otomatis terdelete karena on update cascade on delete cascade
            }
            else { // ntar ngitung ulang nilai movie
                // ambil nilai dari movie sebelumnya
                statement = (Statement)koneksi.createStatement();
                query = "SELECT nilai FROM movie WHERE judul='" + judul + "'";
                hasil = statement.executeQuery(query);
                while (hasil.next()){
                    nilaiSemua = hasil.getInt("nilai");
                }
                
                // ambil keseluruhan dari review sebelumnya
                statement = (Statement)koneksi.createStatement();
                query = "SELECT keseluruhan FROM review WHERE username='" + username + "' AND id_movie=(SELECT id_movie FROM movie WHERE judul='" + judul + "')";
                hasil = statement.executeQuery(query);
                while (hasil.next()){
                    nilaiUser = hasil.getInt("keseluruhan");
                }
                
                System.out.println(nilaiUser + " " + nilaiSemua);
                
                RataRataSemua rataBaruSemua = new RataRataSemua(nilaiSemua, nilaiUser, nilaiUser, nilaiUser, nilaiUser); // 3 nilai terakhir tdk dibutuhkan
                int rataSemuaSebelum = rataBaruSemua.hitungDelete();
                System.out.println("Nilai rata2 semua sebelumnya " + rataSemuaSebelum);
                
                // Update review dan movie jadi data baru
                statement = (Statement)koneksi.createStatement();
                query = "UPDATE movie SET nilai='" + rataSemuaSebelum + "' WHERE judul = '" + judul + "'";
                statement.executeUpdate(query);
                
                // delete review
                statement = (Statement)koneksi.createStatement();
                query = "DELETE FROM review WHERE username='" + username + "' AND id_movie=(SELECT id_movie FROM movie WHERE judul='" + judul + "')";
                statement.executeUpdate(query);
            }
            
            // kurangin kontribusi
            statement = (Statement)koneksi.createStatement();
            String query2 = "UPDATE user SET kontribusi = kontribusi-1 WHERE username = '" + username + "'";
            statement.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null,"Data Berhasil didelete");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    void updateReview(String judul, String username, String visual_audio, String plot, String karakter, String review) {
        try {
            int nilaiSemua=0, nilaiUser=0;
            int intVisualAudio = Integer.parseInt(visual_audio);
            int intPlot = Integer.parseInt(plot);
            int intKarakter = Integer.parseInt(karakter);
            
            // ngitung rata2 baru review oleh user
            RataRataUser rataBaruUser = new RataRataUser(intPlot, intKarakter, intVisualAudio);
            int BaruUser = rataBaruUser.hitung();
            
            // ambil nilai dari movie sebelumnya
            statement = (Statement)koneksi.createStatement();
            String query = "SELECT nilai FROM movie WHERE judul='" + judul + "'";
            ResultSet hasil = statement.executeQuery(query);
            while (hasil.next()){
                nilaiSemua = hasil.getInt("nilai");
            }
            
            // ambil keseluruhan dari review sebelumnya
            statement = (Statement)koneksi.createStatement();
            query = "SELECT keseluruhan FROM review WHERE username='" + username + "' AND id_movie=(SELECT id_movie FROM movie WHERE judul='" + judul + "')";
            hasil = statement.executeQuery(query);
            while (hasil.next()){
                nilaiUser = hasil.getInt("keseluruhan");
            }
            
            System.out.println(nilaiUser + " " + nilaiSemua);
            
            // nyari rata2 sebelumnya diambil dari data2 yg ada sekarang
            RataRataSemua rataBaruSemua = new RataRataSemua(nilaiSemua, nilaiUser, nilaiUser, nilaiUser, nilaiUser);  // 3 nilai terakhir tdk dibutuhkan
            int rataSemuaSebelum = rataBaruSemua.hitungDelete();
            System.out.println("Nilai rata2 semua sebelumnya " + rataSemuaSebelum);
            
            // ngitung rata2 baru dari data sebelumnya dan data yg baru dimasukkan
            rataBaruSemua = new RataRataSemua(rataSemuaSebelum, intVisualAudio, intPlot, intKarakter);
            int rataSemuaBaru = rataBaruSemua.hitung();
            
            System.out.println("Nilai rata2 semua baru " + rataSemuaBaru);
            System.out.println("nilai komponen " + intKarakter + " " + intVisualAudio + " " + intPlot);
            
            // Update review dan movie jadi data baru
            statement = (Statement)koneksi.createStatement();
            query = "UPDATE movie SET nilai='" + rataSemuaBaru + "' WHERE judul = '" + judul + "'";
            statement.executeUpdate(query);
            
            statement = (Statement)koneksi.createStatement();
            query = "UPDATE review SET keseluruhan='" + BaruUser + "', visual_audio='" + intVisualAudio + "', plot='" + intPlot + "', karakter='" + intKarakter + "' WHERE username = '" + username + "' AND id_movie=(SELECT id_movie FROM movie WHERE judul='" + judul + "')";
            statement.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"data telah diupdate");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

}
