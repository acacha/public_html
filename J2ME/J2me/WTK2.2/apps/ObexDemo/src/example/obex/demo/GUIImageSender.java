/*
 * @(#)GUIImageSender.java	1.4 04/01/30
 *
 * Copyright (c) 2004 Sun Microsystems, Inc. All rights reserved.
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */
package example.obex.demo;
import java.util.Vector;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.List;


/**
 * @version 1.4
 */
final class GUIImageSender implements CommandListener {

    /** Shows if debug prints should be done. */
    private static final boolean DEBUG = false;

    /** DEBUG only: keeps the class name for debug. */
    private static final String cn = "GUIImageSender";

    /** Keeps a reference to a parent MIDlet. */
    private ObexDemoMIDlet parent;

    /** Soft button for stopping download and returning to the mane screen. */
    private Command stopCommand = new Command("Stop", Command.BACK, 1);

    /** Soft button for returning to the mane screen of demo. */
    private Command backCommand = new Command("Back", Command.STOP, 1);

    /** Soft button for launching an image sending. */
    private Command sendCommand = new Command("Send", Command.ITEM, 1);

    /** Container of images file names */
    private Vector imageNames = null;

    /** List of images titles to select a sending image */
    private List imageList = null;

    /** Form to show current state of seding a pictire */
    private Form senderForm = new Form("Send Image");

    /** Gauge to indicate progress of downloading process */
    private Gauge sendingItem = new Gauge("", false, 256, 0);

    /** Reference to Obex sender part */
    private ObexImageSender obexSender = null;

    /** Constructor initialize image list and sender form */
    GUIImageSender(ObexDemoMIDlet parent) {
        this.parent = parent;
        obexSender = new ObexImageSender(this);
        setupImageList();
        imageList.addCommand(sendCommand);
        imageList.addCommand(backCommand);
        imageList.setCommandListener(this);
        senderForm.append(sendingItem);
        senderForm.addCommand(stopCommand);
        senderForm.setCommandListener(this);
        showImageList();
    }

    /**
     * Responds to commands issued on "client or server" form.
     *
     * @param c command object source of action
     * @param d screen object containing actioned item
     */
    public void commandAction(Command c, Displayable d) {
        if (c == backCommand) {
            parent.show();
        } else if (c == stopCommand) {
            obexSender.stop();
            showImageList();
        } else if (c == sendCommand) {
            sendImage();
        } else if (c == List.SELECT_COMMAND) {
            sendImage();
        } else if (c == Alert.DISMISS_COMMAND) {
            showImageList();
        }
    }

    /**
     * Shows progress of image uploading
     */
    void showProgress(String label, int maxValue) {
        sendingItem.setLabel(label);
        sendingItem.setValue(0);
        sendingItem.setMaxValue(maxValue);
        Display.getDisplay(parent).setCurrent(senderForm);
    }

    /**
     * Update progress of image uploading
     */
    void updateProgress(int value) {
        sendingItem.setValue(value);
    }

    /**
     * Shows list with image names to select one  for sending to receiver
     */
    void showImageList() {
        Display.getDisplay(parent).setCurrent(imageList);
    }

    /**
     * Shows allert with error message
     */
    void errorMessage() {
        Alert alert = new Alert("Error", "Can't read the image", null, null);
        alert.setTimeout(5000);
        alert.setCommandListener(this);
        Display.getDisplay(parent).setCurrent(alert, imageList);
    }

    /**
     * Shows allert with "not ready" message
     */
    void notReadyMessage() {
        Alert alert = new Alert("Warning",
                "Receiver isn't ready" + " to download image", null, null);
        alert.setTimeout(5000);
        alert.setCommandListener(this);
        Display.getDisplay(parent).setCurrent(alert, imageList);
    }

    /**
     * Shows allert with "stop" message
     */
    void stopMessage() {
        Alert alert = new Alert("Warning",
                "Receiver terminated" + " image loading", null, null);
        alert.setTimeout(5000);
        alert.setCommandListener(this);
        Display.getDisplay(parent).setCurrent(alert, imageList);
    }

    /** Stops Uploading process */
    void stop() {
        obexSender.stop();
    }

    /** Starts sending process */
    private void sendImage() {
        int imageIndex = imageList.getSelectedIndex();
        String imageName = (String) imageNames.elementAt(imageIndex);
        obexSender.setImageName(imageName);
        (new Thread(obexSender)).start();
    }

    /**
     * Check the attributes in the descriptor that identify
     * images and titles and initialize the lists of imageNames
     * and imageList.
     * <P>
     * The attributes are named "ImageTitle-n" and "ImageImage-n".
     * The value "n" must start at "1" and increment by 1.
     */
    private void setupImageList() {
        imageNames = new Vector();
        imageList = new List("Select Image to send", List.IMPLICIT);
        imageList.addCommand(backCommand);
        imageList.setCommandListener(this);

        for (int n = 1; n < 100; n++) {
            String nthImage = "ImageName-" + n;
            String image = parent.getAppProperty(nthImage);

            if (image == null || image.length() == 0) {
                break;
            }
            String nthTitle = "ImageTitle-" + n;
            String title = parent.getAppProperty(nthTitle);

            if (title == null || title.length() == 0) {
                title = image;
            }
            imageNames.addElement(image);
            imageList.append(title, null);
        }
    }
}
