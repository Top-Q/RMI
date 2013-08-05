package com.etymgiko.springrmiexample.server;

import java.io.Serializable;

public class HelloMessage implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
