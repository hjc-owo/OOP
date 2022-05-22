import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        addLineNo("input.txt", "output.txt");
    }

    public static void addLineNo(String inputPath, String outPath) throws IOException {
        // 从inputPath中读取一行
        File file = new File(inputPath);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            int lineNo = 1;
            while ((line = reader.readLine()) != null) {
                // 输出到文件(outPath, line);
                try (FileWriter fw = new FileWriter(outPath, true);) {
                    fw.write(lineNo++ + ": " + line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
