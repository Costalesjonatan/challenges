package org.app;

import lombok.extern.java.Log;

@Log
public class Main {
    public static void main(String[] args) {
        log.info("Hello world!");
        for (int i = 1; i <= 5; i++) {
            log.info("i = " + i);
        }
    }
}