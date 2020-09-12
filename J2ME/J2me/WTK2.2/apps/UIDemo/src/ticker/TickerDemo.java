/*
 * @(#)TickerDemo.java	1.7 04/04/25
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */


package ticker;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
/**
 * The Ticker Demo simply sets a rather long ticker to the screen.
 *
 * @version 2.0
 */

public class TickerDemo extends MIDlet {
    /**
     * This is the text displayed in the ticker.
     */
    private static final String TICKER_TEXT = "This is a ticker see it " +
                    "scroll along the way... On and on it goes without " +
                    "stoping even for a second!";
                    
    private boolean firstTime;
    
    private Form mainForm;

    public TickerDemo() {
        firstTime = true;
        mainForm = new Form("Ticker");
    }                    

    protected void startApp() {
        
        if (firstTime) {
            Ticker t = new Ticker(TICKER_TEXT);
            mainForm.setTicker(t);
            firstTime = false;
        }
        Display.getDisplay(this).setCurrent(mainForm);        
    }
    
    protected void destroyApp(boolean unconditional) {        
    }
    
    protected void pauseApp() {
    }    
}
