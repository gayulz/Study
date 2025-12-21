package animal;
import static controller.AnimalController.ioText;

public class Animal_FISH extends Animal {
    public Animal_FISH(String fish) {
        System.out.println("물고기를 등록합니다");
        this.variety = fish;
        this.name = ioText("이름");
        System.out.println("품종 : 바다물고기 or 민물물고기 중 선택");
        this.type = ioText("품종");
        if (this.type.equals("바다물고기") || this.type.equals("민물물고기")) {
            this.age = Integer.parseInt(ioText("나이"));
            this.weight = Integer.parseInt(ioText("몸무게"));
            this.height = Integer.parseInt(ioText("키"));
            animalList.add(this);
        } else System.out.println("잘못된 입력 입니다");
    }
}
