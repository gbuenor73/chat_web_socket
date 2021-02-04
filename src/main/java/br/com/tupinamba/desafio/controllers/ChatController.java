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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ChatController {
//
//    @Autowired
//    private MajorService majorService;
//
//    @GetMapping("/getAllMessages")
//    public ResponseEntity<List<MessageEntity>> getAllMessages() {
//        return ResponseEntity.ok(this.majorService.getMessages());
//    }
//
//    @PostMapping("/newMessage")
//    public ResponseEntity<MessageEntity> insertNewMessage(@RequestBody MessageEntity usersEntity) {
//        return ResponseEntity.ok(this.majorService.insertNewMessage(usersEntity));
//    }
//
//    @GetMapping("/getAllUsers")
//    public ResponseEntity<List<UsersEntity>> getAllUsers() {
//        return ResponseEntity.ok(this.majorService.getUsers());
//    }
//
//    @PostMapping("/newUser")
//    public ResponseEntity<UsersEntity> getAllMessages(@RequestBody UsersEntity usersEntity) {
//        return ResponseEntity.ok(this.majorService.insertNewUser(usersEntity));
//    }

//    @MessageMapping("/chat/{to}")
//    public void sendMessage(@DestinationVariable String to, MessageModel message) {
//        System.out.println("handling send message: " + message + " to: " + to);
//        boolean isExist =
//    }

    @MessageMapping("chat.register")
    @SendTo("/topic/public")
    public ChatMessageModel register(@Payload ChatMessageModel chatMessageModel, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessageModel.getSender());
        return chatMessageModel;
    }

    @MessageMapping("chat.send")
    @SendTo("/topic/public")
    public ChatMessageModel sendMessage(@Payload ChatMessageModel chatMessageModel) {
        return chatMessageModel;
    }


}
