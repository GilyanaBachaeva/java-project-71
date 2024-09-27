package hexlet.code;

import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference."
)

final class App implements Callable<Integer> {

    @CommandLine.Parameters(
            index = "0",
            paramLabel = "filepath1",
            description = "path to first file"
    )
    private String filepath1;

    @CommandLine.Parameters(
            index = "1",
            paramLabel = "filepath2 ",
            description = "path to second file"
    )
    private String filepath2;

    @CommandLine.Option(
            names = {"-f", "--format"},
            paramLabel = "format",
            description = "output format [default: stylish]"
    )
    private String format = "stylish";

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(filepath1, filepath2, format));
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
