package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name;
        String age;
        String email;
        String Phone;
        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            name = reader.readLine();
            age = reader.readLine();
            email = reader.readLine();
            Phone = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        name = name.substring(name.indexOf(':') + 1).trim();
        age = age.substring(age.indexOf(':') + 1).trim();
        email = email.substring(email.indexOf(':') + 1).trim();
        Phone = Phone.substring(Phone.indexOf(':') + 1).trim();

        return new Profile(name, Integer.parseInt(age), email, Long.parseLong(Phone));
    }
}
