package br.com.tupinamba.desafio.entyties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@ToString
@Getter
@Setter
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idSend;
    private Long idReceiver;
    private LocalDateTime dateMessage;
    private String message;


    public MessageEntity(Long idSend, Long idReceiver, String message) {
        this.idSend = idSend;
        this.idReceiver = idReceiver;
        this.message = message;
    }
}
