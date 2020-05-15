/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReviewAnda;

import java.awt.Container;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Orenji
 */
public class ReviewAndaView extends JFrame{
    Font fontt = new Font("SanSerif", Font.PLAIN, 20);
    Font font_isi = new Font("SanSerif", Font.PLAIN, 14);
    
    JTable tabel;
    Container c;
    Object[] kolom = {"Movie","Visual Audio","Plot","Karakter","Keseluruhan","Review"};
    DefaultTableModel model;
    JScrollPane pane;
    
    JFrame frame = new JFrame("Review Anda");
    
    JButton b_refresh = new JButton("Refresh");
    JButton b_cari = new JButton("Cari");
    
    JTextField t_cari = new JTextField();
    
    JLabel background = new JLabel();
    
    private String username;

    public ReviewAndaView(String username) {
        this.username = username;
        
        model = new DefaultTableModel(kolom,0);
        tabel = new JTable(model);
        pane = new JScrollPane(tabel);
        
        Font font = new Font("",1,16);
       
        frame.setLayout(null);
        frame.setTitle("Review Anda");
        frame.setSize(900,400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        
        frame.add(pane);
        pane.setBounds(0, 60, 880, 320);
        
        frame.add(t_cari);
        t_cari.setBounds(20, 20, 120, 20);
        
        frame.add(b_cari);
        b_cari.setBounds(160, 20, 60, 20);
        
        frame.add(b_refresh);
        b_refresh.setBounds(240, 20, 120, 20);
        
        frame.add(background);
        background.setIcon(new ImageIcon("D:\\onedrive\\Pictures\\try.jpg"));
        background.setBounds(0,0,900,400);

    }
//    public static void main(String[] args) {
//        new ReviewAndaView("satya");
//    }

    public String getUsername() {
        return username;
    } 
    
    public String getJudul(){
        return t_cari.getText();
    }
}
