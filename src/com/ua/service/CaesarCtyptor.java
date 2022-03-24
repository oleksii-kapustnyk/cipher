package com.ua.service;

public class CaesarCtyptor implements Cryptor {

    @Override
    public String encrypt(String data) {
        return "encrypted text";
    }

    @Override
    public String decrypt(String data) {
        return "decrypted text";
    }
}
