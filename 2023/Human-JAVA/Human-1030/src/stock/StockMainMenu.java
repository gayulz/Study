package stock;
import java.util.HashMap;
import java.util.Scanner;

public class StockMainMenu {
    private Scanner in = new Scanner(System.in);
    private HashMap<String, Integer> stockListMap = new HashMap<>();
    public StockMainMenu(String msg){
        stockAdd(msg);
        boolean flag = true;
        while(flag){
            menu();
            int menuNum = in.nextInt();
            in.nextLine();
            switch (menuNum){
                case 1: // 주식 정보보기
                    stockInformation();
                    break;
                case 2: // 주식 검색하기
                    stockSearch();
                    break;
                case 3: // 관심 주식 등록
                    targetStock();
                    break;
                case 4 : // 관심 주식 조회
                    break;
                case 5 : // 종료
                    System.out.println("프로그램 종료합니다");
                    flag = false;
                    break;
                default:
                    System.out.println("입력된 번호는 없습니다 다시 입력하세요");
            }
        }

    }

    private void targetStock() {
        System.out.println("관심 주식을 등록하세요. 등록 완료 시 관심주식 조회에서 별도로 관리됩니다.");
    }

    // 주식 검색하기
    private void stockSearch() {
        System.out.println("주식 검색 기능입니다 ");
        System.out.print("찾을 주식 이름 입력 >> ");
        String searchName = in.nextLine();
        int price = stockListMap.get(searchName).intValue();
        System.out.println("이름 : " + searchName + " / 가격 : " + price );


    }
    // 주식 전체 보기 메서드
    private void stockInformation(){
        System.out.println("오늘의 주식 전체 정보 입니다.");
        for (String key : stockListMap.keySet()) {
            System.out.println( String.format( "주식 이름 : %s ,  값 : %s", key,stockListMap.get(key)));
        }
    }



    // msg 입력받은 문자열을 자동으로 stock HashMap에 입력하는 메서드
    private void stockAdd(String msg) {
        String replaceMsg = msg.replaceAll("[^0-9 + 가-힣]", "/");
        String[] splitMsg = replaceMsg.split("/");
        for (int i = 0; i < splitMsg.length; i++) {
            if (i % 2 == 0)
                if ( Integer.valueOf(splitMsg[i+1]) >= 0 )
                    stockListMap.put(splitMsg[i], Integer.valueOf(splitMsg[i+1]));
        }
    }
    public void menu(){
        System.out.println("오늘의 주식 정보 프로그램");
        System.out.println("1. 오늘의 주식 전체 정보");
        System.out.println("2. 주식 검색");
        System.out.println("3. 관심 주식 등록");
        System.out.println("4. 관심 주식 조회");
        System.out.println("5. 종료");
        System.out.print(" 번호 입력 >> ");
    }
}
