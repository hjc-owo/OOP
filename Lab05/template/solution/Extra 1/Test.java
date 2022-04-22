public class Test {
    public static void main(String[] args) {
        Splitter splitter = new Splitter();
        UpperCaseProcessor upperCaseProcessor = new UpperCaseProcessor();
        SnakeCaseProcessor snakeCaseProcessor = new SnakeCaseProcessor();

        String s = "Hello World";
        System.out.println(splitter.process(s));
        System.out.println(upperCaseProcessor.process(s));
        System.out.println(snakeCaseProcessor.process(s));
    }
}
