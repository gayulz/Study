package TASK;

public class task01 {
    public static void main(String[] args) {

//        문제 1
//        String a ="23 - 56 + 45 * 2 - 56";
//        수식을 계산하는 프로그램을 작성하세요.
//        수식 계산 규칙은 연산자 우선순위 없이 앞에서 부터 차례대로 계산한다.
//        지금까지 공부한 내용으로 해결하시고, 형변환만 검색이 가능합니다.

        String a = "23-56+45*2-56";
        String[] arrsub = new String[2];
        String[] arr = new String[5];
        char[] spChar = new char[4];
        boolean flag = true;
        int SubCnt = 0;
        int arrT = 0;
        int opCnt = 0;

        // 숫자와 특수문자 분리 및 숫자 분해와 재조립 실행문
        for (int i = 0; i < a.length(); i++) {
            char v = a.charAt(i);

            if (v == '-' || v == '*' || v == '+' || v == '%') {
                spChar[opCnt] = v;
                opCnt++;
                flag = false;
            } else {
                arrsub[SubCnt] = Character.toString(v);
                SubCnt++;
            }

            if (!flag) {
                // 1자리 숫자가 들어올 경우 null값 없이 처리되게끔 진행
                if (arrsub[1] == null) {
                    arr[arrT] = arrsub[0];
                } else if (arrsub[1] == null && arrsub[2] == null) {
                    arr[arrT] = arrsub[0];
                } else {
                    // null값이 없는 경우 join 연산으로 String 배열에 대입
                    arr[arrT] = String.join("", arrsub);
                }
                arrT++;
                flag = true;
                SubCnt = 0;
                arrsub = new String[2];
            }

            // 마지막 숫자까지 배열처리
            if (i == a.length() - 1) {
                if (arrsub[1] == null) {
                    arr[arrT] = arrsub[0];
                } else if (arrsub[1] == null && arrsub[2] == null) {
                    arr[arrT] = arrsub[0];
                } else {
                    // null값이 없는 경우 join 연산으로 String 배열에 대입
                    arr[arrT] = String.join("", arrsub);
                }
            }
        }

        // 재사용 변수 초기화
        opCnt = 0;
        arrT = 0;

        // 계산 진행
        for (int i = 0; i < arr.length; i++) {
            // 첫 숫자 대입
            if (i == 0) {
                arrT = Integer.parseInt(arr[i]);
            }
            if (i > 0) {
                char op = spChar[opCnt];
                if (op == '-') {
                    arrT = arrT - Integer.parseInt(arr[i]);
                    opCnt++;
                } else if (op == '+') {
                    arrT = arrT + Integer.parseInt(arr[i]);
                    opCnt++;
                } else if (op == '*') {
                    arrT = arrT * Integer.parseInt(arr[i]);
                    opCnt++;
                } else if (op == '%') {
                    arrT = arrT % Integer.parseInt(arr[i]);
                } else if (op == '/') {
                    arrT = arrT / Integer.parseInt(arr[i]);
                }
            }

            // 연산 처리 결과 출력부
        }
            System.out.println("입력된 String 연산자 내용 : " + a);
            System.out.println("연산 처리 결과 : " + arrT);
    }
}