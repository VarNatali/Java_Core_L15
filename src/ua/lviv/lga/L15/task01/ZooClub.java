package ua.lviv.lga.L15.task01;


import java.util.*;

public class ZooClub {
    Map<Person, List<Animal>> map = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    int num = -1;
    String st;
    int age = 0;

    public void addMember() {
        num = -1;
        Person pr = new Person();
        pr.addPerson();
        num = getPersonExist(pr.getName());
        if (num > -1) {
            System.out.println("Така персона вже існує. Введіть іншого учасника клубу.");
        } else {

            map.put(pr, new ArrayList<>());
            System.out.println("Персону успішно додали до клубу");
        }
    }

    private int getPersonExist(String name) {
        int num = -1;

        Set<Map.Entry<Person, List<Animal>>> entrySet = map.entrySet();

        for (Map.Entry<Person, List<Animal>> pair : entrySet) {
            if (pair.getKey().getName().equalsIgnoreCase(name)) {
                num++;
            }
        }
        return num;
    }

    public void addPetToMember() {
        num = -1;
        System.out.println("Введіть iм'я учасника клубу");
        st = sc.nextLine();
        num = getPersonExist(st);
        Animal animal = new Animal();
        if (num == -1) {
            System.out.println("Такої персони ще немає в клубі.");
        } else {

            Set<Map.Entry<Person, List<Animal>>> entrySet = map.entrySet();

            for (Map.Entry<Person, List<Animal>> pair : entrySet) {
                if (pair.getKey().getName().equalsIgnoreCase(st)) {
                    List<Animal> animalList = pair.getValue();
                    pair.getKey().addPet(animal);
                    animalList.add(animal);
                    pair.setValue(animalList);
                    System.out.println("Тваринку " + animal + " додано");
                }

            }
        }

    }

    public void deleteMember() {
        num = -1;
        System.out.println("Введіть iм'я учасника клубу");
        st = sc.nextLine();
        num = getPersonExist(st);
        if (num == -1) {
            System.out.println("Такої персони ще немає в клубі.");
        } else {

            Map<Person, List<Animal>> mapCopy = new HashMap<>(map);
            Set<Map.Entry<Person, List<Animal>>> entrySetCopy = mapCopy.entrySet();
            for (Map.Entry<Person, List<Animal>> pairCopy : entrySetCopy) {
                if (pairCopy.getKey().getName().equalsIgnoreCase(st)) {
                    map.entrySet().remove(pairCopy);
                    System.out.println("Учасника клубу " + st + " видалено.");

                }
            }

        }
    }

    public void deleteAllCat() {
        num = -1;
        System.out.println("Введіть тип тваринки");
        System.out.println("CAT or DOG ");
        st = sc.nextLine();
        int size = 0;


        Set<Map.Entry<Person, List<Animal>>> entrySet = map.entrySet();

        for (Map.Entry<Person, List<Animal>> pair : entrySet) {
            List<Animal> animalList = pair.getValue();
            Iterator<Animal> iterator = animalList.iterator();

            while (iterator.hasNext()) {
                if (iterator.next().getType().name().equalsIgnoreCase(st)) {
                    iterator.remove();
                    num++;

                }
            }
        }
        if (num > -1) System.out.println("Успішно видалено.");
        else System.out.println("Такої тваринки учасники не мають.");
    }

    public void deletePetOfMember() {
        num = -1;
        System.out.println("Введіть iм'я учасника клубу");
        st = sc.nextLine();
        num = getPersonExist(st);

        if (num == -1) {
            System.out.println("Такої персони  немає в клубі.");
        } else {

            Set<Map.Entry<Person, List<Animal>>> entrySet = map.entrySet();

            for (Map.Entry<Person, List<Animal>> pair : entrySet) {
                if (pair.getKey().getName().equalsIgnoreCase(st)) {
                    List<Animal> animalList = pair.getValue();
                    Iterator<Animal> iterator = animalList.iterator();
                    while (iterator.hasNext()) {
                        iterator.next();
                        iterator.remove();

                    }
                    System.out.println("Видалено всіх тварюк у  " + st);
                }
            }
        }

    }


    public void showAllMembers() {

        if (!map.isEmpty()) {

            Set<Map.Entry<Person, List<Animal>>> entrySet = map.entrySet();

            for (Map.Entry<Person, List<Animal>> pair : entrySet) {
                if (pair.getValue().isEmpty()) {
                    System.out.println("Учасник клубу:  " + pair.getKey() + "  ще не вказав тваринок");

                } else {
                    System.out.println("Учасник клубу:  \n" + pair.getKey() + ", \nулюбленці:  ");
                    List<Animal> animalList = pair.getValue();
                    for (Animal al : animalList) {
                        System.out.println(al.getType() + " кличка  " + al.getName());
                    }

                }

            }

        } else {
            System.out.println("У цьому клубі немає учасників.");
        }


    }

    public void showAllPetOfMember() {
        num = -1;
        System.out.println("Введіть iм'я учасника клубу");
        st = sc.nextLine();
        num = getPersonExist(st);
        if (num == -1) {
            System.out.println("Такої персони  немає в клубі.");
        } else {

            Set<Map.Entry<Person, List<Animal>>> entrySet = map.entrySet();

            for (Map.Entry<Person, List<Animal>> pair : entrySet) {

                if (pair.getKey().getName().equalsIgnoreCase(st)) {
                    List<Animal> animalList = pair.getValue();
                    if (animalList.isEmpty()) {
                        System.out.println("Person:  " + pair.getKey().getName() + "  ще не має улюбленців");
                    } else {
                        for (Animal al : animalList) {
                            System.out.println("  Улюбленець: " + al.getType() + " кличка  " + al.getName());

                        }
                    }

                }


            }


        }
    }


}

