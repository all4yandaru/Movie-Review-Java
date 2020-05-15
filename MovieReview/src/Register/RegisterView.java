/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Orenji
 */
public class RegisterView extends JFrame{
    Font fontt = new Font("SanSerif", Font.PLAIN, 20);
    Font font_isi = new Font("SanSerif", Font.PLAIN, 14);

    JFrame frame = new JFrame("Register");
    JLabel lregister = new JLabel("Register");
    
    JLabel lusername = new JLabel("Username");
    JTextField fusername = new JTextField();
    
    JLabel lpassword = new JLabel("Password");
    JPasswordField fpassword = new JPasswordField();
    
    JLabel lpassword_confirm = new JLabel("Ulangi password");
    JPasswordField fpassword_confirm = new JPasswordField();
    
    JButton b_reset = new JButton("Reset");
    JButton b_register = new JButton("Register");
    
    JLabel background = new JLabel();

    RegisterView() {      
        frame.setLayout(null);
        frame.setSize(450,525);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        
        frame.add(lregister);
        lregister.setFont(fontt);
        lregister.setBounds(175, 45, 100, 25); 
        
        frame.add(lusername);
        lusername.setBounds(50, 105, 60, 20);
        frame.add(fusername);
        fusername.setBounds(170, 105, 150, 20);
        
        frame.add(lpassword);
        lpassword.setBounds(50, 165, 60, 20);
        frame.add(fpassword);
        fpassword.setBounds(170, 165, 150, 20);
        
        frame.add(lpassword_confirm);
        lpassword_confirm.setBounds(50, 225, 100, 20);
        frame.add(fpassword_confirm);
        fpassword_confirm.setBounds(170, 225, 150, 20);
        
        frame.add(b_register);
        b_register.setBounds(245, 285, 100, 20);
        
        frame.add(b_reset);
        b_reset.setBounds(95, 285, 100, 20);
        
        frame.add(background);
        background.setIcon(new ImageIcon("D:\\onedrive\\Pictures\\try1.jpg"));
        background.setBounds(0,0,450,525);
        
    }
    
    public String getFusername() {
        return fusername.getText();
    }

    public String getFpassword() {
        return fpassword.getText();
    }
    
    public String getFpasswordConfirm() {
        return fpassword_confirm.getText();
    }
}
