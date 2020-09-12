/*
 * @(#)SMSSend.java	1.8 04/03/22
 *
 * Copyright (c) 1999-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */

package example.sms;

import javax.microedition.midlet.*;
import javax.microedition.io.*;
import javax.microedition.lcdui.*;
import javax.wireless.messaging.*;

import java.io.IOException;

/**
 * An example MIDlet to send text via an SMS MessageConnection
 */
public class SMSSend extends MIDlet 
    implements CommandListener {

    /** user interface command for indicating Exit request. */
    Command exitCommand  = new Command("Exit", Command.EXIT, 2);
    /** user interface command for proceeding to the next screen */
    Command okCommand = new Command("OK", Command.OK, 1);
    /** current display. */
    Display display;
    /** The port on which we send SMS messages */
    String smsPort;
    /** Area where the user enters the phone number to send the message to */
    TextBox destinationAddressBox;
    /** Error message displayed when an invalid phone number is entered */
    Alert errorMessageAlert;
    /** Alert that is displayed when a message is being sent */
    Alert sendingMessageAlert;
    /** Prompts for and sends the text message */
    SMSSender sender;
    /** The last visible screen when we paused */ 
    Displayable resumeScreen = null;
    
    /**
     * Initialize the MIDlet with the current display object and
     * graphical components. 
     */
    public SMSSend() {
        smsPort = getAppProperty("SMS-Port");

        display = Display.getDisplay(this);

        destinationAddressBox = new TextBox("Destination Address?", 
            null, 256, TextField.PHONENUMBER);
        destinationAddressBox.addCommand(exitCommand);
        destinationAddressBox.addCommand(okCommand);
        destinationAddressBox.setCommandListener(this);
        
        errorMessageAlert = new Alert("SMS", null, null, AlertType.ERROR);
        errorMessageAlert.setTimeout(5000);
    
        sendingMessageAlert = new Alert("SMS", null, null, AlertType.INFO);
        sendingMessageAlert.setTimeout(5000);
        sendingMessageAlert.setCommandListener(this);
        
        sender = new SMSSender(smsPort, display, destinationAddressBox, 
            sendingMessageAlert);
            
        resumeScreen = destinationAddressBox;
    }

    /**
     * startApp should return immediately to keep the dispatcher
     * from hanging.
     */
    public void startApp() {
        display.setCurrent(resumeScreen);
    }

    /**
     * Remember what screen is showing
     */
    public void pauseApp() {
        resumeScreen = display.getCurrent();
    }

    /**
     * Destroy must cleanup everything.
     * @param unconditional true if a forced shutdown was requested
     */
    public void destroyApp(boolean unconditional) {
    }

    /**
     * Respond to commands, including exit
     * @param c user interface command requested
     * @param s screen object initiating the request
     */
    public void commandAction(Command c, Displayable s) {
        try {
            if (c == exitCommand || c == Alert.DISMISS_COMMAND) {
                destroyApp(false);
                notifyDestroyed();
            } else if (c == okCommand) {
                promptAndSend();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Prompt for and send the message
     */
    private void promptAndSend() {
        String address = destinationAddressBox.getString();
        if (!SMSSend.isValidPhoneNumber(address)) {
            errorMessageAlert.setString("Invalid phone number");
            display.setCurrent(errorMessageAlert, destinationAddressBox);
            return;
        }
        String statusMessage = "Sending message to " + address + "...";
        sendingMessageAlert.setString(statusMessage);
        sender.promptAndSend("sms://" + address);
    }
    
    /**
     * Check the phone number for validity
     * Valid phone numbers contain only the digits 0 thru 9, and may contain 
     * a leading '+'.
     */
    private static boolean isValidPhoneNumber(String number) {
        char[] chars = number.toCharArray();
        if (chars.length == 0) {
            return false;
        }
        int startPos = 0;
        // initial '+' is OK
        if (chars[0] == '+') {
            startPos = 1;
        }
        for (int i = startPos; i < chars.length; ++i) {
            if (!Character.isDigit(chars[i])) {
                return false;
            }
        }
        return true;
    }
}
