/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.factory;

import interfaces.IActionBackOffice;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class ActionBackOfficeFactory {

    private ActionBackOfficeFactory() {
    }

    public static ActionBackOfficeFactory getInstance() {
        return ActionBackOfficeFactoryHolder.INSTANCE;
    }

    private static class ActionBackOfficeFactoryHolder {

        private static final ActionBackOfficeFactory INSTANCE = new ActionBackOfficeFactory();
    }

    public IActionBackOffice createAction(Class c) {
        IActionBackOffice action = null;
        try {
            action = (IActionBackOffice) c.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ActionBackOfficeFactory.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            return action;
        }
    }

}
