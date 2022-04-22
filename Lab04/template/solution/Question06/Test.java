public class Test {
    public static void main(String[] args) {
        String workDirectory = "C:/";
        Directory root = new Directory("C:/");
        System.out.println(getWorkDirectory(workDirectory)); // init

        Directory directory = new Directory("Lab04");
        directory.setUpper(root);
        System.out.println(directory); // test directory

        workDirectory = directory.openFile();
        System.out.println(getWorkDirectory(workDirectory)); // open directory

        Shortcut shortcutOfLab04 = new Shortcut("shortcut_of_Lab04");
        shortcutOfLab04.setSize(111);
        shortcutOfLab04.setPointAt(directory);
        System.out.println(shortcutOfLab04); // test shortcut

        ExecutableFile executableFile = new ExecutableFile("Question06");
        executableFile.setContent("difficult!");
        executableFile.setSize(233);
        System.out.println(directory.addFile(executableFile)); // add executable file to directory
        System.out.println(executableFile);
        System.out.println(directory);

        Shortcut shortcutOfQuestion06 = new Shortcut("shortcut_of_Question06");
        shortcutOfQuestion06.setPointAt(executableFile);
        System.out.println(executableFile.delFile());
        System.out.println(shortcutOfQuestion06.openFile());

    }

    public static String getWorkDirectory(String workDirectory) {
        return "You are working at " + workDirectory + ".";
    }
}
