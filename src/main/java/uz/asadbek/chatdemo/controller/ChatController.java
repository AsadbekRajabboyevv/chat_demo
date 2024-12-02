package uz.asadbek.chatdemo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import uz.asadbek.chatdemo.model.Message;

import java.security.Principal;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public Message send(Message message, Principal principal) {
        message.setSender(principal.getName());
        message.setTime(System.currentTimeMillis());
        return message;
    }

}
