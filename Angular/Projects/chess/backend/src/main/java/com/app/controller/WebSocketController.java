package com.app.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
	
	@MessageMapping("/move")
	@SendTo("/topic/moves")
	public String processMove(String move) {
		System.out.println("Received move: " + move);
		return "Server echo: " + move;
	}

}
