//AnimalTest1.java

import java.util.ArrayList;
import java.util.List;

public class AnimalTest1 {
    public void testDemo(List<?> s) {
        for (Object obj : s) {
            System.out.println("My type is " + obj.getClass().getName());
        }
    }

    public static void main(String[] args) {
        AnimalTest1 test = new AnimalTest1();
        Dog dog = new Dog();
        Animal animal = new Animal();
        List<Animal> s = new ArrayList<Animal>();
        s.add(dog);
        s.add(animal);
        test.testDemo(s);
    }
}