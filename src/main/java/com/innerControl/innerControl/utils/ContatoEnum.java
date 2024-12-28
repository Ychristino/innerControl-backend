package com.innerControl.innerControl.utils;

public enum ContatoEnum {
    EMAIL,
    TELEFONE;

    public static ContatoEnum fromString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        return ContatoEnum.valueOf(value.toUpperCase());
    }
}
