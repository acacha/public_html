/*
 * @(#)ListSelectionScreen.java	1.3 04/03/22
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */

package example.pim;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.MIDlet;
import javax.microedition.pim.PIM;
import javax.microedition.pim.PIMException;
import javax.microedition.pim.PIMList;

/**
 * Demonstrate the use of JSR 75 PIM APIs
 */
public class ListSelectionScreen extends List implements CommandListener, Runnable {
    
    private final Command selectCommand = new Command("Select", Command.OK, 1);
    private final Command backCommand = new Command("Back", Command.BACK, 1);
    private final PIMDemo midlet;
    private final Displayable caller;
    private final int listType;
    
    public ListSelectionScreen(PIMDemo midlet, Displayable caller, int listType) {
        super("Select a list", List.IMPLICIT);
        String[] lists = PIM.getInstance().listPIMLists(listType);
        for (int i = 0; i < lists.length; i++) {
            append(lists[i], null);
        }
        setSelectCommand(selectCommand);
        addCommand(backCommand);
        setCommandListener(this);
        this.midlet = midlet;
        this.caller = caller;
        this.listType = listType;
    }
    
    public void commandAction(Command command, Displayable displayable) {
        if (command == backCommand) {
           Display.getDisplay(midlet).setCurrent(caller);
        } else if (command == selectCommand) {
            Form form = new Form("Loading PIM list");
            form.append("Please wait...");
            Display.getDisplay(midlet).setCurrent(form);
            new Thread(this).start();
        }
    }
    
    public void run() {
        String listName = getString(getSelectedIndex());
        try {
            PIMList list = PIM.getInstance()
                .openPIMList(listType, PIM.READ_WRITE, listName);
            Displayable screen =
                new ItemSelectionScreen(midlet, this, listType, list);
            Display.getDisplay(midlet).setCurrent(screen);
        } catch (Exception e) {
            midlet.reportException(e, this);
        }
    }
    
}
