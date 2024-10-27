package com.innerControl.erros;

public class CidadeNaoExistente extends RuntimeException {

    public CidadeNaoExistente(String message){
        super(message);
    }

    public CidadeNaoExistente(String message, Throwable cause) {
        super(message, cause);
    }

}
