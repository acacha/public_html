/*
 * %W% %E%
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */
package stringitem;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;


/**
 * This is the main class for the UI MIDP demo. This demo of the components
 * available in the UI is designed for simplicity. Each UI element is
 * demonstrated within a class of its own derived from either BaseDemo
 * or BaseListDemo.
 *
 * @version 2.0
 */
public class StringItemDemo
    extends MIDlet
    implements CommandListener, ItemCommandListener {

    private Display display;
    private Form mainForm;
    private final static Command CMD_GO = new Command("Go", Command.ITEM, 1);
    private final static Command CMD_PRESS =
	    new Command("Press", Command.ITEM, 1);
    private final static Command CMD_EXIT =
	    new Command("Exit", Command.EXIT, 1);
    
    /**
     * Signals the MIDlet to start and enter the Active state.
     */
    protected void startApp() {
        display = Display.getDisplay(this);

        mainForm = new Form("String Item Demo");
        mainForm.append("This is a simple label");

        StringItem item = new StringItem("This is a StringItem label: ", 
                                         "This is the StringItems text");
        mainForm.append(item);
        item = new StringItem("Short label: ", "text");
        mainForm.append(item);
        item = new StringItem("Hyper-Link ", "hyperlink", Item.HYPERLINK);
        item.setDefaultCommand(CMD_GO);
        item.setItemCommandListener(this);
        mainForm.append(item);
        item = new StringItem("Button ", "Button", Item.BUTTON);
        item.setDefaultCommand(CMD_PRESS);
        item.setItemCommandListener(this);
        mainForm.append(item);
        mainForm.addCommand(CMD_EXIT);
        mainForm.setCommandListener(this);
        display.setCurrent(mainForm);
    }

    public void commandAction(Command c, Item item) {
        if (c == CMD_GO) {
            String text = "Go to the URL...";
            Alert a = new Alert("URL", text, null, AlertType.INFO);
            display.setCurrent(a);
        } else if (c == CMD_PRESS) {
            String text = "Do an action...";
            Alert a = new Alert("Action", text, null, AlertType.INFO);
            display.setCurrent(a);
        }
    }

    public void commandAction(Command c, Displayable d) {
            destroyApp(false);
            notifyDestroyed();        
    }
    
    /**
     * Signals the MIDlet to terminate and enter the Destroyed state.
     */
    protected void destroyApp(boolean unconditional) {
    }

    /**
     * Signals the MIDlet to stop and enter the Paused state.
     */
    protected void pauseApp() {
    }            
}
