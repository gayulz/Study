package task01;

import stock.StockMainMenu;

public class Main {
    public static void main(String[] args) {
        // todo : 주식 프로그램 시작
        /*

         ** 메시지 분석
        String msg ="삼송/5000*엘쥐/7000*휴먼/10000*현다/7800*";
        다음 문자열을 분석하여 주식의 정보를 저장할 수 있는 프로그램을 제작하시오.
        프로그램이 시작되면 msg를 분석하여 주식의 정보를 배열에 저장한다
        메뮤는 주식정보보기, 주식검색하기, 관심주식등록, 관심주식조회
        객체지향언어의 추상화와 캡슐화를 가장 잘 적용하여 제작하시오.
        주식은 마이너스 값은 입력되지 않도록 하세요.
        주식의 정보가 변경되면 관심주식의 정보도 변경되어야 한다.

         */
        String msg ="삼송/5000*엘쥐/7000*휴먼/10000*현다/7800*";
        new StockMainMenu(msg);
    }
}
