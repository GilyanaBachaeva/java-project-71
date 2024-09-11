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
            "    chars1: [a, b, c]\n" +
            "  - chars2: [d, e, f]\n" +
            "  + chars2: false\n" +
            "  - checked: false\n" +
            "  + checked: true\n" +
            "  - default: null\n" +
            "  + default: [value1, value2]\n" +
            "  - id: 45\n" +
            "  + id: null\n" +
            "  - key1: value1\n" +
            "  + key2: value2\n" +
            "    numbers1: [1, 2, 3, 4]\n" +
            "  - numbers2: [2, 3, 4, 5]\n" +
            "  + numbers2: [22, 33, 44, 55]\n" +
            "  - numbers3: [3, 4, 5]\n" +
            "  + numbers4: [4, 5, 6]\n" +
            "  + obj1: {nestedKey=value, isNested=true}\n" +
            "  - setting1: Some value\n" +
            "  + setting1: Another value\n" +
            "  - setting2: 200\n" +
            "  + setting2: 300\n" +
            "  - setting3: true\n" +
            "  + setting3: none\n" +
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
