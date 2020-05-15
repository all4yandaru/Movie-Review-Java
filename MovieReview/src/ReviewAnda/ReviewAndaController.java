/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReviewAnda;

import FilmDetailUpdateDelete.MVCUpdateDelete;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Orenji
 */
public class ReviewAndaController {

    ReviewAndaView andaView;
    ReviewAndaModel andaModel;
    
    int baris,kolom;
    String dataJudul;
    
    ReviewAndaController(ReviewAndaView reviewAndaView, ReviewAndaModel reviewAndaModel) {
        this.andaView = reviewAndaView;
        this.andaModel = reviewAndaModel;
        
        if (andaModel.getBanyakData(andaView.getUsername()) != 0) {
            String dataReview[][] = andaModel.readReview(andaView.getUsername());
            andaView.tabel.setModel((new JTable(dataReview, andaView.kolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Anda belum review apapun");
        }
        
        andaView.b_refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dataReview[][] = andaModel.readReview(andaView.getUsername());
                andaView.tabel.setModel((new JTable(dataReview, andaView.kolom)).getModel());
            }
        });
        
        andaView.b_cari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String judul = andaView.getJudul();
                
                if (judul.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Kosong");
                }
                else {
                    String dataReview[][] = andaModel.cariReview(andaView.getUsername(), andaView.getJudul());
                    andaView.tabel.setModel((new JTable(dataReview, andaView.kolom)).getModel());
                }
            }
        });
        
        andaView.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                baris = andaView.tabel.getSelectedRow();
                dataJudul = andaView.tabel.getValueAt(baris, 0).toString();
                JOptionPane.showMessageDialog(null, "update atau delete " + dataJudul);
                MVCUpdateDelete updateDelete = new MVCUpdateDelete(andaView.getUsername(), dataJudul);
            }
        });
    }
    
}
