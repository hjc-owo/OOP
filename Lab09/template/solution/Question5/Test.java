import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Test {
    public static void main(String[] args) throws IOException {
        copyFile("input.txt", "output.txt");
    }

    public static void copyFile(String sourceFile, String targetFile) throws IOException {
        Files.copy(new File(sourceFile).toPath(), new File(targetFile).toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
