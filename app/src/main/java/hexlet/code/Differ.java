package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import static hexlet.code.Parser.parser;

public class Differ {

    public static String generateDifferenceList(Map<String, String> map1, Map<String, String> map2) {
        TreeMap<String, Object> mixData = new TreeMap<>();
        mixData.putAll(map1);
        mixData.putAll(map2);

        StringBuilder result = new StringBuilder("{\n");
        for (String keyMap1 : map1.keySet()) {
            if ((map2.containsKey(keyMap1)) && (map2.get(keyMap1).equals(map1.get(keyMap1)))) {
                result.append("    ");
                result.append(keyMap1).append(": ");
                result.append(map2.get(keyMap1));
                result.append("\n");
                mixData.remove(keyMap1);
            } else if ((map2.containsKey(keyMap1))
                    && (!map2.get(keyMap1).equals(map1.get(keyMap1)))) {
                result.append("  ");
                result.append("- ");
                result.append(keyMap1).append(": ");
                result.append(map1.get(keyMap1));
                result.append("\n");
                mixData.remove(keyMap1);
                result.append("  ");
                result.append("+ ");
                result.append(keyMap1).append(": ");
                result.append(map2.get(keyMap1));
                result.append("\n");
                mixData.remove(keyMap1);
            } else if (!map2.containsKey(keyMap1)) {
                result.append("  ");
                result.append("- ");
                result.append(keyMap1).append(": ");
                result.append(map1.get(keyMap1));
                result.append("\n");
                mixData.remove(keyMap1);
            }
        }

        for (String keyMixData : mixData.keySet()) {
            result.append("  ");
            result.append("+ ");
            result.append(keyMixData).append(": ");
            result.append(map2.get(keyMixData));
            result.append("\n");
        }
        result.append("}");
        return result.toString();
    }

    public static String  generate(String filepath1, String filepath2) throws Exception {
        String readFile1Path = "./file1";
        String readFile2Path = "./file2";

        Path path1 = Paths.get(readFile1Path).toAbsolutePath().normalize();
        Path path2 = Paths.get(readFile2Path).toAbsolutePath().normalize();

        String fileType1 = getFType(filepath1);
        String fileType2 = getFType(filepath2);

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        Map<String, String> map1 = parser(content1, fileType1);
        Map<String, String> map2 = parser(content2, fileType2);

        return generateDifferenceList(map1, map2);
    }

    private static String getFType(String filepath) {
        return filepath.substring(filepath.indexOf(".") + 1);
    }
}
