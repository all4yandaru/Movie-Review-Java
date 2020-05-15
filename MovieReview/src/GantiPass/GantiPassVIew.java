/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GantiPass;

import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Satya
 */
public class GantiPassVIew {
    private String username;
    Font font_judul = new Font("SanSerif", Font.PLAIN, 22);
    Font font_isi = new Font("SanSerif", Font.PLAIN, 14);
    
    JFrame frame = new JFrame("Ganti Password");
    
    JLabel Lubahpass = new JLabel("Ubah Password");
    
    JLabel passLama = new JLabel("Password Lama");
    JLabel passBaru = new JLabel("Password Baru");
    JLabel passKonfirm = new JLabel("Ulangi Password Baru");
    
    JPasswordField tfPassLama = new JPasswordField();
    JPasswordField tfPassBaru = new JPasswordField();
    JPasswordField tfPassKonfirm = new JPasswordField();
    
    JButton b_ganti = new JButton("Ganti");
    JButton b_reset = new JButton("Reset");
    
    JLabel background = new JLabel();

    public GantiPassVIew(String username) {
        this.username = username;
        
        frame.setLayout(null);
        frame.setSize(450,525);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        
        frame.add(Lubahpass);
        Lubahpass.setFont(font_judul);
        Lubahpass.setBounds(145, 45, 200, 25);
        
        frame.add(passLama);
        passLama.setFont(font_isi);
        passLama.setBounds(25, 105, 110, 20);
        
        frame.add(tfPassLama);
        tfPassLama.setBounds(25, 140, 380, 30);
        
        frame.add(passBaru);
        passBaru.setFont(font_isi);
        passBaru.setBounds(25, 190, 110, 20);
        
        frame.add(tfPassBaru);
        tfPassBaru.setBounds(25, 225, 380, 30);
        
        frame.add(passKonfirm);
        passKonfirm.setFont(font_isi);
        passKonfirm.setBounds(25, 275, 150, 20);
        
        frame.add(tfPassKonfirm);
        tfPassKonfirm.setBounds(25, 310, 380, 30); 
        
        frame.add(b_ganti);
        b_ganti.setBounds(245, 380, 70, 25);
        
        frame.add(b_reset);
        b_reset.setBounds(95, 380, 70, 25);
       
        frame.add(background);
        background.setIcon(new ImageIcon("D:\\onedrive\\Pictures\\try1.jpg"));
        background.setBounds(0,0,450,525);
    }
    
    public static void main(String[] args) {
        new GantiPassVIew("satya");
    }

    public String getUsername() {
        return username;
    }
    
    public String getTfPassLama() {
        return tfPassLama.getText();
    }

    public String getTfPassBaru() {
        return tfPassBaru.getText();
    }

    public String getTfPassKonfirm() {
        return tfPassKonfirm.getText();
    }
    
    
}
