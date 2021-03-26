package br.com.gbuenor.chat.repository.impl;

import br.com.gbuenor.chat.entyties.UsersEntity;
import br.com.gbuenor.chat.utils.ProjectUtils;
import br.com.gbuenor.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Logger;

public class UserRepositoryImpl {

    Logger logger = Logger.getLogger("br.com.gbuenor.chat.repository.impl.UserRepositoryImpl");

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectUtils utils;

    public List<UsersEntity> getUsers() {
        try {
            return this.userRepository.findAll();
        } catch (Exception e) {
            throw this.utils.createException("Não foi possivel obter os usuarios da base de dados");
        }
    }

    public UsersEntity insertNewUser(UsersEntity usersEntity) {
        try {
            return this.userRepository.save(usersEntity);
        } catch (Exception e) {
            this.logger.info("Não foi possivel inserir usuario na base de dados");
        }
        return usersEntity;
    }

    public UsersEntity getOneUser(String nick) {
        try {
            return this.userRepository.findByNick(nick);
        } catch (Exception e) {
            this.logger.info("Não foi possivel obter usuario da base de dados");
        }
        return null;
    }

    public UsersEntity getUserbyId(Long id) {
        try {
            return this.userRepository.findById(id).orElseThrow(Exception::new);
        } catch (Exception e) {
            this.logger.info("Usuario não encontrado.");
        }
        return null;
    }
}
