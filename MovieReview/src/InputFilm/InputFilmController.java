/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputFilm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Orenji
 */
public class InputFilmController {
    InputFilmModel filmModel;
    InputFilmView filmView;

    public InputFilmController(InputFilmModel filmModel, InputFilmView filmView) {
        this.filmModel = filmModel;
        this.filmView = filmView;
        
        this.filmView.b_input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // input review baru
                String judul = filmView.getJudul();
                String genre = filmView.getGenre();
                String durasi = filmView.getDurasi();
                String sutradara = filmView.getSutradara();
                String visual_audio = filmView.getVisualAudio();
                String plot = filmView.getPlot();
                String karakter = filmView.getKarakter();
                String review = filmView.getReview();
                
                if (judul.equals("") || genre.equals("") || durasi.equals("") || sutradara.equals("")
                        || visual_audio.equals("") || karakter.equals("") || plot.equals("") || review.equals("")) {
                    JOptionPane.showMessageDialog(null, "field kosong");
                }
                else {
                    
                    try{
                        // parsing string ke int
                        int intDurasi = Integer.parseInt(durasi);
                        int intVisualAudio = Integer.parseInt(visual_audio);
                        int intPlot = Integer.parseInt(plot);
                        int intKarakter = Integer.parseInt(karakter);
                        
                        // ngecek durasi dan komponen penilaian film itu antara 0 - 100
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
                            filmModel.inputData(judul,genre,intDurasi,sutradara,intVisualAudio,intPlot,intKarakter,review);
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "Durasi dan komponen penilaian film harus angka 0-100");
                    }
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
