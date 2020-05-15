/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmDetail;

import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Satya
 */
public class FilmDetailView {
    private String id_movie;
    Font font_penting = new Font("SanSerif", Font.BOLD, 16);
    Font font_judul = new Font("SanSerif", Font.PLAIN, 22);
    Font font_isi = new Font("SanSerif", Font.PLAIN, 14);
    
    JLabel ljudul, lgenre,Ldurasi,lsutradara,lnilai,genrenya,durasinya,nilainya,sutradaranya;
    
    JTable tabel;
    Container c;
    Object[] kolom = {"username","nilai","Review"};
    DefaultTableModel model;
    JScrollPane pane;
    
    JFrame frame = new JFrame("Film");
    
    JLabel background = new JLabel();

    public FilmDetailView(String idMovie/*,String judul, String genre,String durasi, String nilai*/) {
        this.id_movie = idMovie;
        ljudul = new JLabel("");
        lgenre = new JLabel("");
        Ldurasi = new JLabel("");
        lnilai = new JLabel("");
        lsutradara = new JLabel("");
        
        this.genrenya = new JLabel("Genre : ");
        this.durasinya = new JLabel("Durasi :");
        this.nilainya = new JLabel("Nilai : ");
        this.sutradaranya = new JLabel("Sutradara : ");
        
        model = new DefaultTableModel(kolom,0);
        tabel = new JTable(model);
        pane = new JScrollPane(tabel);
        
        tabel.setModel(model);
        Font font = new Font("",1,16);
        tabel.setFont(font);
        tabel.setRowHeight(30);
        
        frame.setLayout(null);
        frame.setTitle("Film");
        frame.setSize(900,400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        
        frame.add(ljudul);
        ljudul.setFont(font_judul);
        ljudul.setBounds(400, 20, 145, 25);
        
        frame.add(genrenya);
        genrenya.setFont(font_isi);
        genrenya.setBounds(20, 60, 55, 25);
        frame.add(lgenre);
        lgenre.setFont(font_penting);
        lgenre.setBounds(100, 60, 100, 25);
        
        frame.add(durasinya);
        durasinya.setFont(font_isi);
        durasinya.setBounds(20, 100, 50, 25);
        frame.add(Ldurasi);
        Ldurasi.setFont(font_penting);
        Ldurasi.setBounds(100, 100, 100, 25);
        
        frame.add(nilainya);
        nilainya.setFont(font_isi);
        nilainya.setBounds(20, 140, 50, 25);
        frame.add(lnilai);
        lnilai.setFont(font_penting);
        lnilai.setBounds(100, 140, 100, 25);
        
        frame.add(sutradaranya);
        sutradaranya.setFont(font_isi);
        sutradaranya.setBounds(20, 180, 75, 25);
        frame.add(lsutradara);
        lsutradara.setFont(font_penting);
        lsutradara.setBounds(100, 180, 150, 25);
        
        pane.setBounds(0, 210, 880, 180);
        frame.add(pane);
        
        frame.add(background);
        background.setIcon(new ImageIcon("D:\\onedrive\\Pictures\\try.jpg"));
        background.setBounds(0,0,900,400);
    }
    
    public static void main(String[] args) {
        new FilmDetailView("1");
    }

    public String getId_movie() {
        return id_movie;
    }
    
}
