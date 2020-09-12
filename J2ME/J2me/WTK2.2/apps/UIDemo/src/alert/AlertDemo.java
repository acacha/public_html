/*
 * %W% %E%
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */
package alert;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;


/**
 * The alert demo displays a list of alerts that will be displayes once the
 * user clicks a list item. These alerts try to present the full range of
 * alert types supported in MIDP.
 *
 * @version 2.0
 */
public class AlertDemo
    extends MIDlet {

    private final static Command CMD_EXIT = new Command("Exit", Command.EXIT, 
                                                        1);
    private final static Command CMD_SHOW = new Command("Show", Command.SCREEN, 
                                                        1);
    private final static String[] typeStrings = {
            "Alarm", "Confirmation", "Error", "Info", "Warning"
        };
    private final static String[] timeoutStrings = {
            "2 Seconds", "4 Seconds", "8 Seconds", "Forever"
        };
    private final static int SECOND = 1000;
    private Display display;
    
    private boolean firstTime;
    
    private Form mainForm;
    
    public AlertDemo() {
        firstTime = true;
        mainForm = new Form("Alert Options");
    }
    
    protected void startApp() {
        display = Display.getDisplay(this);
        showOption();
    }

    /**
     * Creates the main display of the MIDlet.
     * In this form the user will choose the properties of the alert
     */
    private void showOption() {
        if (firstTime) {                
            // choice-group for the type of the alert:
            // "Alarm", "Confirmation", "Error", "Info" or  "Warning"
            ChoiceGroup types = new ChoiceGroup("Type", ChoiceGroup.POPUP,
                                                typeStrings, null);
            mainForm.append(types);
            
            // choice-group for the timeout of the alert:
            // "2 Seconds", "4 Seconds", "8 Seconds" or "Forever"
            ChoiceGroup timeouts = new ChoiceGroup("Timeout", ChoiceGroup.POPUP,
                                                   timeoutStrings, null);
            mainForm.append(timeouts);
    
            // a check-box to add an indicator to the alert
            String[] optionStrings = { "Show Indicator" };
            ChoiceGroup options = new ChoiceGroup("Options", Choice.MULTIPLE, 
                                                  optionStrings, null);
            mainForm.append(options);
            mainForm.addCommand(CMD_SHOW);
            mainForm.addCommand(CMD_EXIT);
            mainForm.setCommandListener(
	            new AlertListener(types, timeouts, options));
            firstTime = false;
        }
        display.setCurrent(mainForm);
    }

    private class AlertListener
        implements CommandListener {

        AlertType[] alertTypes = {
            AlertType.ALARM, AlertType.CONFIRMATION, AlertType.ERROR, 
            AlertType.INFO, AlertType.WARNING
        };
        ChoiceGroup typesCG;
        int[] timeouts = { 2 * SECOND, 4 * SECOND, 8 * SECOND, Alert.FOREVER };
        ChoiceGroup timeoutsCG;
        ChoiceGroup indicatorCG;

        public AlertListener(ChoiceGroup types, ChoiceGroup timeouts, 
                            ChoiceGroup indicator) {
            typesCG = types;
            timeoutsCG = timeouts;
            indicatorCG = indicator;
        }

        public void commandAction(Command c, Displayable d) {

            if (c == CMD_SHOW) {

                int typeIndex = typesCG.getSelectedIndex();
                Alert alert = new Alert("Alert");
                alert.setType(alertTypes[typeIndex]);

                int timeoutIndex = timeoutsCG.getSelectedIndex();
                alert.setTimeout(timeouts[timeoutIndex]);
                alert.setString(
                        typeStrings[typeIndex] + " Alert, Running " +
			timeoutStrings[timeoutIndex]);

                boolean[] SelectedFlags = new boolean[1];
                indicatorCG.getSelectedFlags(SelectedFlags);

                if (SelectedFlags[0]) {

                    Gauge indicator = createIndicator(timeouts[timeoutIndex]);
                    alert.setIndicator(indicator);
                }

                display.setCurrent(alert);
            } else if (c == CMD_EXIT) {
                destroyApp(false);
                notifyDestroyed();
            }
        }
    }

    protected void destroyApp(boolean unconditional) {
    }

    protected void pauseApp() {
    }

    /**
     * Creates the alert's indicator.
     * If there is no timeout (maxValue == Alert.FOREVER), the indicator will be
     * an "indefinite-running" gauge.
     * If there is a timeout, the indicator will be a "non-interactive" gauge
     * that is updated by a background thread.
     */
    private Gauge createIndicator(int maxValue) {

        if (maxValue == Alert.FOREVER) {

            return new Gauge(null, false, Gauge.INDEFINITE, 
                             Gauge.CONTINUOUS_RUNNING);
        }

        final int max = maxValue / SECOND;
        final Gauge indicator = new Gauge(null, false, max, 0);

//        if (maxValue != Gauge.INDEFINITE) {
            
            new Thread() {
                public void run() {

                    int value = 0;

                    while (value < max) {
                        indicator.setValue(value);
                        ++value;

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ie) {
                            // ignore
                        }
                    }
                }
            }.start();
//        }

        return indicator;
    }
}
