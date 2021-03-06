/*
 * @(#)MMSMessage.java	1.4 04/04/19
 *
 * Copyright (c) 1999-2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */

package example.mms;

import java.util.Vector;
import javax.wireless.messaging.*;

public class MMSMessage {
    
    private String destination;
    private Vector parts = new Vector();
    private String subject;
        
    /**
     * Check the phone number for validity
     * Valid phone numbers contain only the digits 0 thru 9, and may contain 
     * a leading '+'.
     */
    private static boolean isValidPhoneNumber(String address) {
        String protocol = "mms://";
        if (!address.startsWith(protocol)) {
            return false;
        }
        String number = address.substring(protocol.length());
        char[] chars = number.toCharArray();
        if (chars.length == 0) {
            return false;
        }
        int startPos = 0;
        // initial '+' is OK
        if (chars[0] == '+') {
            startPos = 1;
        }
        for (int i = startPos; i < chars.length; ++i) {
            if (!Character.isDigit(chars[i])) {
                return false;
            }
        }
        return true;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public void setDestination(String destination) {
        if (!isValidPhoneNumber(destination)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.destination = destination;
    }
    
    public MessagePart[] getParts() {
        MessagePart[] partsArray = new MessagePart[parts.size()];
        parts.copyInto(partsArray);
        return partsArray;
    }
    
    public void addPart(MessagePart part) {
        parts.addElement(part);
    }
}
