/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profileUser;

import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Satya
 */
public class ProfileView {
    private String username;
    Font font_penting = new Font("SanSerif", Font.BOLD, 16);
    Font font_judul = new Font("SanSerif", Font.PLAIN, 22);
    Font font_isi = new Font("SanSerif", Font.PLAIN, 14);
    
    JFrame frame = new JFrame("Profile");
    
    JLabel lprofile,lnama,Lranknya,piclabel;
    JButton b_update = new JButton("Ubah Pass");
    
    JLabel lranking = new JLabel("Rank Anda");

    JButton b_lihat_data_review = new JButton("Review Anda");
    
    JLabel background = new JLabel();

    public ProfileView(String username) {
        this.username = username;
        lnama = new JLabel(username);
        lprofile = new JLabel("Profile anda");
        piclabel = new JLabel(new ImageIcon("D:\\onedrive\\Pictures\\user.png"));
        Lranknya = new JLabel("Eaaa");
        
        frame.setLayout(null);
        frame.setSize(450,525);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        
        frame.add(lprofile);
        lprofile.setFont(font_judul);
        lprofile.setBounds(160, 25, 125, 25);
        
        frame.add(piclabel);
        piclabel.setBounds(168,60,90,90);
        
        frame.add(lnama);
        lnama.setFont(font_penting);
        lnama.setBounds(190, 155, 130, 25);
        
        frame.add(b_update);
        b_update.setBounds(155, 185, 120, 25);
        
        frame.add(lranking);
        lranking.setFont(font_judul);
        lranking.setBounds(165, 250, 125, 25);
        
        frame.add(Lranknya);
        Lranknya.setFont(font_penting);
        Lranknya.setBounds(160, 280, 130, 25);
        
        frame.add(b_lihat_data_review);
        b_lihat_data_review.setBounds(155, 315, 115, 60);
        
        frame.add(background);
        background.setIcon(new ImageIcon("D:\\onedrive\\Pictures\\try1.jpg"));
        background.setBounds(0,0,450,525);
        
    }
    
//    public static void main(String[] args) {
//        new ProfileView("Satya");
//    }
    public String getUsername() {
        return username;
    }
}
