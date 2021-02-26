package br.com.tupinamba.desafio.entyties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class MessageEntity extends RepresentationModel<MessageEntity> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idSend;
    private LocalDateTime dateMessage;
    private String message;


    public MessageEntity(Long idSend, String message) {
        this.idSend = idSend;
        this.message = message;
    }
}
