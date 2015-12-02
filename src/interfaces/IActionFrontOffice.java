/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.HashMap;
import view.component.PandaProdFrame;

/**
 *
 * @author mickx
 */
public abstract class IActionFrontOffice extends IActionBackOffice{
   
    protected HashMap<String, Object> hsJcomponent;

    public IActionFrontOffice(PandaProdFrame ppFrame) {
        hsJcomponent = ppFrame.getJComponent();
    }
}
