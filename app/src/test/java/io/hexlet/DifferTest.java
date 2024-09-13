package io.hexlet;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private final String path1 = "src/test/resource/file1.json";
    private final String path2 = "src/test/resource/file2.json";
    private final String path3 = "src/test/resource/file3.yml";
    private final String path4 = "src/test/resource/file4.yml";

    private final Path firstPrototype =
            Paths.get("src/test/resource/prototypes/firstResult").toAbsolutePath().normalize();
    private final Path secondPrototype =
            Paths.get("src/test/resource/prototypes/secondResult").toAbsolutePath().normalize();

    @Test
    public void test1() throws Exception {
        String expected1 = Files.readString(firstPrototype);
        String actual1 = Differ.generate(path1, path2);
        assertEquals(expected1, actual1);
    }
    @Test
    public void test2() throws Exception {
        String expected2 = Files.readString(firstPrototype);
        String actual2 = Differ.generate(path3, path4);
        assertEquals(expected2, actual2);
    }
    @Test
    public void test3() throws Exception {
        String expected1 = Files.readString(secondPrototype);
        String actual1 = Differ.generate(path1, path2, "plain");
        assertEquals(expected1, actual1);
    }
    @Test
    public void test4() throws Exception {
        String expected2 = Files.readString(secondPrototype);
        String actual2 = Differ.generate(path3, path4, "plain");
        assertEquals(expected2, actual2);
    }
}
