/*
 * @(#)About.java	1.18 03/12/11
 *
 * Copyright (c) 2000-2003 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */

package example;

import javax.microedition.lcdui.*;

/**
 * Typical about box with a string and an image.
 * In this case the Sun copyright and logo.
 */

public class About {

    /** Copyright notice */
    private static String copyright =
        "Copyright © 2003 Sun Microsystems, Inc.  All rights reserved.\n"
      + "Unpublished - rights reserved under the Copyright Laws of the United "
      + "States.Sun Microsystems, Inc. has intellectual property rights " 
      + "relating to technology embodied in the product that is described in " 
      + "this document. In particular, and without limitation, these "
      + "intellectual property rights may include one or more of the U.S. "
      + "patents listed at http://www.sun.com/patents and one or more "
      + "additional patents or pending patent applications in the U.S. and in "
      + "other countries.SUN PROPRIETARY/CONFIDENTIAL. U.S. Government Rights "
      + "- Commercial software.  Government users are subject to the Sun "
      + "Microsystems, Inc. standard license agreement and applicable "
      + "provisions of the FAR and its supplements.  Use is subject to license "
      + "terms.  This distribution may include materials developed by third "
      + "parties.Sun, Sun Microsystems, the Sun logo, Java and Jini are "
      + "trademarks or registered trademarks of Sun Microsystems, Inc. in the "
      + "U.S. and other countries.\n";


    /** the previous screen to go back to */
    private Displayable previous;

    /**
     * Do not allow anyone to create this class
     */
    private About() {};

    /**
     * Put up the About box and when the user click ok return
     * to the previous screen.
     * @param display The <code>Display</code> to return to when the
     *                 about screen is dismissed.
     */
    public static void showAbout(Display display) {

	Alert alert = new Alert("About MIDP");
	alert.setTimeout(Alert.FOREVER);

	if (display.numColors() > 2) {
	    String icon = (display.isColor()) ?
		"/icons/JavaPowered-8.png" : "/icons/JavaPowered-2.png";

	    try {
	        Image image = Image.createImage(icon);
		alert.setImage(image);
	    } catch (java.io.IOException x) {
		// just don't append the image.
	    }
	}
	// Add the copyright
	alert.setString(copyright);

	display.setCurrent(alert);
    }

}
