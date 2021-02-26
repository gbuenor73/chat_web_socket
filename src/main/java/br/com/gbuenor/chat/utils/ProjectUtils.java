package br.com.gbuenor.chat.utils;

import org.springframework.stereotype.Component;

@Component
public class ProjectUtils {

    public RuntimeException createException(String msg) {
        return new RuntimeException(msg);
    }
}
