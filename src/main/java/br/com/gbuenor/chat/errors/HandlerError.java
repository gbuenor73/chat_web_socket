package br.com.gbuenor.chat.errors;

import br.com.gbuenor.chat.exceptions.CustomException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerError extends ResponseEntityExceptionHandler {

//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    private class JsonResponse {
//        String message;
//        int httpStatus;
//
//    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<CustomException> handleRuntimeException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<CustomException>(
//                new JsonResponse(ex.getMessage(), 400),
                new CustomException(500L, ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST);
    }

}