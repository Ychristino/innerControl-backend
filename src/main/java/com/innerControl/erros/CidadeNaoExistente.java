package com.innerControl.erros;

public class EstadoNaoExistente extends RuntimeException {

    public EstadoNaoExistente(String message){
        super(message);
    }

    public EstadoNaoExistente(String message, Throwable cause) {
        super(message, cause);
    }

}
