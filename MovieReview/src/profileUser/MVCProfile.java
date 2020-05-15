/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profileUser;

/**
 *
 * @author Satya
 */
public class MVCProfile {
    private String username;

    public MVCProfile(String username) {
        this.username = username;
        ProfileView viewnya = new ProfileView(username);
        ProfileModel modelnya = new ProfileModel();
        ProfileController controllernya = new ProfileController(modelnya, viewnya);
    }
    
    public String getUsername() {
        return username;
    }
}
