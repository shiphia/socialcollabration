package com.test.rest;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SNAPBackEnd.models.Outputmessage;
import com.niit.SNAPBackEnd.models.Message;


@RestController
public class Chatcontroller
{
	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public Outputmessage sendMessage(Message message)
	{
		
		return new Outputmessage(message,new Date());
	}
}