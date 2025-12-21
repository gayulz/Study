package controller;

import animal.Animal;
import animal.Animal_CAT;
import animal.Animal_DOG;
import static controller.AnimalController.ioText;

public class Animal_List_Search extends animal.Animal{
    private Animal_List_Search(){}
    private static Animal_List_Search instance;
    public static Animal_List_Search getInstance(){
        if (instance == null) instance = new Animal_List_Search();
        return instance;
    }

    public void animal_List(){
        animal_select();
        switch (Integer.parseInt(ioText("번호"))){
            case 1 :
                Animal_CAT.cat_prt();
                break;
            case 2 :
                Animal_DOG.dog_prt();
                break;
            case 3:
                Animal.list_prt("FISH");
                break;
            case 4 :
                System.out.println("초기메뉴로 이동합니다");
                break;
            default :
                System.out.println("잘못된 입력입니다. 초기화면으로 돌아갑니다");
                break;
        }
    }

    private void animal_select() {
        System.out.println("동물별 등록된 리스트보기입니다");
        System.out.println("1. 고양이");
        System.out.println("2. 강아지");
        System.out.println("3. 물고기");
        System.out.println("4. 이전화면");
    }
}
