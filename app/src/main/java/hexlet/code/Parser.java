package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Parser {
    public static <K, V> Map<K, V> sortByKeys(Map<K, V> unsortedMap) {
        return new TreeMap<>(unsortedMap);
    }

    public static Map<String, String> parser(String data, String fileType) throws Exception {
        Map<String, String> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        return sortByKeys(mapper.readValue(data, new TypeReference<>() {
        }));
    }
}
