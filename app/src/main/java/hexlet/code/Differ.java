package hexlet.code;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Differ {

    public static void generate(String filepath1, String filepath2) throws Exception {
        String readFile1Path = "C/users/gelch/Desktop/Tren/file1.json";
        String readFile2Path = "C/users/gelch/Desktop/Tren/file2.json"; //Получаем путь

        Path path1 = Paths.get(readFile1Path).toAbsolutePath().normalize();
        Path path2 = Paths.get(readFile2Path).toAbsolutePath().normalize(); //Формируем абсолютный путь

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2); //Читаем файл

        System.out.println(content1);
        System.out.println(content2);
    }
}
