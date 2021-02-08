package br.com.tupinamba.desafio.exceptions;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomException {

    private Long httpStatus;
    private String message;
}
