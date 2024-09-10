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

    private final String expected = "{\n" +
            "  - follow: false\n" +
            "    host: hexlet.io\n" +
            "  - proxy: 123.234.53.22\n" +
            "  - timeout: 50\n" +
            "  + timeout: 20\n" +
            "  + verbose: true\n" +
            "}";

    @Test
    public void test1() throws Exception {
        String actual1 = Differ.generate(path1, path2);
        assertEquals(expected, actual1);
    }
    @Test
    public void test2() throws Exception {
        String actual2 = Differ.generate(path1, path2);
        assertEquals(expected, actual2);
    }
}
