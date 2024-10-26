package com.innerControl.erros;

public class ContatoExistente extends RuntimeException {

    public ContatoExistente(String message){
        super(message);
    }

    public ContatoExistente(String message, Throwable cause) {
        super(message, cause);
    }

}
