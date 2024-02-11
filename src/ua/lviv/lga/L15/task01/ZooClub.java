package ua.lviv.lga.L15.task01;


import java.util.*;

public class ZooClub {
    Map<Person, List<Animal>> map = new HashMap<>();

    List<Person> person = new ArrayList();
    Scanner sc = new Scanner(System.in);
    int num = -1;
    String st;

    public void addMember() {
        num = -1;
        Person pr = new Person();
        pr.addPerson();

        num = getPersonExist(pr.getName());

        if (num > -1) System.out.println("Така персона вже існує. Введіть іншого учасника клубу.");
        else {
            person.add(pr);
            System.out.println("Персону успішно додали до клубу");
            map.put(pr, new ArrayList<>());
        }
    }

    private int getPersonExist(String name) {
        int num = -1;

        for (Person pr : person) {
            if (pr.getName().equalsIgnoreCase(name)) {
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
            Iterator<Map.Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Person, List<Animal>> next = iterator.next();

                if (next.getKey().getName().equals(st)) {
                    List<Animal> animalList = next.getValue();
                    next.getKey().addPet(animal);

                    animalList.add(animal);
                    next.setValue(animalList);

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
            Iterator<Map.Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Person, List<Animal>> next = iterator.next();

                if (next.getKey().getName().equals(st)) {
                    iterator.remove();
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

        Iterator<Map.Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();


        while (iterator.hasNext()) {

            Map.Entry<Person, List<Animal>> nextMap = iterator.next();
            List<Animal> animalList = nextMap.getValue();
            Iterator<Animal> iterator1 = animalList.iterator();

            while (iterator1.hasNext()) {

                if (iterator1.next().getType().name().equalsIgnoreCase(st)) {
                    iterator1.remove();
                    num++;

                }
            }
            if (num > -1) System.out.println("Успішно видалено");
            else System.out.println("Такої тваринки учасники не мають.");

        }
    }


    public void deletePetOfMember() {
        num = -1;
        System.out.println("Введіть iм'я учасника клубу");
        st = sc.nextLine();
        num = getPersonExist(st);

        if (num == -1) {
            System.out.println("Такої персони  немає в клубі.");
        } else {
            Iterator<Map.Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();

            while (iterator.hasNext()) {

                Map.Entry<Person, List<Animal>> next = iterator.next();

                if (next.getKey().getName().equalsIgnoreCase(st)) {

                    System.out.println(next.getKey().getName() + "   має таких тваринок:  " + next.getValue());
                    List<Animal> animalList = next.getValue();

                    Iterator<Animal> iterator1 = animalList.iterator();

                    while (iterator1.hasNext()) {
                        iterator1.next();
                        iterator1.remove();
                    }
                    System.out.println("Видалено всіх тварюк у  " + st);

                }
            }
            //   sc.close();

        }
    }

    public void showAllMembers() {

        if (!map.isEmpty()) {

            Iterator<Map.Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Person, List<Animal>> next = iterator.next();

                if (next.getValue().size() == 0)
                    System.out.println("Учасник клубу:  " + next.getKey() + "  ще не вказав тваринок");

                else {
                    System.out.println("Учасник клубу:  " + next.getKey() + ",  улюбленці:  ");
                    for (int i = 0; i < next.getValue().size(); i++) {
                        System.out.println(next.getValue().get(i).getType() + " кличка " + next.getValue().get(i).getName());
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
            Iterator<Map.Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Person, List<Animal>> next = iterator.next();

                if (next.getKey().getName().equals(st)) {

                    System.out.println("Person:  " + next.getKey().getName());
                    List<Animal> animalList = next.getValue();
                    if (animalList.size() == 0)
                        System.out.println("Person:  " + next.getKey().getName() + "ще не має улюбленців");
                    else {
                        for (int i = 0; i < animalList.size(); i++) {
                            System.out.println("  Улюбленець: " + animalList.get(i).getType() + " на ім'я " + animalList.get(i).getName());

                        }
                    }


                }


            }
        }
    }


}

