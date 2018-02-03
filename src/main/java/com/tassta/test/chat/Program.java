package com.tassta.test.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Тоня on 03.02.2018.
 */
public class Program {
    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String text = reader.readLine();
            if (text.equals(":q"))
                break;
            System.out.println("You typed: " + text);
        }
    }
}
