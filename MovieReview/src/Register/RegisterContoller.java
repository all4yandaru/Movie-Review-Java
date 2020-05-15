/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Orenji
 */
public class RegisterContoller {
    RegisterView registerView;
    RegisterModel registerModel;

    public RegisterContoller(RegisterView registerView, RegisterModel registerModel) {
        this.registerView = registerView;
        this.registerModel = registerModel;
        
        this.registerView.b_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // buat register akun
                String username = registerView.getFusername();
                String password = registerView.getFpassword();
                String password_confirm = registerView.getFpasswordConfirm();
                
                if (username.equals("") || password.equals("") || password_confirm.equals("")) { // ngecek field kosong atau engga
                    JOptionPane.showMessageDialog(null, "field kosong");
                }
                else {
                    System.out.println(password + " " + password_confirm);
                    if (password.equals(password_confirm)) { // ngecek password sama atau engga
                        System.out.println("yey");
                        if (!registerModel.cekUser(username)) {
                            registerModel.registerUser(username, password);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Password tidak sama");
                    }
                }
                
                
            }
        });
        
        this.registerView.b_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                registerView.fusername.setText("");
                registerView.fpassword.setText("");
                registerView.fpassword_confirm.setText("");
            }
        });
        
    }

}
