/*
 * %W% %E%
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */
package textbox;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;


/**
 * The textbox demo displays a list of all the text box types and allows the
 * user to select a specific type of text box to try.
 *
 * @version 2.0
 */
public class TextBoxDemo
    extends MIDlet
    implements CommandListener {

    private Display display;

    private ChoiceGroup types;
    private ChoiceGroup options;
    private Form mainForm;
    private final static Command CMD_EXIT = new Command("Exit", 
                                                           Command.EXIT, 1);
    private final static Command CMD_BACK = new Command("Back", 
                                                           Command.BACK, 1);
    private final static Command CMD_SHOW = new Command("Show", Command.SCREEN, 
                                                        1);

    /**
     * The labels for the supported textboxs.
     */
    static final String[] textBoxLabels = {
        "Any Character", "E-Mail", "Number", "Decimal", "Phone", "Url"
    };

    /**
     * The supported textbox types.
     */
    static final int[] textBoxTypes = {
        TextField.ANY, TextField.EMAILADDR, TextField.NUMERIC, 
        TextField.DECIMAL, TextField.PHONENUMBER, TextField.URL
    };

    private boolean firstTime;
    
    public TextBoxDemo() {
        display = Display.getDisplay(this);
        firstTime = true;
    }

    protected void startApp() {
        if (firstTime) {
            mainForm = new Form("Select a Text Box Type");
            mainForm.append("Select a text box type");
    
            // the string elements will have no images
            Image[] imageArray = null;
    
            types = new ChoiceGroup("Choose type", Choice.EXCLUSIVE, 
                                                textBoxLabels, imageArray);
            mainForm.append(types);
    
            // advanced options
            String[] optionStrings = { "As Password", "Show Ticker" };
            options = new ChoiceGroup("Options", Choice.MULTIPLE, 
                                                  optionStrings, null);
            mainForm.append(options);
            mainForm.addCommand(CMD_SHOW);
            mainForm.addCommand(CMD_EXIT);
            mainForm.setCommandListener(this);
            firstTime = false;
        }
        display.setCurrent(mainForm);
    }

    protected void destroyApp(boolean unconditional) {
    }

    protected void pauseApp() {
    }

    public void commandAction(Command c, Displayable d) {

        if (c == CMD_EXIT) {
            destroyApp(false);
            notifyDestroyed();
        } else if (c == CMD_SHOW) {

            // these are the images and strings for the choices.
            Image[] imageArray = null;
            int index = types.getSelectedIndex();
            String title = textBoxLabels[index];
            int choiceType = textBoxTypes[index];            
            boolean[] flags = new boolean[2];            
            options.getSelectedFlags(flags);
            if (flags[0]) {
                choiceType |= TextField.PASSWORD;
            }
            TextBox textBox = new TextBox(title, "", 50, 
                                           choiceType);
            if (flags[1]) {
                textBox.setTicker(new Ticker("TextBox: " + title));
            }
            textBox.addCommand(CMD_BACK);
            textBox.setCommandListener(this);
            display.setCurrent(textBox);
        } else if (c == CMD_BACK) {
            display.setCurrent(mainForm);
        }
    }
}
