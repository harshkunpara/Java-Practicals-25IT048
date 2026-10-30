import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
public class LogAnalyzer {
    public static void main(String[] args) throws IOException {
        Path folder = Paths.get("logs");
        Files.createDirectories(folder);
        Files.write(folder.resolve("app1.txt"), List.of(
                "INFO Application started",
                "ERROR Database connection failed",
                "INFO User logged in"
        ));
        Files.write(folder.resolve("app2.txt"), List.of(
                "WARNING Low memory",
                "ERROR File not found",
                "INFO Application stopped"
        ));
        String keyword = "ERROR";
        int totalLines = 0;
        int matchingLines = 0;
        try (DirectoryStream<Path> stream =
                     Files.newDirectoryStream(folder, "*.txt")) {
            for (Path file : stream) {
                int fileLines = 0;
                int fileMatches = 0;
                for (String line : Files.readAllLines(file)) {
                    fileLines++;
                    if (line.contains(keyword)) {
                        fileMatches++;
                    }
                }
                totalLines += fileLines;
                matchingLines += fileMatches;
                BasicFileAttributes attributes =
                        Files.readAttributes(
                                file, BasicFileAttributes.class);
                System.out.println("File: " + file.getFileName());
                System.out.println("Size: "
                        + attributes.size() + " bytes");
                System.out.println("Lines: " + fileLines);
                System.out.println("Keyword matches: " + fileMatches);
                System.out.println();
            }
        }
        System.out.println("Total lines: " + totalLines);
        System.out.println("Total ERROR lines: " + matchingLines);
    }}
