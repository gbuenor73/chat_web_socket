package br.com.tupinamba.desafio.repository.impl;

import br.com.tupinamba.desafio.entyties.MessageEntity;
import br.com.tupinamba.desafio.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class MessageRepositoryImpl {

    @Autowired
    private MessageRepository messageRepository;

    public List<MessageEntity> getMessages() {
        return this.messageRepository.findAll();
    }

    public MessageEntity insertNewMessage(MessageEntity messageEntity) {
        messageEntity.setDateMessage(LocalDateTime.now(ZoneId.systemDefault()));
        return this.messageRepository.save(messageEntity);
    }

}
