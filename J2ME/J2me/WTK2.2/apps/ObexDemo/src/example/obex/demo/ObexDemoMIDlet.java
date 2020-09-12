/*
 * @(#)ObexDemoMIDlet.java	1.7 04/01/30
 *
 * Copyright (c) 2004 Sun Microsystems, Inc. All rights reserved.
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */
package example.obex.demo;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.MIDlet;


/**
 * @version 1.7
 */
public final class ObexDemoMIDlet extends MIDlet implements CommandListener {

    /** Soft button for exiting the demo. */
    private Command exitCommand = new Command("Exit", Command.EXIT, 1);

    /** Soft button for launching a sender or receiver of images . */
    private Command startCommand = new Command("Start", Command.ITEM, 1);

    /** A list of menu items */
    private static final String[] elements = { "Send Image", "Receive Image" };

    /** A menu list instance */
    private final List menuList = new List("OBEX Demo", List.IMPLICIT, elements,
            null);

    /** A GUI part of OBEX client which send image to server */
    private GUIImageSender imageSender = null;

    /** A GUI part of OBEX server which receive image from client */
    private GUIImageReceiver imageReceiver = null;

    /** Shows that demo was paused */
    private boolean isPaused;

    public ObexDemoMIDlet() {
        menuList.setCommandListener(this);
        menuList.addCommand(exitCommand);
        menuList.addCommand(startCommand);
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void startApp() {
        isPaused = false;
        show();
    }

    public void pauseApp() {
        isPaused = true;
    }

    public void destroyApp(boolean unconditional) {
        if (imageReceiver != null) {
            imageReceiver.stop();
        }

        if (imageSender != null) {
            imageSender.stop();
        }
    }

    public void commandAction(Command c, Displayable s) {
        if (c == exitCommand) {
            destroyApp(true);
            notifyDestroyed();
        } else if ((c == startCommand) || (c == List.SELECT_COMMAND)) {
            switch (menuList.getSelectedIndex()) {
            case 0:
                imageSender = new GUIImageSender(this);
                break;
            case 1:
                imageReceiver = new GUIImageReceiver(this);
                break;
            default:
                System.err.println("Unexpected choice...");
                break;
            }
        }
    }

    /**
     * Shows main menu of MIDlet on the screen.
     */
    void show() {
        Display.getDisplay(this).setCurrent(menuList);
    }
}
