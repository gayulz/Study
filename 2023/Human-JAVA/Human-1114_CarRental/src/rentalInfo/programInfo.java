package rentalInfo;
import java.util.Scanner;

public class programInfo {
    public programInfo(){
        boolean flag = true;
        while(flag){
            programInfoPrt();
            int choice = Integer.parseInt(textIO("메뉴 번호"));
            switch (choice){
                case 1 :
                    Rental_CarAdd rca = Rental_CarAdd.getInstance();
                    rca.set_RentalCar();
                    break;
                case 2 :
                    Rental_contract rct = Rental_contract.getInstance();
                    rct.Rental_contract();
                    break;
                case 3 :
                    Rental_Success rss = Rental_Success.getinstance();
                 rss.get_SuccessRental();
                    break;
                case 4 :
                    System.out.println("프로그램종료");
                    flag = false;
                    break;
                default:
                    System.out.println("다시 입력 ");
            }
        }
    }

    public void programInfoPrt(){
        System.out.println("1. 렌트 차량 등록");
        System.out.println("2. 렌트 예약");
        System.out.println("3. 렌트 예약 완료건 전체보기");
        System.out.println("4. 종료");
    }

    public static String textIO(String text){
        Scanner in = new Scanner(System.in);
        System.out.print("\t" + text + " 입력 >> ");
        return in.nextLine();
    }
}
