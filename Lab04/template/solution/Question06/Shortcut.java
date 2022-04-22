public class Shortcut extends File {

    FileType fileType = FileType.shortcut;
    File pointAt;

    public Shortcut(String name) {
        super(name);
    }

    public File getPointAt() {
        return pointAt;
    }

    public void setPointAt(File pointAt) {
        this.pointAt = pointAt;
    }

    public String openFile() {
        if (deleted) {
            return "File deleted.";
        }
        if (this.pointAt.deleted) {
            return "Raw file deleted.";
        }
        return pointAt.openFile();
    }

    @Override
    public String toString() {
        return "This is a " + fileType + " named " + name +
                ". It is create at " + dateTime +
                ". It is " + size +
                " bytes. The content inside is \"" + content +
                "\". It points at:" + pointAt.name +
                ". And it is at " + path + ".";
    }
}
