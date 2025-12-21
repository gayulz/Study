package animal;

import java.util.ArrayList;

public class Animal {
    public String type;
    public String variety;
    public int age = 0;

    public String name;
    public int weight = 0;
    public int height = 0;
    public final static ArrayList<Animal> animalList = new ArrayList<>();

    public static void list_prt(String variety){
        for (Animal animal : animalList) {
            if (animal.variety.equals(variety)) {
                System.out.println("--------------------------------");
                System.out.println("종류 : " + variety);
                System.out.println("이름 : " + animal.name);
                System.out.println("품종 : " + animal.type);
                System.out.println("나이 : " + animal.age);
                System.out.println("몸무게 : " + animal.weight + "kg");
                System.out.println("키 : " + animal.height + "cm");
            }
        }
    }
}
