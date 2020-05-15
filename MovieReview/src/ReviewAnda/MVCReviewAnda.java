/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReviewAnda;

/**
 *
 * @author Orenji
 */
public class MVCReviewAnda {

    private String username;
    
    public MVCReviewAnda(String username) {
        this.username = username;
        ReviewAndaView reviewAndaView = new ReviewAndaView(username);
        ReviewAndaModel reviewAndaModel = new ReviewAndaModel();
        ReviewAndaController reviewAndaController = new ReviewAndaController(reviewAndaView, reviewAndaModel);
    }

    public String getUsername() {
        return username;
    }
    
    
}
