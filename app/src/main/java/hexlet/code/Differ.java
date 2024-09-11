package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static hexlet.code.Formatter.Stylish.formatStylish;
import static hexlet.code.Parser.parser;

public class Differ {

    public static List<Map<String, Object>> generateDifferenceList(Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String, Object>> result = new ArrayList<>();
        Set<String> keysSet = new TreeSet<>(map1.keySet());
        keysSet.addAll(map2.keySet());
        for (String key :  keysSet) {
            Map<String, Object> map = new LinkedHashMap<>();
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                map.put("key", key);
                map.put("oldValue", map1.get(key));
                map.put("status", "removed");
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                map.put("key", key);
                map.put("newValue", map2.get(key));
                map.put("status", "added");
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                map.put("key", key);
                map.put("oldValue", map1.get(key));
                map.put("newValue", map2.get(key));
                map.put("status", "updated");
            } else {
                map.put("key", key);
                map.put("oldValue", map1.get(key));
                map.put("status", "unchanged");
            }
            result.add(map);
        }
        return result;
    }

    public static String  generate(String filepath1, String filepath2, String format) throws Exception {
        String readFile1Path = filepath1;
        String readFile2Path = filepath2;

        Path path1 = Paths.get(readFile1Path).toAbsolutePath().normalize();
        Path path2 = Paths.get(readFile2Path).toAbsolutePath().normalize();

        String fileType1 = getFType(filepath1);
        String fileType2 = getFType(filepath2);

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        Map<String, Object> map1 = parser(content1, fileType1);
        Map<String, Object> map2 = parser(content2, fileType2);

        List<Map<String, Object>> result = generateDifferenceList(map1, map2);

        return formatStylish(result);
    }

    public static String generate(String pathfile1, String pathfile2) throws Exception {
        return generate(pathfile1, pathfile2, "stylish");
    }

    private static String getFType(String filepath) {
        return filepath.substring(filepath.indexOf(".") + 1);
    }
}
