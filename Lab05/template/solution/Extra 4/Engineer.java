public class Engineer {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void spendMoney(double cost) {
        System.out.println("The engineer " + this.getName() + "Spend $" + cost);
    }
}
