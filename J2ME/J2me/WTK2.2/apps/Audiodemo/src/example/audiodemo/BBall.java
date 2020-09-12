/*
 * @(#)BBall.java	1.7 04/03/11
 *
 * Copyright (c) 1999-2004 Sun Microsystems, Inc. All rights reserved.
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */

package example.audiodemo;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/*
 * this is a sample program to show ring tones synchronized with
 * selected background music.
 * It is based on the manyballs midlet. When a ball hits a wall,
 * a ring tone is heard.
 *
 * Usuage: Use right arrow key to add one more ball (5 is the maxium).
 *         Use left arrow key to delete one ball
 *         Use up   arrow key to increase the speed of ball
 *         Use down arrow key to reduce the speed of ball
 *
 * @version 1.7
 */

public class BBall extends MIDlet implements CommandListener, Runnable {

    private static final String[] bgs = {"no background",
                                         "wave background",
                                         "tone seq background",
                                         "MIDI background"};
    static String wavbgUrl;
    static String midbgUrl;
    private Command exitCommand = new Command("Exit",
					      Command.EXIT, 1);
    private Command playCommand = new Command("Play",
					      Command.ITEM, 1);
    private Display display;
    private int idx = 0;
    private List theList;

    private static final Object   gameLock = new Object();
    private BallCanvas            game;

    // if this MIDlet's startApp method is started
    // for the first time
    private boolean firstTime = true;

    // pause/resume support
    private boolean restartOnResume = false;

    public BBall() {
	display  = Display.getDisplay(this);
	theList  = new List("Bouncing Ball", Choice.IMPLICIT);
	for (int i = 0; i < bgs.length; i++) {
	    theList.append(bgs[i], null);
	}
	wavbgUrl = getAppProperty("BBall-wav-URL");
	midbgUrl = getAppProperty("BBall-MIDI-URL");
	theList.addCommand(playCommand);
	theList.addCommand(exitCommand);
	theList.setCommandListener(this);
    }

    // also called from BallCanvas
    public void displayList() {
	display.setCurrent(theList);
    }


    /**
     * Called when this MIDlet is started for the first time,
     * or when the MIDlet returns from paused mode.
     *
     * If it is the first time, display the menu list.
     *
     * Otherwise, wake up the thread. If music was playing
     * when the MIDlet was paused, call the game's
     * start method.
     */
    public void startApp() {
	if (firstTime) {
	    displayList();
	    firstTime = false;
	} else {
	    SmallBall.paused = false;
	    if (game != null && restartOnResume) {
		game.start();
	    }
	    restartOnResume = false;
	}
    }


    /**
     * Called when this MIDlet is paused.
     * Pause the thread.
     * If the game is not already paused, call its pause method.
     * For consistency across different VM's,
     * it's a good idea to stop the player if
     * it's currently playing.
     */
    public void pauseApp() {
	SmallBall.paused = true;
	restartOnResume = (game != null && !game.isPaused());
	if (restartOnResume) {
	    game.pause();
	}
    }


    /**
     * Destroy must cleanup everything not handled
     * by the garbage collector.
     */
    public void destroyApp(boolean unconditional) {
	synchronized(gameLock) {
	    if (game != null)
		game.destroy();
	}
    }


    /*
     * Respond to commands, including exit
     * On the exit command, cleanup and notify that the MIDlet has
     * been destroyed.
     */
    public void commandAction(Command c, Displayable s) {

	if (c == exitCommand) {
	    synchronized(gameLock) {
		if (game != null) {
		    game.destroy();
		    game = null;
		}
	    }
	    destroyApp(false);
	    notifyDestroyed();
	} else if ((s == theList && c == List.SELECT_COMMAND) || c == playCommand) {
	    idx = theList.getSelectedIndex();
	    new Thread(this).start();
	}
    }


    public void run() {
	synchronized(gameLock) {
	    if (game == null) {
		game = new BallCanvas(this);
	    }
	    display.setCurrent(game);
	    game.init(8, idx);
	    if (game.needAlert()) {
		Alert alert = new Alert("Warning", "Cannot create player", null, null);
		alert.setTimeout(1000);
		display.setCurrent(alert, game);
	    }
	    game.start();
	}
    }

}