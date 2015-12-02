/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.backoffice;

import errorMessage.CodeError;
import interfaces.IActionBackOffice;
import javax.swing.JOptionPane;
import model.User;
import panda.prod.application.PandaProdApplication;
import utils.Util;
import view.component.PandaProdPasswordField;
import view.component.PandaProdTextField;

/**
 *
 * @author Yehouda
 */
public class CreateAccountAction extends IActionBackOffice {

    @Override
    public boolean execute(Object... object) {
        PandaProdApplication application = PandaProdApplication.getApplication();
        String login = ((PandaProdTextField) application.getFocusFrameJComponent("pandaProdTextFieldLoginAdressMail")).getText();
        String password = new String(((PandaProdPasswordField) application.getFocusFrameJComponent("pandaProdPasswordFieldPassword")).getPassword());
        String backup = ((PandaProdTextField) application.getFocusFrameJComponent("pandaProdTextFieldBackupMail")).getText();

        if (!Util.isWellFormedMail(backup) || !Util.isWellFormedMail(login)) {
            JOptionPane.showMessageDialog(null, "Votre mail est mal écrit",
                    "Création à Cookie Swipe", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        User u = new User(login, backup, password);
        int code = u.create();
        JOptionPane jOptionPane = new JOptionPane();
        if (code == CodeError.SUCESS) {
            JOptionPane.showMessageDialog(null, "La création du compte à été effectué",
                    "Création à Cookie Swipe", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            if (code == CodeError.STATEMENT_INTEGRITY_CONSTRAINT_VIOLATION) {
                JOptionPane.showMessageDialog(null, "Cette adresse mail est déjà utilisé",
                        "Création à Cookie Swipe", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "La création du compte a échoué",
                        "Création à Cookie Swipe", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
    }

}
