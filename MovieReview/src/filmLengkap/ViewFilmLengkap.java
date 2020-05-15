/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmLengkap;

import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Satya
 */
public class ViewFilmLengkap {
    Font fontt = new Font("SanSerif", Font.PLAIN, 20);
    Font font_isi = new Font("SanSerif", Font.PLAIN, 14);
    
    JTable tabel;
    Container c;
    Object[] kolom = {"ID","Film","Sutradara","Nilai"};
    DefaultTableModel model;
    JScrollPane pane;
    
    JFrame frame = new JFrame("Film");
    JLabel background = new JLabel();


    public ViewFilmLengkap() {
        model = new DefaultTableModel(kolom,0);
        tabel = new JTable(model);
        pane = new JScrollPane(tabel);
        
        tabel.setModel(model);
//        tabel.setBackground(Color.PINK);
//        tabel.setForeground(Color.black);
        Font font = new Font("",1,16);
        tabel.setFont(font);
        tabel.setRowHeight(30);
        
        frame.setLayout(null);
        frame.setTitle("Film");
        frame.setSize(900,400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        pane.setBounds(0, 0, 880, 320);
//      pane.setBackground(Color.PINK);
        frame.add(pane);
        
        frame.add(background);
        background.setIcon(new ImageIcon("D:\\onedrive\\Pictures\\try.jpg"));
        background.setBounds(0,0,900,400);
    }
    
    public static void main(String[] args) {
        new ViewFilmLengkap();
    }
}
