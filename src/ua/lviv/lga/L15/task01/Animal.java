package ua.lviv.lga.L15.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Animal {
    private AnimalType type;
    private String name;


    List<AnimalType> animalTypes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Animal(AnimalType type, String name) {
        this.type = type;
        this.name = name;
    }

    public Animal() {
    }

    public void addAnimalToPerson() {
        String st;
        animalTypes.addAll(List.of(AnimalType.values()));

        System.out.println("Введіть iм'я улюбленця: ");
        st = sc.nextLine();
        System.out.println("Введіть 0  для  DOG, 1  для  CAT ");
        int typ = sc.nextInt();
        this.setName(st);
        this.setType(animalTypes.get(typ));
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;

        if (getType() != animal.getType()) return false;
        return getName().equals(animal.getName());
    }

    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }

    public String getName() {
        return name;
    }

    public AnimalType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return type + "  на ім'я   " + name;
    }


}
