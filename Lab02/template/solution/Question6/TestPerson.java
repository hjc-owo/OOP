class Person {
    String name;
    int age;
    String sex;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void work() {
        System.out.println("working");
    }

    public void showAge() {
        System.out.println(this.getAge());
    }

}

public class TestPerson {
    public static void main(String[] args){
        Person a = new Person("hjc",19,"male");
        System.out.println(a.name + " " + a.age + " " + a.sex);

        a.setAge(20);
        System.out.println(a.name + " " + a.age + " " + a.sex);

        System.out.println(a.getAge());

        Person b = new Person("test", 18, "female");
        System.out.println(b.name + " " + b.age + " " + b.sex);

        b.setAge(21);
        System.out.println(b.name + " " + b.age + " " + b.sex);

        System.out.println(b.getAge());


    }
}
