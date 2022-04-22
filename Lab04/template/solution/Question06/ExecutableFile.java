public class ExecutableFile extends File {

    File.FileType fileType = File.FileType.executable_file;

    public ExecutableFile(String name) {
        super(name);
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
