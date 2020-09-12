/*
 * %W% %E%
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */
package choicegroup;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;


/**
 * The alert demo displays a list of alerts that will be displayes once the
 * user clicks a list item. These alerts try to present the full range of
 * alert types supported in MIDP.
 *
 * @version 2.0
 */
public class ChoiceGroupDemo
    extends MIDlet implements CommandListener {

    private final static Command CMD_EXIT = new Command("Exit", Command.EXIT, 
                                                        1);        
    private Display display;
    
    private boolean firsttime;
    
    private Form mainForm;
    
    public ChoiceGroupDemo() {
        firsttime = true;
    }

    protected void startApp() {        
        if (firsttime) {
            display = Display.getDisplay(this);

            mainForm = new Form("Choice Group");
            mainForm.append("These are the available choice group types");
            
            // these are the images and strings for the choices.
            Image[] imageArray = null;

            try {

                // load the duke image to place in the image array
                Image duke = Image.createImage("/midp/uidemo/Icon.png");

                // these are the images and strings for the choices.
                imageArray = new Image[] { duke, duke, duke, duke };
            } catch (java.io.IOException err) {
                // ignore the image loading failure the application can recover.
            }

            String[] stringArray = {
                "Option A", "Option B", "Option C", "Option D"
            };

            // create the list of choice groups.
            ChoiceGroup[] groups = {
                new ChoiceGroup("Exclusive", ChoiceGroup.EXCLUSIVE, stringArray,
                                imageArray), 
                new ChoiceGroup("Multiple", ChoiceGroup.MULTIPLE, stringArray, 
                                imageArray), 
                new ChoiceGroup("Pop-Up", ChoiceGroup.POPUP, stringArray, 
                                imageArray)
            };

            for (int iter = 0; iter < groups.length; iter++) {
                mainForm.append(groups[iter]);
            }
            mainForm.addCommand(CMD_EXIT);
            mainForm.setCommandListener(this);
            firsttime = false;
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
