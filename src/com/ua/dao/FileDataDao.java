package com.ua.dao;

import com.ua.service.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDataDao implements DataDao {

    private Logger log = Logger.getInstance();

    @Override
    public String getData(String dataName) {
        byte[] dataBytes = new byte[0];
        try {
            dataBytes = Files.readAllBytes(Path.of(dataName));
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return new String(dataBytes);
    }

    @Override
    public void writeData(String dataName, String data) {
        try {
            Files.write(Path.of(dataName + ".txt"), data.getBytes());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
