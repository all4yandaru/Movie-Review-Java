/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilmDetailUpdateDelete;

import java.awt.Button;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Orenji
 */
public class UpdateDeleteView extends JFrame{
    private String judul, username;
    Font font_penting = new Font("SanSerif", Font.BOLD, 16);
    Font font_judul = new Font("SanSerif", Font.PLAIN, 22);
    Font font_isi = new Font("SanSerif", Font.PLAIN, 14);
    
    JLabel 
            lvisual_audio = new JLabel("Visual Audio : "),
            lplot = new JLabel("Plot : "),
            lkarakter = new JLabel("Karakter : "),
            lreview = new JLabel("Review : ");
    
    JLabel ljudul;
    
    JTextField 
            visual_audio = new JTextField(), 
            plot = new JTextField(),
            karakter= new JTextField(),
            review = new JTextField();
    
    JButton 
            b_update = new JButton("Update"),
            b_delete = new JButton("Delete");
    
    JFrame frame = new JFrame("Update dan Delete movie");
    JLabel background = new JLabel();

    public UpdateDeleteView(String judul, String username) {
        this.judul = judul;
        this.username = username;
        
        ljudul = new JLabel(judul);
        
        frame.setLayout(null);
        frame.setSize(450,525);
        frame.setTitle("Update dan Delete");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        
        frame.add(ljudul);
        ljudul.setFont(font_judul);
        ljudul.setBounds(175, 45, 100, 25); 
        
        frame.add(lvisual_audio);
        lvisual_audio.setBounds(50, 105, 120, 20);
        frame.add(visual_audio);
        visual_audio.setBounds(170, 105, 150, 20);
        
        frame.add(lplot);
        lplot.setBounds(50, 145, 60, 20);
        frame.add(plot);
        plot.setBounds(170, 145, 150, 20);
        
        frame.add(lkarakter);
        lkarakter.setBounds(50, 185, 60, 20);
        frame.add(karakter);
        karakter.setBounds(170, 185, 150, 20);
        
        frame.add(lreview);
        lreview.setBounds(50, 225, 60, 20);
        frame.add(review);
        review.setBounds(170, 225, 150, 20);
        
        frame.add(b_update);
        b_update.setBounds(50, 265, 120, 20);
        
        frame.add(b_delete);
        b_delete.setBounds(180, 265, 120, 20);
        
        frame.add(background);
        background.setIcon(new ImageIcon("D:\\onedrive\\Pictures\\try1.jpg"));
        background.setBounds(0,0,450,525);
        
    }
    
    public String getVisualAudio(){
        return visual_audio.getText();
    }
    
    public String getPlot(){
        return plot.getText();
    }
    
    public String getKarakter(){
        return karakter.getText();
    }
    
    public String getReview(){
        return review.getText();
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getJudul(){
        return judul;
    }
}
