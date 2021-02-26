package br.com.tupinamba.desafio.services;

import br.com.tupinamba.desafio.entyties.MessageEntity;
import br.com.tupinamba.desafio.entyties.UsersEntity;
import br.com.tupinamba.desafio.model.ChatMessageModel;
import br.com.tupinamba.desafio.repository.impl.MessageRepositoryImpl;
import br.com.tupinamba.desafio.repository.impl.UserRepositoryImpl;
import br.com.tupinamba.desafio.utils.ProjectUtils;
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
