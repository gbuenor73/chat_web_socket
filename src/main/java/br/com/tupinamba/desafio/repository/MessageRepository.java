package br.com.tupinamba.desafio.repository;

import br.com.tupinamba.desafio.entyties.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    @Query(value = "select * from messages where id_send = :user", nativeQuery = true)
    List<MessageEntity> findByIdSend(@Param("user") Long idSend);

}
