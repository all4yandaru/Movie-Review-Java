/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainMenu;

import InputFilm.MVCInputFilm;
import ReviewAnda.MVCReviewAnda;
import filmLengkap.MVCFilmLengkap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import profileUser.MVCProfile;

/**
 *
 * @author Orenji
 */
public class MainMenuController {
    MainMenuView mainMenuView;

    public MainMenuController(MainMenuView mainMenuView) {
        this.mainMenuView = mainMenuView;
        
        System.out.println(mainMenuView.getUsername());
        
        this.mainMenuView.b_input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // pindah ke bagian input
                MVCInputFilm mVCInputFilm = new MVCInputFilm(mainMenuView.getUsername());
            }
        });
        
        
        this.mainMenuView.b_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // pindah ke bagian update
                MVCReviewAnda reviewAnda = new MVCReviewAnda(mainMenuView.getUsername());
            }
        });
        
        
        this.mainMenuView.b_lihat_data_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // pindah ke data review user
                MVCProfile profile = new MVCProfile(mainMenuView.getUsername());
            }
        });
        
        
        this.mainMenuView.b_lihat_data_semua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // pindah ke data review semua user
                MVCFilmLengkap film = new MVCFilmLengkap();
            }
        });
        
    }
    
    
}
