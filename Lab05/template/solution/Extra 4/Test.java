public class Test {
    public static void main(String[] args) {
        Bar bar = new Bar();
        Engineer engineer1 = new Engineer();
        Engineer engineer2 = new Engineer();
        // 点一份炒饭 + 啤酒， 花费 30 元
        Executor executor1 = new Executor();
        executor1.add(new BuyBeer(bar, 1));
        executor1.add(new BuyEggFriedRice(bar, 1));
        executor1.add(new SpendMoney(engineer1, 50));
        executor1.run();
        // 点两份炒饭， AA，每人 20 元
        Executor executor2 = new Executor();
        executor2.add(new BuyBeer(bar, 2));
        executor2.add(new SpendMoney(engineer1, 50));
        executor2.add(new SpendMoney(engineer2, 50));
        executor2.run();
    }


}
