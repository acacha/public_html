/*
 * @(#)VideoTest.java	1.5 04/04/21
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved.
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */

package example.mmademo;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.Vector;


/**
 * An example MIDlet to demo MMAPI video features
 *
 * @version 1.5
 */
public class VideoTest extends MIDlet implements CommandListener, Runnable {

    private static VideoCanvas videoCanvas    = null;
    private static VideoPlayer videoPlayer    = null;
    private static Vector  videoClips;

    private Command               exitCommand = new Command("Exit",
                                                    Command.EXIT, 1);
    private Command               playCommand = new Command("Play",
                                                    Command.ITEM, 1);
    //private Command               helpCommand = new Command("Help", Command.HELP, 1);

    //private Alert                 helpScreen  = null;
    private Display               display;
    private static List           theList;
    private static VideoTest      instance = null;

    private static Vector urls;

    static public VideoTest getInstance() {
        return instance;
    }

    static public List getList() {
        return theList;
    }

    public VideoTest() {

        instance = this;
        display  = Display.getDisplay(this);
        theList  = new List("MMAPI Video Player", Choice.IMPLICIT);
        fillList();

        theList.addCommand(playCommand);
        theList.addCommand(exitCommand);
        theList.setCommandListener(this);
        display.setCurrent(theList);
    }

    private void fillList() {
        videoClips = new Vector();
        urls = new Vector();
        for (int n = 1; n < 100; n++) {
            String nthURL = "VideoTest-URL"+ n;
            String url = getAppProperty(nthURL);
            if (url == null || url.length() == 0) {
                break;
            }
	    if (!SimplePlayer.isSupported(url))
		continue;
            String nthTitle = "VideoTest-" + n;
            String title = getAppProperty(nthTitle);
            if (title == null || title.length() == 0) {
                title = url;
            }
            videoClips.addElement(title);
            urls.addElement(url);
            theList.append(title, null);
        }
    }


    /**
     * Called when this MIDlet is started for the first time,
     * or when it returns from paused mode.
     * If there is currently a Form or Canvas displaying
     * video, call its startApp() method.
     */
    public void startApp() {
	if (videoPlayer != null)
	    videoPlayer.startApp();
	if (videoCanvas != null)
	    videoCanvas.startApp();
    }


    /**
     * Called when this MIDlet is paused.
     * If there is currently a Form or Canvas displaying
     * video, call its startApp() method.
     */
    public void pauseApp() {
	if (videoPlayer != null)
	    videoPlayer.pauseApp();
	if (videoCanvas != null)
	    videoCanvas.pauseApp();
    }


    /**
     * Destroy must cleanup everything not handled
     * by the garbage collector.
     */
    public synchronized void destroyApp(boolean unconditional) {
        if (videoPlayer != null)
            videoPlayer.close();
        if (videoCanvas != null)
            videoCanvas.close();
        nullPlayer();
    }

    public synchronized void nullPlayer() {
        videoPlayer = null;
        videoCanvas = null;
    }

    int index = 0;

    public void run() {
        if (index % 2 == 0) {
            videoPlayer = new VideoPlayer(display);
            videoPlayer.open((String) urls.elementAt(index));
            if (videoPlayer != null) {
                display.setCurrent(videoPlayer);
                videoPlayer.start();
            }
        } else {
            videoCanvas = new VideoCanvas(display);
            videoCanvas.open((String) urls.elementAt(index));
            if(videoCanvas != null) {
                display.setCurrent(videoCanvas);
                videoCanvas.start();
            }
        }
    }

    /*
     * Respond to commands, including exit
     * On the exit command, cleanup and notify that the MIDlet has
     * been destroyed.
     */
    public void commandAction(Command c, Displayable s) {

        if (c == exitCommand) {
            synchronized (this) {
                if (videoPlayer != null || videoCanvas != null) {
                     new Thread(new Runnable() {
                        public void run() {
                            if (videoPlayer != null) {
                                videoPlayer.stopVideoPlayer();
                                videoPlayer = null;
                            } else { //videoCanvas != null
                                videoCanvas.stopVideoCanvas();
                                videoCanvas = null;
                            }
                            destroyApp(false);
                            notifyDestroyed();
                        }
                    }).start();
                } else {
                    destroyApp(false);
                    notifyDestroyed();
                }
            }
        } else if ((s == theList && c == List.SELECT_COMMAND) || c == playCommand) {
            synchronized (this) {
                if (videoPlayer != null || videoCanvas != null) {
                    return;
                }
                int i = theList.getSelectedIndex();
                index = i;
                // need to start the players in a separate thread to
                // not block the command listener thread during
                // Player.realize: if it requires a security
                // dialog (like "is it OK to use airtime?"),
                // it would block the VM
                (new Thread(this)).start();
            }
        }
    }

}

