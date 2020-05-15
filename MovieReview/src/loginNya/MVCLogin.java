/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginNya;

/**
 *
 * @author Satya
 */
public class MVCLogin {
    LoginView viewnya = new LoginView();
    LoginModel modelnya = new LoginModel();
    LoginController controllernya  = new LoginController(modelnya, viewnya);
}
