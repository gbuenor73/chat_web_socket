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
    private String name;
    private String nick;

    public UsersEntity(String name, String nick) {
        this.name = name;
        this.nick = nick;
    }

    public UsersEntity() {
    }
}
