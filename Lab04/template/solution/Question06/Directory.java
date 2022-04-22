import java.util.ArrayList;
import java.util.List;

public class Directory extends File {

    FileType fileType = FileType.directory;
    List<File> fileList = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    String addFile(File file) {
        try {
            if (!fileList.contains(file)) {
                file.setUpper(this);
                return "Add file succeed.";
            } else {
                return "File already existed.";
            }
        } catch (Exception e) {
            return "Add file failed.";
        }
    }

    String delFile(File file, Directory root) {
        if (fileList.isEmpty()) {
            if (file.getUpper() != root) {
                file.getUpper().size -= file.size;
                file.getUpper().fileList.remove(file);
            }
            deleted = true;
            return "Remove file succeed.";
        }
        return "Remove file failed.";
    }

    public String openFile() {
        if (deleted) {
            return "Directory deleted.";
        }
        return name;
    }

    @Override
    public String toString() {
        return "This is a " + fileType + " named " + name +
                ". It is create at " + dateTime +
                ". It is " + size +
                " bytes. The content inside is \"" + content +
                "\". And it is at " + path + ".";
    }
}
