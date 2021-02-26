package br.com.gbuenor.chat.services;

import br.com.gbuenor.chat.entyties.UsersEntity;
import br.com.gbuenor.chat.entyties.MessageEntity;
import br.com.gbuenor.chat.model.ChatMessageModel;
import br.com.gbuenor.chat.repository.impl.MessageRepositoryImpl;
import br.com.gbuenor.chat.repository.impl.UserRepositoryImpl;
import br.com.gbuenor.chat.utils.ProjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    @Autowired
    private ProjectUtils utils;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private MessageRepositoryImpl messageRepository;

    public void message(ChatMessageModel chatMessageModel) {
        UsersEntity oneUser = this.userRepository.getOneUser(chatMessageModel.getSender());

        if (oneUser != null)
            this.messageRepository.insertNewMessage(new MessageEntity(oneUser.getId(), chatMessageModel.getContent()));

    }

    public void users(ChatMessageModel chatMessageModel) {
        UsersEntity oneUser = this.userRepository.getOneUser(chatMessageModel.getSender());

        if (oneUser == null)
            this.userRepository.insertNewUser(new UsersEntity(chatMessageModel.getSender()));

    }

    public List<MessageEntity> getMessages() {
        return this.messageRepository.getMessages();
    }

    public List<UsersEntity> getUsers() {
        return this.userRepository.getUsers();
    }

    public List<MessageEntity> getMessagesByUser(String user) {
        UsersEntity oneUser = this.userRepository.getOneUser(user);

        if (oneUser == null)
            throw this.utils.createException("Não foi encontrado  usuario informado.");

        return this.messageRepository.findByIdSend(oneUser.getId());
    }

    public UsersEntity getUser(Long id) {
        return this.userRepository.getUserbyId(id);
    }
}
