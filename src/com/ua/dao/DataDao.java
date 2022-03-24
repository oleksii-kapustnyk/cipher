package com.ua.dao;

public interface DataDao {

    String getData(String dataName);

    void writeData(String dataName, String data);
}
