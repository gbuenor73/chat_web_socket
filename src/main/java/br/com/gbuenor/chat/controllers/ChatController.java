package br.com.gbuenor.chat.controllers;

import br.com.gbuenor.chat.entyties.MessageEntity;
import br.com.gbuenor.chat.entyties.UsersEntity;
import br.com.gbuenor.chat.model.ChatMessageModel;
import br.com.gbuenor.chat.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller
@RequestMapping("/more")
public class ChatController {

    @Autowired
    private MainService majorService;

    @GetMapping("/getAllMessages")
    public ResponseEntity<List<MessageEntity>> getAllMessagesFromChat() {
        List<MessageEntity> messages = this.majorService.getMessages();
        messages.stream().forEach(m -> m.add(linkTo(methodOn(ChatController.class).getUser(m.getIdSend())).withSelfRel()));
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UsersEntity>> getAllUsers() {
        List<UsersEntity> users = this.majorService.getUsers();
        users.stream().forEach(u -> u.add(linkTo(methodOn(ChatController.class).getUser(u.getId())).withSelfRel()));
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UsersEntity> getUser(@PathVariable("id") Long id) {
        UsersEntity user = this.majorService.getUser(id);
        user.add(linkTo(methodOn(ChatController.class).getMessagesByEntity(user.getNick())).withSelfRel());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getMessages/{user}")
    public ResponseEntity<List<MessageEntity>> getMessagesByEntity(@PathVariable String user) {
        List<MessageEntity> messagesByUser = this.majorService.getMessagesByUser(user);
        messagesByUser.stream().forEach(m -> m.add(linkTo(methodOn(ChatController.class).getAllMessagesFromChat()).withSelfRel()));
        return ResponseEntity.ok(messagesByUser);
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
