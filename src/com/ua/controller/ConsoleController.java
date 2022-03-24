package com.ua.controller;

import com.ua.dao.DataDao;
import com.ua.dao.FileDataDao;
import com.ua.service.CaesarCtyptor;
import com.ua.service.Cryptor;
import com.ua.service.Logger;
import com.ua.util.ConsoleColors;

import java.time.Instant;
import java.util.Scanner;

public class ConsoleController {

    public static final int SYMBOLS_COUNT = 25;
    public static final String APPLICATION_NAME = "CRYPTOR";

    private DataDao dataDao = new FileDataDao();
    private Cryptor cryptor = new CaesarCtyptor();
    private Logger log = Logger.getInstance();

    public void callMainMenu() {
        printHeader();
        makeChoice();
    }

    private void makeChoice() {
        do {
            printMainChoiceMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (isExitCodeChoose(choice)) break;
            callChoice(choice);
        } while (true);
    }

    private void callChoice(int choice) {
        switch (choice) {
            case 1:
                encryptData();
                break;
            case 2:
                System.out.println("Called 2");
                break;
            default: printColoredText("Make correct choice:", ConsoleColors.RED);
        }
    }

    private void encryptData() {
        String path = getPathToFile();
        String originalText = dataDao.getData(path);
        String encryptedText = cryptor.encrypt(originalText);
        String fileName = Instant.now().toString() + "-encrypted";
        dataDao.writeData(fileName, encryptedText);
    }

    private String getPathToFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Path to file:");
        return scanner.nextLine();
    }

    private boolean isExitCodeChoose(int choice) {
        if (choice == 0) {
            printColoredText("Goodbye", ConsoleColors.BLUE);
            return true;
        }
        return false;
    }

    private void printMainChoiceMenu() {
        System.out.println();
        printColoredText("Make your choice:", ConsoleColors.GREEN);
        System.out.println("1: Encrypt file");
        System.out.println("2: Decrypt file");
        System.out.println();
        printColoredText("0: Exit", ConsoleColors.CYAN);
    }

    private void printHeader() {
        printStars();
        System.out.println(ConsoleColors.RED + "\t\t" + APPLICATION_NAME + ConsoleColors.RESET);
        printStars();
    }

    private void printStars() {
        for (int i = 0; i < SYMBOLS_COUNT; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    private void printColoredText(String text, String color) {
        System.out.println(color + text + ConsoleColors.RESET);
    }
}
