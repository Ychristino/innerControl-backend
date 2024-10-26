package com.innerControl.erros;

public class InsercaoDadoErro extends RuntimeException{
    public InsercaoDadoErro(String message){
        super(message);
    }

    public InsercaoDadoErro(String message, Throwable cause) {
        super(message, cause);
    }
}
