/*
 * %W% %E%
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */
package gauge;

import javax.microedition.lcdui.*;


/**
 * This class implements a non-interactive gague control
 * that moves automatically with indifinite range.
 *
 * @version 2.0
 */
public class IncrementalIndefiniteGaugeRunnable extends Gauge
                                                implements Runnable {
    private boolean done = false;
    
    /**
     * The constructor initializes the gauge.
     */
    public IncrementalIndefiniteGaugeRunnable(String label) {        
        super(label, false, Gauge.INDEFINITE, Gauge.INCREMENTAL_IDLE);
        new Thread(this).start();
    }

    /**
     * This method moves the gauge left and right.
     */
    public void run() {

        while (!done) {
            setValue(Gauge.INCREMENTAL_UPDATING);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException err) {
            }
        }
    }
    
    void setDone() {
        done = true;
    }
}
