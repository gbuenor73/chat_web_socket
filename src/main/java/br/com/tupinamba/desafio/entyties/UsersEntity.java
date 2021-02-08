package br.com.tupinamba.desafio.entyties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@ToString
@Getter
@Setter
public class UsersEntity {

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
