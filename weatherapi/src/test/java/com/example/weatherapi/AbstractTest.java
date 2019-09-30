package com.example.weatherapi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Optional;

public abstract class AbstractTest {

    public String readFileFromFixtures(String fileName) throws IOException {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            URL fileResource = classLoader.getResource("fixtures/" + fileName);
            if (Optional.ofNullable(fileResource).isPresent()) {
                File file = new File(fileResource.getFile());
                byte[] fileBytes = Files.readAllBytes(file.toPath());
                return new String(fileBytes);
            }

            return null;
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException(ex.getMessage());
        }
    }
}
