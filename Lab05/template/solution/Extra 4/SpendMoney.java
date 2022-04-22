public class SpendMoney implements ICommand {

    Engineer engineer;
    double cost;

    public SpendMoney(Engineer engineer, double cost) {
        this.engineer = engineer;
        this.cost = cost;
    }

    @Override
    public void execute() {
        engineer.spendMoney(cost);
    }
}
