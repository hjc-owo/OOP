import java.util.Date;
import java.util.regex.Pattern;

public abstract class File {
    String name;
    Date dateTime = new Date();
    int size = 0;
    String content = "Nothing!";
    String path = "C:/";
    Directory upper = null;
    boolean deleted = false;

    public File(String name) {
        this.name = name;
    }

    public Directory getUpper() {
        return upper;
    }

    public void setUpper(Directory upper) {
        upper.size += size;
        upper.fileList.add(this);
        setPath(upper.getName());
        this.upper = upper;
    }

    public String openFile() {
        return content;
    }

    public String delFile() {
        deleted = true;
        return "File deleted.";
    }

    enum FileType {
        directory, shortcut, executable_file, not_executable_file
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Pattern.matches("^[ -~]+$", name)) {
            this.name = name;
        } else {
            System.out.println("Invalid name.");
        }
    }

    public Date getDateTime() {
        return dateTime;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public abstract String toString();

}
