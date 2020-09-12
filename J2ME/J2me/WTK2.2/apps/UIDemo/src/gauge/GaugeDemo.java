/*
 * %W% %E%
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */
package gauge;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;


/**
 * This MIDlet demonstrates the different types of gauges supported by MIDP-2.0:
 *      Interactive - 
 *      Non Interactive - 
 *      Interactive - 
 *      Indefinite Incremental
 *
 * @version 2.0
 */
public class GaugeDemo extends MIDlet implements CommandListener {
    private final static Command CMD_EXIT = new Command("Exit", 
                                                        Command.EXIT, 1);
    private Display display;
    private NonInteractiveGaugeRunnable nonInteractive;
    private IncrementalIndefiniteGaugeRunnable indefinite;
    
    private Form mainForm;
    
    public GaugeDemo() {
        display = Display.getDisplay(this);

        mainForm = new Form("Gauge Demo");
        //
        mainForm.append(new Gauge("Interactive", true, 10, 0));
        //
        nonInteractive = new NonInteractiveGaugeRunnable(
                                 "Non Interactive", 10, 0);
        new Thread(nonInteractive).start();
        mainForm.append(nonInteractive);
        //
        mainForm.append(
                new Gauge("Indefinite - Running", false, 
                          Gauge.INDEFINITE, Gauge.CONTINUOUS_RUNNING));

        indefinite = new IncrementalIndefiniteGaugeRunnable(
                             "Indefinite - Incremental");
        new Thread(indefinite).start();
        mainForm.append(indefinite);
        mainForm.addCommand(CMD_EXIT);
        mainForm.setCommandListener(this);
        
    }

    /**
     * Signals the MIDlet to start and enter the Active state.
     */
    protected void startApp() {
        
        display.setCurrent(mainForm);
    }

    /**
     * Signals the MIDlet to terminate and enter the Destroyed state.
     */
    protected void destroyApp(boolean unconditional) {
        nonInteractive.setDone();

        indefinite.setDone();
    }

    /**
     * Signals the MIDlet to stop and enter the Paused state.
     */
    protected void pauseApp() {
    }

    public void commandAction(Command c, Displayable d) {
        destroyApp(false);
        notifyDestroyed();
    }
}

