package br.com.gbuenor.chat.repository;

import br.com.gbuenor.chat.entyties.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {

    UsersEntity findByNick(String nick);

}
