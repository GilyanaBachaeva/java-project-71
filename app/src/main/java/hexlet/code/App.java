package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;


@Command(name = "gendiff",
         description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    @CommandLine.Parameters(
            index = "0",
            paramLabel = "filepath1",
            description = "path to first file"
    )
    private String filePath1;
    @CommandLine.Parameters(
            index = "1",
            paramLabel = "filepath2",
            description = "path to second file"
    )
    private String filePath2;

    @Option(
            names = {"-h", "--help"},
            usageHelp = true,
            description = "Show this help message and exit."
    )
    boolean usageHelpRequested;

    @Option(
            names = {"-V", "--version"},
            versionHelp = true,
            description = "Print version information and exit."
    )
    boolean versionInfoRequested;

    @Option(
            names = {"-f", "--format"},
            paramLabel = "format",
            description = "output format [default: stylish]"
    )

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }


    @Override
    public Integer call() throws Exception {
        String filepath1 = "";
        String filepath2 = "";
        Differ.generate(filepath1, filepath2);
        return 0;
    }
}
