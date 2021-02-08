package br.com.tupinamba.desafio.repository.impl;

import br.com.tupinamba.desafio.entyties.UsersEntity;
import br.com.tupinamba.desafio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public class UserRepositoryImpl {

    @Autowired
    private UserRepository userRepository;

    public List<UsersEntity> getUsers() {
        try {
            return this.userRepository.findAll();
        } catch (Exception e){
            throw new RuntimeException("Teste");
        }
    }

    public UsersEntity insertNewUser(UsersEntity usersEntity) {
        return this.userRepository.save(usersEntity);
    }

    public UsersEntity getOneUser(String nick) {
        return this.userRepository.findByNick(nick);
    }
}
