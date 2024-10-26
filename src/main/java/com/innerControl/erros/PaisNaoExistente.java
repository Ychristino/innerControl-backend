package com.innerControl.erros;

public class PaisNaoExistente extends RuntimeException {

    public PaisNaoExistente(String message){
        super(message);
    }

    public PaisNaoExistente(String message, Throwable cause) {
        super(message, cause);
    }

}
