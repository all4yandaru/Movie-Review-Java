/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputFilm;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Orenji
 */
public class InputFilmView extends JFrame{

    Font fontt = new Font("SanSerif", Font.PLAIN, 20);
    Font font_isi = new Font("SanSerif", Font.PLAIN, 14);

    JFrame frame = new JFrame("Input Review Baru");
    JLabel linput = new JLabel("Review Baru");
    
    JLabel ljudul = new JLabel("Judul");
    JTextField fjudul = new JTextField();
    
    JLabel lgenre = new JLabel("Genre");
    JTextField fgenre = new JTextField();
    
    JLabel ldurasi = new JLabel("Durasi (menit)");
    JTextField fdurasi = new JTextField();
    
    JLabel lsutradara = new JLabel("Sutradara");
    JTextField fsutradara = new JTextField();
    
    JLabel lvisual_audio = new JLabel("visual audio (0-100)");
    JTextField fvisual_audio = new JTextField();
    
    JLabel lplot = new JLabel("plot (0-100)");
    JTextField fplot = new JTextField();
    
    JLabel lkarakter = new JLabel("karakter (0-100)");
    JTextField fkarakter = new JTextField();
    
    JLabel lreview = new JLabel("Review singkat");
    JTextField freview = new JTextField();
    
    JButton b_input = new JButton("Input");
    
    JLabel background = new JLabel();
    
    public InputFilmView() {
        frame.setLayout(null);
        frame.setSize(450,700);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        
        frame.add(linput);
        linput.setFont(fontt);
        linput.setBounds(175, 45, 100, 25); 
        
        frame.add(ljudul);
        ljudul.setBounds(50, 105, 60, 20);
        frame.add(fjudul);
        fjudul.setBounds(170, 105, 150, 20);
        
        frame.add(lgenre);
        lgenre.setBounds(50, 165, 60, 20);
        frame.add(fgenre);
        fgenre.setBounds(170, 165, 150, 20);
        
        frame.add(ldurasi);
        ldurasi.setBounds(50, 225, 100, 20);
        frame.add(fdurasi);
        fdurasi.setBounds(170, 225, 150, 20);
        
        frame.add(lsutradara);
        lsutradara.setBounds(50, 285, 100, 20);
        frame.add(fsutradara);
        fsutradara.setBounds(170, 285, 150, 20);
        
        frame.add(lvisual_audio);
        lvisual_audio.setBounds(50, 345, 100, 20);
        frame.add(fvisual_audio);
        fvisual_audio.setBounds(170, 345, 150, 20);
        
        frame.add(lplot);
        lplot.setBounds(50, 405, 100, 20);
        frame.add(fplot);
        fplot.setBounds(170, 405, 150, 20);
        
        frame.add(lkarakter);
        lkarakter.setBounds(50, 465, 100, 20);
        frame.add(fkarakter);
        fkarakter.setBounds(170, 465, 150, 20);
        
        frame.add(lreview);
        lreview.setBounds(50, 525, 100, 20);
        frame.add(freview);
        freview.setBounds(170, 525, 150, 20);
        
        frame.add(b_input);
        b_input.setBounds(245, 585, 100, 20);
        
        frame.add(background);
        background.setIcon(new ImageIcon("D:\\onedrive\\Pictures\\450x700.jpg"));
        background.setBounds(0,0,450,700);

    }
//    public static void main(String[] args) {
//        new InputFilmView();
//    }
    
    public String getJudul(){
        return fjudul.getText();
    }
    
    public String getDurasi(){
        return fdurasi.getText();
    }
    
    public String getGenre(){
        return fgenre.getText();
    }
    
    public String getSutradara(){
        return fsutradara.getText();
    }
    
    public String getVisualAudio(){
        return fvisual_audio.getText();
    }
    
    public String getKarakter(){
        return fkarakter.getText();
    }
    
    public String getPlot(){
        return fplot.getText();
    }
    
    public String getReview(){
        return freview.getText();
    }
}
