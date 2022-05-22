import java.io.*;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws IOException {
        removeComments("input.txt", "output.txt");
    }

    public static void removeComments(String inputPath, String outPath) throws IOException {
        // 从inputPath中读取一行
        File file = new File(inputPath);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            boolean isInBlockComment = false;
            while ((line = reader.readLine()) != null) {
                if (isInBlockComment) {
                    // 如果当前处于block comment中，则查找结束符号
                    int index = line.indexOf("*/");
                    if (index != -1) {
                        // 如果找到结束符号，则将当前行的内容替换为去掉结束符号的内容
                        line = line.substring(index + 2);
                        isInBlockComment = false;
                    } else {
                        // 如果没有找到结束符号，则将当前行的内容替换为空
                        line = "";
                    }
                } else if (line.contains("/*")) {
                    isInBlockComment = true;
                    line = line.substring(0, line.indexOf("/*"));
                } else if (line.contains("//")) {
                    line = line.substring(0, line.indexOf("//"));
                }
                // 输出到文件(outPath, line);
                if (line.length() != 0) {
                    try (FileWriter fw = new FileWriter(outPath, true);) {
                        fw.write(line + "\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
