package com.devin.web.controller;

import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author simpl
 * @date 2020-02-28 16:44
 */
class PageControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPage() throws IOException {
        final Runtime runtime = Runtime.getRuntime();
        Process process = null;
        String[] cmds = {"D:\\APP\\python\\python.exe","E:\\theatre\\src\\test\\java\\com\\devin\\web\\controller\\test.py"};
        try {
            process = new ProcessBuilder(cmds).start();
            BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String l;
            l = stdout.readLine();//读取一行
            System.out.println(l);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}