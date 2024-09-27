package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatStyle(List<Map<String, Object>> differences, String format) throws IOException {
        return switch (format) {
            case "stylish" -> Stylish.formatStylish(differences);
            case "plain" -> Plain.formatPlain(differences);
            case "json" -> Json.formatJson(differences);
            default -> throw new IOException("Unknown type of formatter");
        };
    }
}
