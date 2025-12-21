package animal;
import feed.feedInf;
import static controller.AnimalController.ioText;

public class Animal_CAT extends Animal {
    static String feed_title;
    feedInf cat;
    public Animal_CAT(String variety, feedInf catFeed) {
        this.cat = catFeed;
        System.out.println("고양이를 등록합니다");
        this.variety = variety;
        this.name = ioText("이름");
        this.type = ioText("품종");
        this.age = Integer.parseInt(ioText("나이"));
        this.weight = Integer.parseInt(ioText("몸무게"));
        this.height = Integer.parseInt(ioText("키"));
        cat.feed_Prt();
        feed_title = ioText("먹이");
        animalList.add(this);
    }

    public static void cat_prt(){
        list_prt("CAT");
        System.out.println("사료 종류 : " + feed_title);
    }
}
