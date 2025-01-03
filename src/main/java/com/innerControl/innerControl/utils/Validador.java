package com.innerControl.innerControl.utils;

import java.util.InputMismatchException;

public class Validador {

    public static boolean validarCpf(String cpf){

        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // Calcular o primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }
            int primeiroDigito = 11 - (soma % 11);
            if (primeiroDigito >= 10) primeiroDigito = 0;

            // Calcular o segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }
            int segundoDigito = 11 - (soma % 11);
            if (segundoDigito >= 10) segundoDigito = 0;

            // Verificar se os dígitos calculados coincidem com os informados
            return primeiroDigito == Character.getNumericValue(cpf.charAt(9)) &&
                   segundoDigito == Character.getNumericValue(cpf.charAt(10));
        } catch (InputMismatchException e) {
            return false;
        }
    }

    public static boolean validarEmail(String email) {
        String emailRegex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    public static boolean validarTelefone(String telefone) {
        String somenteDigitos = telefone.replaceAll("\\D", "");

        if (somenteDigitos.length() != 11) {
            throw new IllegalArgumentException("O telefone deve possuir o formato (DD) 9 9999-9999!");
        }
        else return true;
    }

    public static boolean validarCEP(String cep){
        String somenteDigitos = cep.replaceAll("\\D", "");
        if (somenteDigitos.length() != 8) {
            throw new IllegalArgumentException("CEP Inválido!");
        }
        else return true;
    }
}
