/*
 * @(#)RequestResponse.java	1.3 04/01/27
 *
 * Copyright (c) 2004 Sun Microsystems, Inc. All rights reserved. 
 * PROPRIETARY/CONFIDENTIAL
 * Use is subject to license terms
 */// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JSR-172 Reference Implementation wscompile 1.0, using: JAX-RPC Standard Implementation (1.1, build EA-R39)

package example.serverscript.connector;


public class RequestResponse {
    protected java.lang.String result;
    
    public RequestResponse() {
    }
    
    public RequestResponse(java.lang.String result) {
        this.result = result;
    }
    
    public java.lang.String getResult() {
        return result;
    }
    
    public void setResult(java.lang.String result) {
        this.result = result;
    }
}
