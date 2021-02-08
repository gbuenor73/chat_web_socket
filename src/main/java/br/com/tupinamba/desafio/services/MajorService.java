package br.com.tupinamba.desafio.services;

import br.com.tupinamba.desafio.entyties.MessageEntity;
import br.com.tupinamba.desafio.entyties.UsersEntity;
import br.com.tupinamba.desafio.model.ChatMessageModel;
import br.com.tupinamba.desafio.repository.impl.MessageRepositoryImpl;
import br.com.tupinamba.desafio.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private MessageRepositoryImpl messageRepository;

    public void message(ChatMessageModel chatMessageModel) {
        try {

            UsersEntity oneUser = this.userRepository.getOneUser(chatMessageModel.getSender());

            MessageEntity messageEntity =
                    new MessageEntity(oneUser.getId(), chatMessageModel.getContent());

            this.messageRepository.insertNewMessage(messageEntity);

        } catch (Exception e) {
            System.out.println("deu errado");
        }
    }

    public void users(ChatMessageModel chatMessageModel) {
        try {
            UsersEntity oneUser = this.userRepository.getOneUser(chatMessageModel.getSender());

            if (oneUser == null)
                this.userRepository.insertNewUser(new UsersEntity(chatMessageModel.getSender()));

        } catch (Exception e) {
            System.out.println("deu errado");
        }
    }

    public List<MessageEntity> getMessages() {
        return this.messageRepository.getMessages();
    }

    public List<UsersEntity> getUsers() {
        return this.userRepository.getUsers();
    }
}
