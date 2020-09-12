/*
 * %W% %E%
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */
package list;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;


/**
 * The MIDlet demonstrates the different types of list supported by MIDP-2.0:
 *      EXCLUSIVE - a choice having exactly one element selected at time.
 *      IMPLICIT  - a choice in which the currently focused element is
 *                  selected when a Command is initiated.
 *      MULTIPLE  - a choice that can have arbitrary number of elements
 *                  selected at a time.
 *
 * @version 2.0
 */
public class ListDemo
    extends MIDlet
    implements CommandListener {
    private final static Command CMD_EXIT =
	    new Command("Exit", Command.EXIT, 1);
    private final static Command CMD_BACK =
	    new Command("Back", Command.BACK, 1);
    private Display display;
    private List mainList;
    private List exclusiveList;
    private List implicitList;
    private List multipleList;
    
    private boolean firstTime;

    public ListDemo() {
        display = Display.getDisplay(this);

        // these are the strings for the choices.
        String[] stringArray = {
            "Option A", 
            "Option B", 
            "Option C", 
            "Option D"
        };

        // the string elements will have no images
        Image[] imageArray = null;


        /*
	 * create samples of the supported types:
         *      "Exclusive", "Implicit" and  "Multiple"
	 */

        exclusiveList = new List("Exclusive", Choice.EXCLUSIVE, stringArray, 
                                 imageArray);
        exclusiveList.addCommand(CMD_BACK);
        exclusiveList.addCommand(CMD_EXIT);
        exclusiveList.setCommandListener(this);

        implicitList = new List("Implicit", Choice.IMPLICIT, stringArray, 
                                imageArray);
        implicitList.addCommand(CMD_BACK);
        implicitList.addCommand(CMD_EXIT);
        implicitList.setCommandListener(this);

        multipleList = new List("Multiple", Choice.MULTIPLE, stringArray, 
                                imageArray);
        multipleList.addCommand(CMD_BACK);
        multipleList.addCommand(CMD_EXIT);
        multipleList.setCommandListener(this);
        
        firstTime = true;
    }

    protected void startApp() {
        if (firstTime) {
            // these are the images and strings for the choices.
            Image[] imageArray = null;
    
            try {
                // load the duke image to place in the image array
                Image icon = Image.createImage("/midp/uidemo/Icon.png");
    
    
                // these are the images and strings for the choices.
                imageArray = new Image[] {
                    icon, 
                    icon, 
                    icon
                };
            } catch (java.io.IOException err) {
                // ignore the image loading failure the application can recover.
            }
    
            String[] stringArray = {
                "Exclusive", 
                "Implicit", 
                "Multiple"
            };
            mainList = new List("Choose type", Choice.IMPLICIT, stringArray, 
                                imageArray);
            mainList.addCommand(CMD_EXIT);
            mainList.setCommandListener(this);
            display.setCurrent(mainList);
            firstTime = false;
        }
    }

    protected void destroyApp(boolean unconditional) {
    }

    protected void pauseApp() {
    }

    public void commandAction(Command c, Displayable d) {
        if (d.equals(mainList)) {
            // in the main list
            if (c == List.SELECT_COMMAND) {
                if (d.equals(mainList)) {
                    switch (((List)d).getSelectedIndex()) {
                        case 0:
                            display.setCurrent(exclusiveList);

                            break;

                        case 1:
                            display.setCurrent(implicitList);

                            break;

                        case 2:
                            display.setCurrent(multipleList);

                            break;
                    }
                }
            }
        } else {
            // in one of the sub-lists
            if (c == CMD_BACK) {
                display.setCurrent(mainList);
            }
        }

        if (c == CMD_EXIT) {
            destroyApp(false);
            notifyDestroyed();
        }
    }
}

