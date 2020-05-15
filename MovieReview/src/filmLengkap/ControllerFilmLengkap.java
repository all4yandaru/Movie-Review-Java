/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmLengkap;

import filmDetail.MVCFilmDetail;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Satya
 */
public class ControllerFilmLengkap {
    ModelFilmLengkap modelnya;
    ViewFilmLengkap viewnya;
    String dataterpilih = null;
    int baris,kolom;

    public ControllerFilmLengkap(ModelFilmLengkap modelnya, ViewFilmLengkap viewnya) {
        this.modelnya = modelnya;
        this.viewnya = viewnya;
        
         if (modelnya.banyaknyaData() != 0) {
            String kontaknya[][] = modelnya.tampilkanData();
            viewnya.tabel.setModel(new JTable(kontaknya, viewnya.kolom).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        viewnya.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                baris = viewnya.tabel.getSelectedRow();
                dataterpilih = viewnya.tabel.getValueAt(baris, 0).toString();
                JOptionPane.showMessageDialog(null, "cek Film");
                MVCFilmDetail detail = new MVCFilmDetail(dataterpilih);
                //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    
}
