package controller;
import animal.*;
import feed.CatFeed;
import feed.DogFeed;

import java.util.Scanner;

public class AnimalController {
    static Scanner in = new Scanner(System.in);
    public AnimalController() {
        boolean flag = true;
        try {
            while (flag) {
                int number = Integer.parseInt(ioMenu());
                switch (number) {
                    case 1:
                        new Animal_CAT("CAT", new CatFeed());
                        break;
                    case 2:
                        new Animal_DOG("DOG", new DogFeed());
                        break;
                    case 3:
                        new Animal_FISH("FISH");
                        break;
                    case 4:
                        Animal_List_Search animalListSearch = Animal_List_Search.getInstance();
                        animalListSearch.animal_List();
                        break;
                    case 5:
                        System.out.println("프로그램종료");
                        flag = false;
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
        }
    }
    public static String ioText(String text){
        System.out.print("\t"+text+"입력 >> ");
        return in.nextLine();
    }
    private String ioMenu() {
        System.out.println("1. CAT");
        System.out.println("2. DOG");
        System.out.println("3. FISH");
        System.out.println("4. LIST");
        System.out.println("5. EXIT");
        return ioText("번호");
    }
}
