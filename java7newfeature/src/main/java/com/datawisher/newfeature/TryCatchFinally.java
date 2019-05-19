package com.datawisher.newfeature;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TryCatchFinally {

    // 读取文件并打印内容
    private static void printFile() throws IOException {
        InputStream input = null;

        try {
            input = new FileInputStream("file.txt");

            int data = input.read();
            while (data != -1) {
                System.out.print((char) data);
                data = input.read();
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    // Java7的try-with-resource
    private static void printFileJava7() throws IOException {

        // FileInputStream实现了AutoCloseable接口
        try (FileInputStream input = new FileInputStream("file.txt")) {

            int data = input.read();
            while (data != -1) {
                System.out.println((char) data);
                data = input.read();
            }
        }
    }
}