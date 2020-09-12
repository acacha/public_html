/*
 * @(#)PIMDemo.java	1.3 04/03/22
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */

package example.pim;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.pim.PIM;

/**
 * Demonstrate the use of JSR 75 PIM APIs
 */
public class PIMDemo extends MIDlet {
    
    public void startApp() {
        Display.getDisplay(this).setCurrent(new ListTypeSelectionScreen(this));
    }
    
    protected void destroyApp(boolean param) { }
    
    protected void pauseApp() { }
    
    void exit() {
        destroyApp(false);
        notifyDestroyed();
    }
    
    void reportException(Exception e, Displayable d) {
        Alert alert = new Alert("Error", e.getMessage(), null, AlertType.ERROR);
        alert.setTimeout(Alert.FOREVER);
        Display.getDisplay(this).setCurrent(alert, d);
        e.printStackTrace();
    }
}
