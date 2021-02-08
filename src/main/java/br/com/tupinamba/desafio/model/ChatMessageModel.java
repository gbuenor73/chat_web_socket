package br.com.tupinamba.desafio.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
@Setter
public class ChatMessageModel {

    private String content;
    private String sender;
    private String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    private MessageType type;

    public enum MessageType {
        CHAT, LEAVE, JOIN
    }

    public MessageType getType() {
        return type;
    }



}
