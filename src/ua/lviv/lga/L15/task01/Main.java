package ua.lviv.lga.L15.task01;

import java.util.*;

public class Main {

    static void menu() {
        System.out.println();
        System.out.println("Введіть 0 : завершити");
        System.out.println("Введіть 1 :  додати учасника клубу");
        System.out.println("Введіть 2 :  додати утваринку часнику ");
        System.out.println("Введіть 3 :  видалити тваринку учаснику клюбу");
        System.out.println("Введіть 4 :  видалити учасника клюбу");
        System.out.println("Введіть 5 :  видалити тваринку у всіх");
        System.out.println("Введіть 6 :  вивести зооклуб");
        System.out.println("Введіть 7 :  вивести тварючок певного учасника");
    }

    public static void main(String[] args) {


        ZooClub zoo = new ZooClub();

        Scanner sc = new Scanner(System.in);

        while (true) {
            menu();
            switch (sc.next()) {
                case "0":
                    sc.close();
                    System.exit(0);
                    break;
                case "1":
                    zoo.addMember();
                    break;
                case "2":
                    zoo.addPetToMember();

                    break;
                case "3":
                    zoo.deletePetOfMember();
                    break;
                case "4":
                    zoo.deleteMember();

                    break;
                case "5":
                    zoo.deleteAllCat();

                    break;
                case "6":
                    zoo.showAllMembers();
                    break;
                case "7":
                    zoo.showAllPetOfMember();
                    break;


            }

        }

    }
}
