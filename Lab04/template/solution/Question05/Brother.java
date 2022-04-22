public class Brother extends Person{

    public Brother(String name) {
        super(name);
    }

    @Override
    String say() {
        return "Brother";
    }

    @Override
    public String toString() {
        return name;
    }
}
