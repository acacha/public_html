/*
 * @(#)ListTypeSelectionScreen.java	1.4 04/05/27
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */

package example.pim;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.MIDlet;
import javax.microedition.pim.PIM;

/**
 * Demonstrate the use of JSR 75 PIM APIs
 */
public class ListTypeSelectionScreen extends List implements CommandListener {
    
    private final Command selectCommand = new Command("Select", Command.OK, 1);
    private final Command exitCommand = new Command("Exit", Command.EXIT, 1);
    private final PIMDemo midlet;
    
    private static final String CONTACT_TYPE = "Contact Lists";
    private static final String EVENT_TYPE = "Event Lists";
    private static final String TODO_TYPE = "To-Do Lists";
    
    public ListTypeSelectionScreen(PIMDemo midlet) {
        super("Select a list type", List.IMPLICIT);
        append(CONTACT_TYPE, null);
        append(EVENT_TYPE, null);
        append(TODO_TYPE, null);
        setSelectCommand(selectCommand);
        addCommand(exitCommand);
        setCommandListener(this);
        this.midlet = midlet;
    }
    
    public void commandAction(Command command, Displayable displayable) {
        if (command == exitCommand) {
           midlet.exit();
        } else if (command == selectCommand) {
            final int listType = getSelectedIndex() + PIM.CONTACT_LIST;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Displayable screen =
                            new ListSelectionScreen(midlet,
                                ListTypeSelectionScreen.this, listType);
                        Display.getDisplay(midlet).setCurrent(screen);
                    } catch (Exception e) {
                        midlet.reportException(e, ListTypeSelectionScreen.this);
                    }
                }
            }).start();
        }
    }    
    
}
