package com.innerControl.erros;

public class EstadoPaisInconsistente extends RuntimeException {

    public EstadoPaisInconsistente(String message){
        super(message);
    }

    public EstadoPaisInconsistente(String message, Throwable cause) {
        super(message, cause);
    }

}
