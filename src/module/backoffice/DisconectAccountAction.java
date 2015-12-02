/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.backoffice;

import interfaces.IActionBackOffice;

/**
 *
 * @author Lucas
 */
public class DisconectAccountAction extends IActionBackOffice{
    
    @Override
    public boolean execute(Object ... object) {
        System.exit(0);
        return true;
    }

}
