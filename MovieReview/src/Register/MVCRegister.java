/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;

/**
 *
 * @author Orenji
 */
public class MVCRegister {
    RegisterView registerView = new RegisterView();
    RegisterModel registerModel = new RegisterModel();
    RegisterContoller registerContoller = new RegisterContoller(registerView, registerModel);
}
