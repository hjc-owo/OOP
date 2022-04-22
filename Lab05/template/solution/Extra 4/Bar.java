public class Bar {
    static String name = "A Bar";
    static final int ricePrice = 20;
    static final int beerPrice = 10;
    static final int vodkaPrice = 30;

    public Bar() {
    }

    public String getName() {
        return name;
    }

    public void buyEggFriedRice(int num) {
        System.out.println("Buy " + num + " egg fried rice in " + getName() + " for " + num * ricePrice + " dollars.");
    }

    public void buyBeer(int num) {
        System.out.println("Buy " + num + " beer in " + getName() + " for " + num * beerPrice + " dollars.");
    }

    public void buyVodka(int num) {
        System.out.println("Buy " + num + " vodka in " + getName() + " for " + num * vodkaPrice + " dollars.");
    }
}
