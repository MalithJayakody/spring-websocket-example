package com.leo.demo.springwebsocketexample.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
    @MessageMapping("/pushFeed")
    @SendTo("/dashboard-feed/latest")
    public String pushMessage(String message){
        LOGGER.info("Got a message from sensor. Message : {}",message);
        // Pushing date to defined channel.
        return message;
    }
}
