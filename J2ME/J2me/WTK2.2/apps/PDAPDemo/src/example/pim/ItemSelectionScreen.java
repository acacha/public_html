/*
 * @(#)ItemSelectionScreen.java	1.6 04/07/12
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */

package example.pim;

import java.util.Enumeration;
import java.util.Vector;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.MIDlet;
import javax.microedition.pim.Contact;
import javax.microedition.pim.ContactList;
import javax.microedition.pim.Event;
import javax.microedition.pim.EventList;
import javax.microedition.pim.PIM;
import javax.microedition.pim.PIMException;
import javax.microedition.pim.PIMItem;
import javax.microedition.pim.PIMList;
import javax.microedition.pim.ToDo;
import javax.microedition.pim.ToDoList;

/**
 * Demonstrate the use of JSR 75 PIM APIs
 */
public class ItemSelectionScreen extends List implements CommandListener {
    
    private final Command selectCommand = new Command("Select", Command.ITEM, 1);
    private final Command backCommand = new Command("Back", Command.BACK, 1);
    private final Command removeCommand = new Command("Delete", Command.SCREEN, 3);
    private final Command newCommand = new Command("New", Command.SCREEN, 2);
    private final PIMDemo midlet;
    private final Displayable caller;
    private final int listType;
    private final PIMList list;
    private final Vector itemList = new Vector();
    
    public ItemSelectionScreen(PIMDemo midlet, Displayable caller,
        int listType, PIMList list) throws PIMException {
            
        super("Select a PIM item", List.IMPLICIT);
        this.midlet = midlet;
        this.caller = caller;
        this.listType = listType;
        this.list = list;

        populateList();
        
        addCommand(backCommand);
        addCommand(newCommand);
        setCommandListener(this);        
    }
    
    void populateList() throws PIMException {
        deleteAll();
        removeCommand(selectCommand);
        removeCommand(removeCommand);
        itemList.removeAllElements();
        for (Enumeration items = list.items(); items.hasMoreElements();) {
            PIMItem item = (PIMItem) items.nextElement();
            int fieldCode = 0;
            switch (listType) {
                case PIM.CONTACT_LIST:
                    fieldCode = Contact.FORMATTED_NAME;
                    break;
                case PIM.EVENT_LIST:
                    fieldCode = Event.SUMMARY;
                    break;
                case PIM.TODO_LIST:
                    fieldCode = ToDo.SUMMARY;
                    break;
            }
            String label = getDisplayedField(item);
            if (label == null) {
                label = "<Incomplete data>";
            }
            append(label, null);
            itemList.addElement(item);
        }
        if (size() > 0) {
            setSelectCommand(selectCommand);
            addCommand(removeCommand);
        }
    }
    
    public void commandAction(Command command, Displayable displayable) {
        if (command == backCommand) {
           Display.getDisplay(midlet).setCurrent(caller);
        } else if (command == selectCommand) {
            try {
                PIMItem item = (PIMItem) itemList.elementAt(getSelectedIndex());
                Displayable screen = new ItemDisplayScreen(midlet, this, item);
                Display.getDisplay(midlet).setCurrent(screen);
            } catch (Exception e) {
                midlet.reportException(e, this);
            }
        } else if (command == removeCommand) {
            try {
                PIMItem item = (PIMItem) itemList.elementAt(getSelectedIndex());
                switch (listType) {
                    case PIM.CONTACT_LIST:
                        ((ContactList) list).removeContact((Contact) item);
                        break;
                    case PIM.EVENT_LIST:
                        ((EventList) list).removeEvent((Event) item);
                        break;
                    case PIM.TODO_LIST:
                        ((ToDoList) list).removeToDo((ToDo) item);
                        break;
                }
                populateList();
            } catch (Exception e) {
                midlet.reportException(e, this);
            }
        } else if (command == newCommand) {
            try {
                PIMItem item = null;
                switch (listType) {
                    case PIM.CONTACT_LIST:
                        item = ((ContactList) list).createContact();
                        break;
                    case PIM.EVENT_LIST:
                        item = ((EventList) list).createEvent();
                        break;
                    case PIM.TODO_LIST:
                        item = ((ToDoList) list).createToDo();
                        break;
                }
                int fieldCode = getDisplayedFieldCode();
                item.addString(fieldCode, PIMItem.ATTR_NONE, "");
                Displayable screen = new ItemDisplayScreen(midlet, this, item);
                Display.getDisplay(midlet).setCurrent(screen);
            } catch (Exception e) {
                midlet.reportException(e, this);
            }
        }
    }
    
    
    int getDisplayedFieldCode() {
        int fieldCode = 0;
        switch (listType) {
            case PIM.CONTACT_LIST:
                fieldCode = Contact.FORMATTED_NAME;
                break;
            case PIM.EVENT_LIST:
                fieldCode = Event.SUMMARY;
                break;
            case PIM.TODO_LIST:
                fieldCode = ToDo.SUMMARY;
                break;
        }
        return fieldCode;
    }
    
    void fixDisplayedField(PIMItem item) {
        int fieldCode = getDisplayedFieldCode();
        if (listType == PIM.CONTACT_LIST) {
            boolean defined = false;
            if (item.countValues(fieldCode) != 0) {
                String s = item.getString(fieldCode, 0);
                if (s != null && s.trim().length() > 0) {
                    defined = true;
                }
            }
            if (!defined) {
                // try to fill in the values from NAME
                if (item.countValues(Contact.NAME) != 0) {
                    String[] a = item.getStringArray(Contact.NAME, 0);
                    if (a != null) {
                        StringBuffer sb = new StringBuffer();
                        if (a[Contact.NAME_GIVEN] != null) {
                            sb.append(a[Contact.NAME_GIVEN]);
                        }
                        if (a[Contact.NAME_FAMILY] != null) {
                            if (sb.length() > 0) {
                                sb.append(" ");
                            }
                            sb.append(a[Contact.NAME_FAMILY]);
                        }
                        String s = sb.toString().trim();
                        if (s.length() > 0) {
                            if (item.countValues(fieldCode) == 0) {
                                item.addString(fieldCode, Contact.ATTR_NONE, s);
                            } else {
                                item.setString(fieldCode, 0, Contact.ATTR_NONE, s);
                            }
                        }
                    }
                }
            }
        }
    }
    
    String getDisplayedField(PIMItem item) {
        int fieldCode = getDisplayedFieldCode();
        fixDisplayedField(item);
        String fieldValue = null;
        if (item.countValues(fieldCode) != 0) {
            String s = item.getString(fieldCode, 0);
            if (s != null && s.trim().length() != 0) {
                fieldValue = s;
            }
        }
        return fieldValue;
    }
    
}
