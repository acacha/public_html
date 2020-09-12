/*
 * @(#)WormException.java	1.4 04/01/27
 *
 * Copyright (c) 2000-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */

/*
 * WormException.java
 *
 * Created on March 30, 2001, 16:15
 * @version 1.4
 */

package example.wormgame;

/**
 * A WormException occurs whenever the worm dies. It's a quick way
 * to get to the main update loop to restart the game.
 */
public class WormException extends Exception {
    public WormException(String message) {
    super(message);
    }
}
