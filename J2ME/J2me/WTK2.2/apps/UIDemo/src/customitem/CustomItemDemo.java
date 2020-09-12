/*
 * %W% %E%
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */
package customitem;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;


/**
 *
 * @version 2.0
 */
public class CustomItemDemo extends MIDlet implements CommandListener {

    private final static Command CMD_EXIT =
	    new Command("Exit", Command.EXIT, 1);
    private Display display;
    
    private boolean firstTime;
    private Form mainForm;
    
    public CustomItemDemo() {
        firstTime = true;
        mainForm = new Form("Custom Item");
    }

    protected void startApp() {
        if (firstTime) {
            display = Display.getDisplay(this);

            mainForm.append(new TextField("Upper Item", null, 10, 0));
            mainForm.append(new Table("Table", Display.getDisplay(this)));
            mainForm.append(new TextField("Lower Item", null, 10, 0));
            mainForm.addCommand(CMD_EXIT);
            mainForm.setCommandListener(this);
            firstTime = false;
        }
        display.setCurrent(mainForm);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == CMD_EXIT) {
            destroyApp(false);
            notifyDestroyed();
        }
    }

    protected void destroyApp(boolean unconditional) {
    }

    protected void pauseApp() {
    }
}
