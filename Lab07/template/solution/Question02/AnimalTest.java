//AnimalTest.java
public class AnimalTest {
    public <T, S extends T> T testDemo(T t, S s) {
        System.out.println("I am type T and my type is " + t.getClass().getName());
        System.out.println("I am type S and my type is " + s.getClass().getName());
        return t;
    }

    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        Dog dog = new Dog();
        Animal animal = new Animal();
        Animal animal1 = test.testDemo(animal, dog);
    }
}