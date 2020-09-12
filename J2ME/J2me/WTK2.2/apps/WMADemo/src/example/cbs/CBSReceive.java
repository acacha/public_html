/*
 * @(#)CBSReceive.java	1.8 04/08/31
 *
 * Copyright (c) 1999-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */

package example.cbs;

import javax.microedition.midlet.*;
import javax.microedition.io.*;
import javax.microedition.lcdui.*;
import javax.wireless.messaging.*;

import java.io.IOException;

/**
 * An example MIDlet displays text from a CBS MessageConnection
 */
public class CBSReceive extends MIDlet
    implements CommandListener, Runnable, MessageListener {

    /** user interface command for indicating Exit request. */
    Command exitCommand  = new Command("Exit", Command.EXIT, 2);
    /** user interface text box for the "waiting" message. */
    Alert waiting;
    /** current display. */
    Display display;
    /** instance of a thread for asynchronous networking and user interface. */
    Thread thread;
    /** Connections detected at start up. */
    String[] connections;
    /** Flag to signal end of processing. */
    boolean done;
    /** The Message Identifier of the CBS messages we're listening for */
    String cbsMessageID;
    /** CBS message connection for inbound text messages. */
    MessageConnection cbsconn;
    /** Current message read from the network. */
    Message msg;
    /** Alert displaying the contents of the received message */
    Alert receivedMessage;

    /**
     * Initialize the MIDlet with the current display object and
     * graphical components.
     */
    public CBSReceive() {
        cbsMessageID = getAppProperty("CBS-Message-Identifier");
        display = Display.getDisplay(this);
        waiting = new Alert("CBS Receive", null, null, AlertType.INFO);
        waiting.addCommand(exitCommand);
        waiting.setCommandListener(this);
	waiting.setTimeout(Alert.FOREVER);

        receivedMessage = new Alert("CBS Received", null, null, AlertType.INFO);
        receivedMessage.setTimeout(Alert.FOREVER);
        receivedMessage.addCommand(exitCommand);
        receivedMessage.setCommandListener(this);
    }

    /**
     * Start creates the thread to do the MessageConnection receive
     * text.
     * It should return immediately to keep the dispatcher
     * from hanging.
     */
    public void startApp() {
        /** CBS connection to be read. */
        String cbsConnection = "cbs://:" + cbsMessageID;
        /** Open the message connection. */
        if (cbsconn == null) {
            try {
                cbsconn = (MessageConnection) Connector.open(cbsConnection);
                cbsconn.setMessageListener(this);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        display.setCurrent(waiting);

        /** Initialize the text if we were started manually. */
        connections = PushRegistry.listConnections(true);
        if (connections == null || connections.length == 0) {
            waiting.setString("Waiting for CBS with Message ID " +
            cbsMessageID + "...");
        } else {
            done = false;
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * Notification that a message arrived.
     * @param conn the connection with messages available
     */
    public void notifyIncomingMessage(MessageConnection conn) {
        if (thread == null) {
            done = false;
            thread = new Thread(this);
            thread.start();
        }
    }

    /** Message reading thread. */
    public void run() {
        /** Check for cbs connection. */
        try {

            /**
             * Loop reading messages and updating the text
             * window.
             */
            while (!done) {
                msg = cbsconn.receive();
                if (msg != null) {
                    if (msg instanceof TextMessage) {
                        receivedMessage.setString(
                            ((TextMessage)msg).getPayloadText());
                    } else {
                        StringBuffer buf = new StringBuffer();
                        byte[] data = ((BinaryMessage)msg).getPayloadData();
                        for (int i = 0; i < data.length; i++) {
                            buf.append(Integer.toHexString((int) data[i]));
                            buf.append(' ');
                        }
                        receivedMessage.setString(buf.toString());
                    }
                    display.setCurrent(receivedMessage);
                }
            }
            cbsconn.close();
        } catch (IOException e) {
            // e.printStackTrace();
        }
    }

    /**
     * Pause signals the thread to stop by clearing the thread field.
     * If stopped before done with the iterations it will
     * be restarted from scratch later.
     */
    public void pauseApp() {
        done = true;
        thread = null;
    }

    /**
     * Destroy must cleanup everything.  The thread is signaled
     * to stop and no result is produced.
     * @param unconditional true if a forced shutdown was requested
     */
    public void destroyApp(boolean unconditional) {
        done = true;
        thread = null;
        if (cbsconn != null) {
            try {
                cbsconn.close();
            } catch (IOException e) {
                // Ignore any errors on shutdown
            }
        }
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
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
