package com.ids.patienthub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    Logger log = LoggerFactory.getLogger(this.getClass());
    void exp1() {
        log.info("Hello");
    }

    Main() {
        exp1();
    }
    public static void main(String[] args) {
        new Main();
    }
}
