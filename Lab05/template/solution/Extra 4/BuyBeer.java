public class BuyBeer implements ICommand{
    Bar bar;
    int num;

    public BuyBeer(Bar bar, int num) {
        this.bar = bar;
        this.num = num;
    }

    @Override
    public void execute() {
        bar.buyBeer(num);
    }
}
