package LERN.CLAS;

import java.util.Scanner;

/**
 * @author Ticysis
 **/
public class Person {
    public String name;
    public double age;

    public Person(String name, double age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println("Hellow ,My name  is" + name + "My age is " + age + "...");
    }
}


    class TestPersion {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            double age = sc.nextDouble();
            Person person = new Person(name, age);
            person.speak();

        }

    }