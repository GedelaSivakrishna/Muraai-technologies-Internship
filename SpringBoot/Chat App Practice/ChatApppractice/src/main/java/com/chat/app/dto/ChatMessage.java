package com.chat.app.dto;

public class ChatMessage {
	String content;
	String sender;
	String type;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ChatMessage(String content, String sender, String type) {
		super();
		this.content = content;
		this.sender = sender;
		this.type = type;
	}
	public ChatMessage() {
		super();
	}
	
	
	
}
