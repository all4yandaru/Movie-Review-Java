/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainMenu;

/**
 *
 * @author Orenji
 */
public class MVCMainMenu {
    private String username;
    

    public MVCMainMenu(String username) {
        this.username = username;
        MainMenuView mainMenuView = new MainMenuView(username);
        MainMenuController mainMenuController = new MainMenuController(mainMenuView);
    }

    public String getUsername() {
        return username;
    }
}
