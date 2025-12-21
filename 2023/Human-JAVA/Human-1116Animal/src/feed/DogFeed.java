package feed;
import static controller.AnimalController.ioText;

public class DogFeed implements feedInf{

    public void feed_Prt(){
        System.out.println("강아지 사료목록");
        System.out.println("1. 칼슘 사료");
        System.out.println("2. 단백질 사료");
    }

    public static String isVaccins(){
        System.out.println("예방접종 여부 : 예 or 아니오 중 선택");
        return ioText("예방접종 여부");
    }
}
