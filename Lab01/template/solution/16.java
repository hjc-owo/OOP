public class LoseWeight {
    String name;
    double weight;
    public void Person(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    public void loseWeight(double changeWeight) {
        this.weight += changeWeight;
    }
    public void printWeight(){
        System.out.println(this.name + "'s weight is " + this.weight);
    }
}

class Lose {
    public static void main(String[] args){
        LoseWeight person = new LoseWeight();
        person.Person("xiaowang", 70);
        person.loseWeight(45-70);
        person.printWeight();
    }
}
