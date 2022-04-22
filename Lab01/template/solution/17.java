public class Dinner {
    public static void main(String[] args){
        Buyer a = new Buyer();
        Buyer b = new Buyer();
        Buyer c = new Buyer();
        a.person("姑姑", 0);
        b.person("妈妈", 0);
        c.person("你", 0);

        Cooker d = new Cooker();
        Cooker e = new Cooker();
        d.person("爸爸");
        e.person("婶婶");

        a.buy("萝卜", 10);
        a.total();
        d.cook("萝卜");

    }
}

class Buyer {
    String name;
    double price;

    public void person(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void buy(String what, double cost) {
        System.out.println(name + " bought " + what + ", which costs " + cost + ".");
        price += cost;
    }

    public void total(){
        System.out.println(name + " totally used " + price + ".");
    }
}

class Cooker {
    String name;

    public void person(String name) {
        this.name = name;
    }

    public void cook(String what) {
        System.out.println(name + " cooked " + what + ".");
    }
}
