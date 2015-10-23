/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import panda.prod.application.PandaProdApplication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.backoffice.ConnectAccountAction;
import module.backoffice.CreateAccountAction;
import module.ihm.InscriptionFrameInitializer;
import view.InscriptionPPFrame;
import view.MainPPFrame;
import view.component.PandaProdPasswordField;
import view.component.PandaProdTextField;

public class Dispatcher implements ActionListener {

    private PandaProdApplication application;

    public Dispatcher() {
        application = PandaProdApplication.getApplication();
    }

    
    /**
     * Distribue les actions de l'utilsiateur à des traitements
     *
     * @param e Evénement décrivant l'action à réaliser
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionName = e.getActionCommand() + "Action";
        try {
            Method actionToPerform = Dispatcher.class.getDeclaredMethod(actionName);
            actionToPerform.invoke(this);
        } catch (InvocationTargetException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, "Unknown action: " + actionName, ex);
        }
    }

    public void logAccountAction() {
        System.err.println("log");
        boolean connect = new ConnectAccountAction().execute();
        if (connect) {
            application.getMainFrame().dispose();
            application.setMainFrame(new MainPPFrame());
        }
    }

    public void updateAccountAction() {

    }

    public void forgottenPasswordAction() {

    }

    public void forgottenLoginAction() {

    }

    public void logoutAction() {

    }

    public void createAccountAction() { // compte cookie swipe a créé
        System.err.println("create");
        boolean created = new CreateAccountAction().execute();
        if (created) {
            application.getFocusFrame().dispose();
        }
    }

    public void inscriptionAction() {
        System.err.println("Inscription");
        application.setFocusFrame(new InscriptionPPFrame());
        new InscriptionFrameInitializer(application.getFocusFrame()).execute();

    }
}
