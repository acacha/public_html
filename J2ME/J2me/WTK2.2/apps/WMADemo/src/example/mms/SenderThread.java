/*
 * @(#)SenderThread.java	1.4 04/04/19
 *
 * Copyright (c) 1999-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */
package example.mms;

import java.io.IOException;

import javax.microedition.io.*;

import javax.wireless.messaging.*;


public class SenderThread extends Thread {
    private MMSMessage message;
    private String appID;

    public SenderThread(MMSMessage message, String appID) {
        this.message = message;
        this.appID = appID;
    }

    /**
     * Send the message. Called on a separate thread so we don't have
     * contention for the display
     */
    public void run() {
        String address = message.getDestination() + ":" + appID;

        MessageConnection mmsconn = null;

        try {
            /** Open the message connection. */
            mmsconn = (MessageConnection) Connector.open(address);

            MultipartMessage mmmessage =
		(MultipartMessage) mmsconn.newMessage(
	            MessageConnection.MULTIPART_MESSAGE);
            mmmessage.setAddress(address);

            MessagePart[] parts = message.getParts();

            for (int i = 0; i < parts.length; i++) {
                mmmessage.addMessagePart(parts[i]);
            }

            mmmessage.setSubject(message.getSubject());
            mmsconn.send(mmmessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (mmsconn != null) {
            try {
                mmsconn.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
