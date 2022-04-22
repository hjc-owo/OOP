public class Muphone {
    public static void main(String[] args) {
        Music a = new Music("Lily","mp3");
        Music.printf(a);

        Phone b = new Phone("iPhone","13 pro Max");
        Phone.printf(b);
    }
}

class Music {
    String name;
    String type;

    public Music(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public static void printf(Music a){
        System.out.println("The music is: " + a.name + ", and the type is: " + a.type);
    }

}

class Phone {
    String name;
    String type;

    public Phone(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public static void printf(Phone a){
        System.out.println("The phone is: " + a.name + ", and the type is: " + a.type);
    }

}