public class Sister extends Person {

    public Sister(String name) {
        super(name);
    }

    @Override
    String say() {
        return "不像我，我只会心疼giegie~";
    }

    @Override
    public String toString() {
        return name;
    }
}
