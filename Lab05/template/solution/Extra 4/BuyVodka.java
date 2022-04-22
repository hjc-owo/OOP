public class BuyVodka implements ICommand {
    Bar bar;
    int num;

    public BuyVodka(Bar bar, int num) {
        this.bar = bar;
        this.num = num;
    }

    @Override
    public void execute() {
        bar.buyVodka(num);
    }
}
