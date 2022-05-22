import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Test {
    public static void main(String[] args) throws IOException {
        copyDirectory("input", "output");
    }

    public static void copyDirectory(String sourceDir, String targetDir) throws IOException {
        File source = new File(sourceDir);
        File target = new File(targetDir);

        if (source.isDirectory()) {
            if (!target.exists()) {
                target.mkdir();
            }
            String[] file = source.list();
            for (String s : file) {
                copyDirectory(sourceDir + "/" + s, targetDir + "/" + s);
            }
        } else {
            Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
