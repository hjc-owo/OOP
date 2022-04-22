public class BuyEggFriedRice implements ICommand{

    Bar bar;
    int num;

    public BuyEggFriedRice(Bar bar, int num) {
        this.bar = bar;
        this.num = num;
    }

    @Override
    public void execute() {
        bar.buyEggFriedRice(num);
    }
}
