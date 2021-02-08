package br.com.tupinamba.desafio.controllers;

import br.com.tupinamba.desafio.entyties.MessageEntity;
import br.com.tupinamba.desafio.entyties.UsersEntity;
import br.com.tupinamba.desafio.model.ChatMessageModel;
import br.com.tupinamba.desafio.services.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private MajorService majorService;

    @GetMapping("/getAllMessages")
    public ResponseEntity<List<MessageEntity>> getAllMessagesFromChat() {
        return ResponseEntity.ok(this.majorService.getMessages());
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UsersEntity>> getAllUsers() {
        return ResponseEntity.ok(this.majorService.getUsers());
    }

    @MessageMapping("chat.register")
    @SendTo("/topic/public")
    public ChatMessageModel register(@Payload ChatMessageModel chatMessageModel, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessageModel.getSender());

        this.majorService.users(chatMessageModel);
        return chatMessageModel;
    }

    @MessageMapping("chat.send")
    @SendTo("/topic/public")
    public ChatMessageModel sendMessage(@Payload ChatMessageModel chatMessageModel) {

        this.majorService.message(chatMessageModel);
        return chatMessageModel;
    }


}
