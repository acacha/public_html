/*
 * @(#)DateFieldDemo.java	1.8 04/04/25
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */


package datefield;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;

/**
 * The date field demo simply shows a date component on the screen with 3
 * settings (Date, Time, Date & Time).
 *
 * @version 2.0
 */
public class DateFieldDemo  extends MIDlet implements CommandListener
{
    private final static Command CMD_EXIT = new Command("Exit", Command.EXIT, 
                                                        1);
                                                        
    private boolean firstTime;
    
    private Form mainForm;
    
    public DateFieldDemo() {
        firstTime = true;
        mainForm = new Form("Alert Options");
    }                                                        
                                                        
    protected void startApp() {
            if (firstTime) {
                mainForm.append(new DateField("Date", DateField.DATE));
                mainForm.append(new DateField("Time", DateField.TIME));
                mainForm.append(
		        new DateField("Date & Time", DateField.DATE_TIME));
                mainForm.addCommand(CMD_EXIT);
                mainForm.setCommandListener(this);  
                firstTime = false;
            }
        Display.getDisplay(this).setCurrent(mainForm);
    }    

    protected void destroyApp(boolean unconditional) {
    }    

    protected void pauseApp() {
    }   
    
    public void commandAction(Command c, Displayable d) {
        if (c == CMD_EXIT) {
            destroyApp(false);
            notifyDestroyed();
        }
    }    
}
