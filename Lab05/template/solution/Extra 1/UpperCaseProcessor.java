public class UpperCaseProcessor implements ITextProcess{

    @Override
    public String process(String s) {
        return s.toUpperCase();
    }
}
