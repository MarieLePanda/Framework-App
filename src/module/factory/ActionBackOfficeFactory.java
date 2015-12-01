/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.factory;

import controller.ActionName;
import interfaces.IAction;

/**
 *
 * @author Lucas
 */
public class ActionBackOfficeFactory {
    
    public IAction createAction(String action){
        
        switch(action){
            case ActionName.createAccount :
                
        }
        
    }
}
