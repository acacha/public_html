/*
 * @(#)TextFieldDemo.java	1.7 04/04/25
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */


package textfield;

import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.*;
/**
 * The text field demo displays all of the text field types on the screen
 * allowing the user to edit them at will.
 *
 * @version 2.0
 */

public class TextFieldDemo extends MIDlet implements CommandListener {

    private Command exitCommand = new Command("Exit", Command.EXIT, 1);
    
    private boolean firstTime;
    
    private Form mainForm;
    
    public TextFieldDemo() {
        firstTime = true;
        mainForm = new Form("Text Field");
    }
    
    protected void startApp() {
        if (firstTime) {
            mainForm.append("This demo contains text fields each one " +
                    "with a different constraint");
    
            mainForm.append(
	            new TextField("Any Character", "", 15, TextField.ANY));
            mainForm.append(
		    new TextField("E-Mail", "", 15, TextField.EMAILADDR));
            mainForm.append(new TextField("Number", "", 15, TextField.NUMERIC));
            mainForm.append(
                    new TextField("Decimal", "", 15, TextField.DECIMAL));
            mainForm.append(
                    new TextField("Phone", "", 15, TextField.PHONENUMBER));
            mainForm.append(
                    new TextField("Password", "", 15, TextField.PASSWORD));
            mainForm.append(new TextField("URL", "", 15, TextField.URL));
            
            mainForm.addCommand(exitCommand);
            mainForm.setCommandListener(this);
            firstTime = false;
        }
        Display.getDisplay(this).setCurrent(mainForm);
    }
    
    public void commandAction(Command c, Displayable s) {
	if (c == exitCommand) {
	    destroyApp(false);
	    notifyDestroyed();
	}	
    }
    
    protected void destroyApp(boolean unconditional) {
    }
    
    protected void pauseApp() {
    }
}
