/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.backoffice;

import panda.prod.application.PandaProdApplication;
import errorMessage.CodeError;
import interfaces.IActionBackOffice;
import javax.swing.JOptionPane;
import model.User;
import view.component.PandaProdPasswordField;
import view.component.PandaProdTextField;

/**
 *
 * @author Lucas
 */
public class ConnectAccountAction extends IActionBackOffice {

    @Override
    public boolean execute(Object... object) {
        PandaProdApplication application = PandaProdApplication.getApplication();
        String login = ((PandaProdTextField) application.getMainFrameJComponent("pandaProdTextFieldLogin")).getText();
        String password = new String(((PandaProdPasswordField) application.getMainFrameJComponent("pandaProdPasswordFieldPassword")).getPassword());

        User u = application.getUser();
        u.setLoginAdressMail(login);
        u.setPassword(password);

        if (u.connect() != CodeError.SUCESS) {
            new JOptionPane();
            JOptionPane.showMessageDialog(null, "Connexion impossible, merci de vérifier votre login",
                    "Connexion à Cookie Swipe", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
