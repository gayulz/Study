package animal;
import feed.feedInf;
import static controller.AnimalController.ioText;
import static feed.DogFeed.isVaccins;

public class Animal_DOG extends Animal {
    static String feeds;
    static feedInf dog;
    static String vaccine;
    public Animal_DOG(String variety, feedInf dogFeed){
        this.dog = dogFeed;
        System.out.println("강아지를 등록합니다");
        this.variety = variety;
        this.name = ioText("이름");
        this.type = ioText("품종");
        this.age = Integer.parseInt(ioText("나이"));
        this.weight = Integer.parseInt(ioText("몸무게"));
        this.height = Integer.parseInt(ioText("키"));
        dog.feed_Prt();
        this.feeds = ioText("먹이");
        this.vaccine = isVaccins();
        animalList.add(this);
    }

    public static void dog_prt(){
        list_prt("DOG");
        System.out.println("접종 여부 : " + vaccine);
        System.out.println("사료 종류 : " + feeds);
    }
}
