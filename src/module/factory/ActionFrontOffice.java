/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.factory;

import interfaces.IActionFrontOffice;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.component.PandaProdFrame;

/**
 *
 * @author Lucas
 */
public class ActionFrontOffice {

    private ActionFrontOffice() {
    }

    public static ActionFrontOffice getInstance() {
        return ActionFrontOfficeHolder.INSTANCE;
    }

    private static class ActionFrontOfficeHolder {

        private static final ActionFrontOffice INSTANCE = new ActionFrontOffice();
    }

    public IActionFrontOffice createAction(Class c, PandaProdFrame ppFrame) {
        IActionFrontOffice action = null;
        Constructor ctr = null;
        try {
            ctr = c.getDeclaredConstructor(PandaProdFrame.class);
            ctr.setAccessible(true);

        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(ActionFrontOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            action = (IActionFrontOffice) ctr.newInstance(ppFrame);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(ActionFrontOffice.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.err.println("FACTORY TRY " + action);

        return action;
    }
}
