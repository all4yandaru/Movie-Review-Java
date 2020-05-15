/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GantiPass;

/**
 *
 * @author Satya
 */
public class MVCGantiPass {
    private String username;

    public MVCGantiPass(String username) {
        this.username = username;
        GantiPassVIew viewnya = new GantiPassVIew(username);
        GantiPassModel modelnya = new GantiPassModel();
        GantiPassController controllernya = new GantiPassController(viewnya, modelnya);
    }
    
    public String getUsername() {
        return username;
    }
}
