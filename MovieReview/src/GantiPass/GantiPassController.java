/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GantiPass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Satya
 */
public class GantiPassController {
    GantiPassVIew viewnya;
    GantiPassModel modelnya;

    public GantiPassController(GantiPassVIew viewnya, GantiPassModel modelnya) {
        this.viewnya = viewnya;
        this.modelnya = modelnya;
        
        viewnya.b_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewnya.tfPassLama.setText("");
                viewnya.tfPassBaru.setText("");
                viewnya.tfPassKonfirm.setText("");
            }
        });
        viewnya.b_ganti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(viewnya.getTfPassLama().equals("")||viewnya.getTfPassBaru().equals("")||
                viewnya.getTfPassKonfirm().equals("")){
                    JOptionPane.showMessageDialog(null, "field kosong");
                }
                else{
                    String PassLama = viewnya.getTfPassLama();
                    String PassBaru = viewnya.getTfPassBaru();
                    String PassKonfirm  = viewnya.getTfPassKonfirm();
                
                    if (modelnya.cekPassLama(viewnya.getUsername(), PassLama)) {
                        if (PassBaru.equals(PassKonfirm)) {
                            modelnya.gantiPass(viewnya.getUsername(), PassBaru);
                            viewnya.tfPassBaru.setText("");
                            viewnya.tfPassLama.setText("");
                            viewnya.tfPassKonfirm.setText("");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Konfirmasi ulang Password");
                        }
                    }
                }
//                else{
//                    JOptionPane.showMessageDialog(null, "Password Lama Salah");
//                }
            }
        });
    }
    
}
