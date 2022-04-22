public class NotExecutableFile extends File{
    FileType fileType = FileType.not_executable_file;
    File openWay;

    public NotExecutableFile(String name) {
        super(name);
    }

    public String openFile(){
        return "Cannot open without proper tools.";
    }

    public String openFile(File openWay) {
        return content;
    }

    @Override
    public String toString() {
        if (deleted) {
            return "File deleted.";
        }
        return "This is a " + fileType + " named " + name +
                ". It is create at " + dateTime +
                ". It is " + size +
                " bytes. The content inside is \"" + content +
                "\". And it is at " + path + ".";
    }
}
