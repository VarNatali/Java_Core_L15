package ua.lviv.lga.L15.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Person {
    private String name;
    private int age;
    Scanner sc = new Scanner(System.in);
    List<Animal> pet = new ArrayList<>();

    public void addPerson() {
        System.out.println("Введіть iм'я учасника клубу: ");
        setName(sc.nextLine());
        System.out.println("Введіть його вік: ");
        setAge(sc.nextInt());

    }

    public void addPet(Animal a) {
        a.addAnimalToPerson();
        pet.add(a);

    }

    public void deletePet(Animal a) {

        pet.remove(a);
        System.out.println("тварючки: " + pet);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return " name=  " + name + ", age= " + age;
    }

}