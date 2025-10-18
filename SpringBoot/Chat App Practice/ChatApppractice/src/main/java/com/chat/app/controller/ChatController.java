package com.chat.app.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.chat.app.dto.ChatMessage;

@Controller
public class ChatController {
	
	@MessageMapping("/app/chat.sendMessage")
	@SendTo("/topic")
	public ChatMessage sendMessage(
		@Payload ChatMessage chatMessage	) {
		return chatMessage;
	}

}
