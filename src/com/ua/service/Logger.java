package com.ua.service;

import com.ua.util.ConsoleColors;

import java.time.Instant;

public class Logger {

    private static Logger logger;

    private Logger() {

    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }

        return logger;
    }

    public void info(String text) {
        System.out.println(ConsoleColors.GREEN + Instant.now() + ": " + text + ConsoleColors.RESET);
    }

    public void error(String text) {
        System.out.println(ConsoleColors.RED + Instant.now() + ": " + text + ConsoleColors.RESET);
    }
}
