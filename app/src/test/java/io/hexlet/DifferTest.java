package io.hexlet;

import hexlet.code.Differ;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {
    private static String jsonFilePath1;
    private static String jsonFilePath2;

    public static String read(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        return Files.readString(path);
    }

    @BeforeAll
    public static void initialSetup() throws Exception {
        jsonFilePath1 = "src/test/resources/testJson1.json";
        jsonFilePath2 = "src/test/resources/testJson2.json";
    }

    @Test
    public void defaultFormatterTest() throws Exception {
        String resultJson = Differ.generate(jsonFilePath1, jsonFilePath2);
        Assertions.assertEquals(resultJson, "");
    }
}
