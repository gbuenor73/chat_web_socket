package br.com.tupinamba.desafio.repository;

import br.com.tupinamba.desafio.entyties.MessageEntity;
import br.com.tupinamba.desafio.entyties.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

}
