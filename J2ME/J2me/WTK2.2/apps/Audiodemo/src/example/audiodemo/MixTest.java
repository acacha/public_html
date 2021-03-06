/*
 * @(#)MixTest.java	1.8 04/03/11
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved.
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */

package example.audiodemo;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.*;

public class MixTest extends MIDlet implements CommandListener, Runnable {

    private static final String[]  mcases = {"Tone+Wav", "Tone+ToneSeq", "ToneSeq+Wav"};
    static String wavUrl;
    private static MixCanvas      soundObj    = null;
    private Command               exitCommand = new Command("Exit",
							    Command.EXIT, 1);
    private Command               playCommand = new Command("Play",
							    Command.ITEM, 1);
    private Display               display;
    private static List           theList;
    private static MixTest        instance = null;

    // if this MIDlet's startApp method is started
    // for the first time
    private boolean firstTime = true;

    // pause/resume support
    private boolean restartOnResume = false;

    static public MixTest getInstance() {
	return instance;
    }

    static public List getList() {
	return theList;
    }

    public MixTest() {
	instance = this;
	display  = Display.getDisplay(this);
	theList  = new List("Lists", Choice.IMPLICIT);
	for (int i = 0; i < mcases.length; i++) {
	    theList.append(mcases[i], null);
	}
	wavUrl = getAppProperty("MixTestURL");
	theList.addCommand(playCommand);
	theList.addCommand(exitCommand);
	theList.setCommandListener(this);
	soundObj = new MixCanvas(display);
    }


    /**
     * Called when this MIDlet is started for the first time,
     * or when the MIDlet returns from paused mode.
     *
     * If it is the first time, display the menu list.
     *
     * Otherwise, if music was playing when the MIDlet
     * was paused, call the demo's playSound method.
     */
    public void startApp() {
	if (firstTime) {
	    display.setCurrent(theList);
	    firstTime = false;
	} else {
	    if (soundObj != null && restartOnResume) {
		soundObj.playSound();
	    }
	    restartOnResume = false;
	}
    }


    /**
     * Called when this MIDlet is paused.
     * Pause the thread.
     * If the demo is playing, call its pause method.
     * For consistency across different VM's,
     * it's a good idea to stop the player if
     * it's currently playing.
     */
    public void pauseApp() {
	restartOnResume = (soundObj != null && soundObj.isPlaying());
	if (restartOnResume) {
	    soundObj.pauseSound();
	}
    }


    /**
     * Destroy must cleanup everything not handled
     * by the garbage collector.
     */
    public void destroyApp(boolean unconditional) {
	if ( soundObj != null ) {
	    soundObj.stopSound();
	}
	soundObj = null;
    }


    public void commandAction(Command c, Displayable s) {
	if (c == exitCommand) {
	    destroyApp(false);
	    notifyDestroyed();
	} else if ((s == theList && c == List.SELECT_COMMAND) || c == playCommand) {
	    int i = theList.getSelectedIndex();
	    soundObj.setIndex(i);
	    display.setCurrent(soundObj);
	    soundObj.serviceRepaints();
	    // method playSound() should not be invoked on GUI thread. Manager.createPlayer()
	    // will potentially invoke a blocking I/O. This is not good
	    // practice recommended by MIDP programming style. So here we
	    // will create the Player in a separate thread.
	    new Thread(this).start();
	}
    }

    public void run () {
	if (soundObj != null) {
	    soundObj.playSound();
	}
    }
}

