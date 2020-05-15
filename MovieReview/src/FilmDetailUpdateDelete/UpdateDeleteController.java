/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilmDetailUpdateDelete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Orenji
 */
public class UpdateDeleteController {
    UpdateDeleteView view;
    UpdateDeleteModel model;

    public UpdateDeleteController(UpdateDeleteView view, UpdateDeleteModel model) {
        this.view = view;
        this.model = model;
        
        try {
            String[] data = model.ambilData(view.getJudul(), view.getUsername());
            view.visual_audio.setText(data[0]);
            view.plot.setText(data[1]);
            view.karakter.setText(data[2]);
            view.review.setText(data[3]);
        } catch (Exception e) {
        }
        
        view.b_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String 
                        visual_audio = view.getVisualAudio(),
                        plot = view.getPlot(),
                        karakter = view.getKarakter(),
                        review = view.getReview();
                
                
                
                if (visual_audio.equals("") || plot.equals("") || karakter.equals("") || review.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Kosong");
                }
                else {
                    try {
                        int intVisualAudio = Integer.parseInt(visual_audio);
                        int intPlot = Integer.parseInt(plot);
                        int intKarakter = Integer.parseInt(karakter);

                        int[] dataAngka = {intVisualAudio, intPlot, intKarakter};
                        
                        int j=0;
                        for (int i = 0; i < 3; i++) {
                            if (cekAngka(dataAngka[i])) {
                                j++;
                            }
                        }

                        if (j!=3) {
                            JOptionPane.showMessageDialog(null, "Komponen penilaian film harus angka 0-100");
                        }
                        else {
                            System.out.println("angka ada " + j);
                            model.updateReview(view.getJudul(), view.getUsername(), visual_audio, plot, karakter, review);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Komponen penilaian film harus angka 0-100");
                    }
                   
                }
            }
        });
        
        view.b_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    model.DeleteReview(view.getJudul(), view.getUsername());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Data gagal didelete");
                }
                
            }
        });
        
        
    }
    
    public boolean cekAngka(int angka){
        if (angka >=0 && angka <=100) {
            return true;
        }
        return false;
    }
}
