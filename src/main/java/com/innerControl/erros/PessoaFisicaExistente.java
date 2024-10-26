package com.innerControl.erros;

import java.util.function.Supplier;

public class PessoaFisicaExistente extends RuntimeException {

    public PessoaFisicaExistente(String message){
        super(message);
    }

    public PessoaFisicaExistente(String message, Throwable cause) {
        super(message, cause);
    }

}
