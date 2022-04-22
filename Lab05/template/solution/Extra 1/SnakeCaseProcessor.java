public class SnakeCaseProcessor implements ITextProcess {

    @Override
    public String process(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                result.append("_");
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
