package com.vecoder.game;

public class Message implements IMessage {
	
	private String message;
	
	public Message() {
	}

	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
