package com.shadowvzs;

import java.io.*;

public class Files {
    public static void main() {
        final String fileName = "something.txt";
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println(file.getPath());
            System.out.println(file.isFile());
            System.out.println(file.getAbsolutePath());
        } else {
            try {
                FileWriter writer = new FileWriter(fileName);
                writer.write("Something in first line\nNew line which is the second \nNext new line");
                writer.append("\nlast line");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileReader(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            // read character byte by byte
            int data = reader.read();
            while (data != -1) {
                System.out.print((char)data);
                data = reader.read();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
