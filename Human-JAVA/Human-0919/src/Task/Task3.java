package Task;

public class Task3 {
    public static void main(String[] args) {
        // 문제 3 : 선택한 메뉴와 선택한 수량에 따라 메뉴와 수량이 정정되도록 프로그램을 작성하시오
        int cola = 30; // 메뉴번호 1과 수량
        int strite = 29; // 메뉴번호 2번과 수량
        int water = 43; // 메뉴번호 3과 수량

        int seNum = 1;  // 선택한 메뉴
        int selCun = 5; // 선택한 수량

        System.out.println("선택 한 메뉴 : " + seNum);

        if (seNum == 1) {
            cola -= selCun;
            System.out.println("선택한 메뉴는 cola입니다 " + cola + " 개 입니다 ");
        } else if (seNum == 2) {
            strite -= selCun;
            System.out.println("선택한 메뉴는 strite입니다 " + strite + " 개 입니다 ");
        } else if (seNum == 3) {
            water -= selCun;
            System.out.println("선택한 메뉴는 water입니다 " + water + " 개 입니다 ");
        }
        else {
            System.out.println("메뉴번호는 1, 2, 3 입니다");
        }
        System.out.println(cola);
    }
}
