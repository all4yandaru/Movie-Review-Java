/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginNya;

import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Satya
 */
public class LoginView {
    Font fontt = new Font("SanSerif", Font.PLAIN, 20);
    Font font_isi = new Font("SanSerif", Font.PLAIN, 14);
//    LoginModel model = new LoginModel();
    JFrame frame = new JFrame("Login Menu");
    JLabel llogin = new JLabel("Login");
    JLabel lusername = new JLabel("Username");
    JTextField fusername = new JTextField();
    JLabel lpassword = new JLabel("Password");
    JLabel lnoakun = new JLabel("Belum Punya akun?");
    JPasswordField fpassword = new JPasswordField();
    JButton b_login = new JButton("Login");
    JButton b_reset = new JButton("Reset");
    JButton b_register = new JButton("Register");
    JLabel background = new JLabel();

    LoginView() {      
        frame.setLayout(null);
        frame.setSize(450,525);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (EXIT_ON_CLOSE);
        
        frame.add(llogin);
        llogin.setFont(fontt);
        llogin.setBounds(195, 45, 60, 25); 
        
        frame.add(lusername);
        lusername.setBounds(50, 105, 60, 20);
        frame.add(fusername);
        fusername.setBounds(170, 105, 150, 20);
        
        frame.add(lpassword);
        lpassword.setBounds(50, 165, 60, 20);
        frame.add(fpassword);
        fpassword.setBounds(170, 165, 150, 20);
        
        frame.add(b_login);
        b_login.setBounds(245, 225, 70, 20);
        
        frame.add(b_reset);
        b_reset.setBounds(95, 225, 70, 20);
        
        frame.add(lnoakun);
        lnoakun.setFont(fontt);
        lnoakun.setBounds(140, 270, 180, 20);
        frame.add(b_register);
        b_register.setBounds(170, 307, 90, 20);
        
        frame.add(background);
        background.setIcon(new ImageIcon("D:\\onedrive\\Pictures\\try1.jpg"));
        background.setBounds(0,0,450,525);
    }
//    public static void main(String[] args) {
//        new LoginView();
//    }

    public String getFusername() {
        return fusername.getText();
    }

    public String getFpassword() {
        return fpassword.getText();
    }
    
}
