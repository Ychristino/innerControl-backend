package com.innerControl.erros;

public class ProdutoNaoExistente extends RuntimeException {

    public ProdutoNaoExistente(String message){
        super(message);
    }

    public ProdutoNaoExistente(String message, Throwable cause) {
        super(message, cause);
    }

}
