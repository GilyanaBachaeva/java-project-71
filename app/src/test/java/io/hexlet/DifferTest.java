package io.hexlet;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    String filePath1 = "src/test/resources/file1.json";
    String filePath2 = "src/test/resources/file2.json";

    @Test
    public void testCall() throws Exception {
        String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        String actual = Differ.generate(filePath1, filePath2);
        assertEquals(expected, actual);
    }
}
