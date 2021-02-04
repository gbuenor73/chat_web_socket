package br.com.tupinamba.desafio.services;

import br.com.tupinamba.desafio.entyties.MessageEntity;
import br.com.tupinamba.desafio.entyties.UsersEntity;
import br.com.tupinamba.desafio.repository.MessageRepository;
import br.com.tupinamba.desafio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class MajorService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    public List<MessageEntity> getMessages() {
        return this.messageRepository.findAll();
    }

    public MessageEntity insertNewMessage(MessageEntity messageEntity) {
        messageEntity.setDateMessage(LocalDateTime.now(ZoneId.systemDefault()));
        return this.messageRepository.save(messageEntity);
    }

    public List<UsersEntity> getUsers() {
        return this.userRepository.findAll();
    }

    public UsersEntity insertNewUser(UsersEntity usersEntity) {
        return this.userRepository.save(usersEntity);
    }

    public UsersEntity getOneUser(String nick){
        return this.userRepository.findByNick(nick);
    }
}
