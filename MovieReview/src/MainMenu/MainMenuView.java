/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainMenu;

import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Orenji
 */
public class MainMenuView extends JFrame{
    private String username;
    Font fontt = new Font("SanSerif", Font.PLAIN, 20);
    Font font_isi = new Font("SanSerif", Font.PLAIN, 14);
    
    JFrame frame = new JFrame("Main Menu");
    JLabel ljudul;
    JButton b_input = new JButton("Input");
    JButton b_update = new JButton("Review Anda");
    JButton b_lihat_data_user = new JButton("Profile");
    JButton b_lihat_data_semua = new JButton("Daftar Film");
    
    JLabel background = new JLabel();

    public MainMenuView(String username){
        this.username = username;
        
        ljudul = new JLabel("Hai, " + username);
        
        frame.setLayout(null);
        frame.setSize(450,525);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (EXIT_ON_CLOSE);
        
        frame.add(ljudul);
        ljudul.setFont(fontt);
        ljudul.setBounds(175, 45, 120, 25); 
        
        frame.add(b_input);
        b_input.setBounds(135, 140, 180, 60);
        
        frame.add(b_update);
        b_update.setBounds(135, 220, 180, 60);
        
        frame.add(b_lihat_data_user);
        b_lihat_data_user.setBounds(135, 300, 180, 60);
        
        frame.add(b_lihat_data_semua);
        b_lihat_data_semua.setBounds(135, 380, 180, 60);
        
        frame.add(background);
        background.setIcon(new ImageIcon("D:\\onedrive\\Pictures\\try1.jpg"));
        background.setBounds(0,0,450,525);

    }
    public static void main(String[] args) {
        new MainMenuView("satya");
    }
    public String getUsername() {
        return username;
    }
}
