package br.com.tupinamba.desafio.entyties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@ToString
@Getter
@Setter
public class UsersEntity extends RepresentationModel<UsersEntity> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nick;

    public UsersEntity(String nick) {
        this.nick = nick;
    }

    public UsersEntity() {
    }
}
