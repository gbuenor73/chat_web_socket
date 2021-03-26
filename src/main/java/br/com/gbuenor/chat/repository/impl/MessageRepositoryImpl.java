package br.com.gbuenor.chat.repository.impl;

import br.com.gbuenor.chat.entyties.MessageEntity;
import br.com.gbuenor.chat.utils.ProjectUtils;
import br.com.gbuenor.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.logging.Logger;

public class MessageRepositoryImpl {

    @Autowired
    private MessageRepository messageRepository;

    Logger logger = Logger.getLogger("br.com.gbuenor.chat.repository.impl.MessageRepositoryImpl");

    @Autowired
    private ProjectUtils utils;

    public List<MessageEntity> getMessages() {
        try {
            return this.messageRepository.findAll();
        } catch (Exception e) {
            throw this.utils.createException("Não foi possivel obter as mensagens da base de dados");
        }
    }

    public MessageEntity insertNewMessage(MessageEntity messageEntity) {
        messageEntity.setDateMessage(LocalDateTime.now(ZoneId.systemDefault()));
        try {
            return this.messageRepository.save(messageEntity);
        } catch (Exception e) {
            this.logger.info("Não foi possivel inserir mensagem na base de dados");
        }
        return messageEntity;
    }

    public List<MessageEntity> findByIdSend(Long id) {
        return this.messageRepository.findByIdSend(id);
    }
}
