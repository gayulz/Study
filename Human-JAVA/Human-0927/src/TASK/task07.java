package TASK;

import java.util.Random;

public class task07 {
    public static void main(String[] args) {
//        문제 7
//        컴퓨터는 랜덤으로 로또 번호를 10000번 뽑는다.
//        가장 많이 뽑힌 로또 번호가 오늘의 추천 로또 번호이다
//        오늘의 추천 로또 번호 하나를 출력하시오.  만약 로또 번호가 같은 횟수로 나왔을 경우에는 큰 숫자가 우선한다.

        Random r = new Random();
        int[] lotto = new int[10000];  // 랜덤 추출 대입 배열
        int[] CntNumber = new int[lotto.length];  // 카운팅 된 배열
        int numPoint = 0;            // 비교하는 대상 번호의 위치 포인터 번호 _ 1번 더 재사용함
        int cnt = 0;                 // 카운트 갯수 사용 변수 _ 1번더 재사용함
        int maxNumber = 0;          // 결과 출력 변수

        // 랜덤 수 대입문
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = r.nextInt(45) + 1;
        }


        // 0~10000번까지의 중복카운트 및 번호 확인
        for (int i = 0; i < lotto.length; i++) {
            int tmp = lotto[numPoint];
            // i번 인덱스부터 ~ 마지막까지 지속 비교
            if (tmp == lotto[i]) {
                cnt++;
            }
            if ( i == lotto.length-1 ){
                CntNumber[numPoint] = cnt;
                numPoint++;
                i=0;
                cnt = 0;
            }
            // 배열에 넣은 갯수와 lotto배열 크기-1과 같아질 경우 종료
            if( numPoint == lotto.length-1){
                CntNumber[numPoint] = cnt;
                numPoint=0;
                cnt=0;
                break;
            }
        }

        // 배열별 카운트가 가장 높은 숫자 추출

        for (int i = 0; i < CntNumber.length; i++) {
            if (cnt < CntNumber[i]){
                cnt = CntNumber[i];           // 큰 값을 cnt에 입력해 놓는다
                numPoint = i;                // 큰 카운트 숫자의 인덱스 번호를 넣어준다
            }
            if ( cnt == CntNumber[i]){        // 큰 번호와 i인덱스의 데이터값이 같을 경우
                if (lotto[numPoint] > lotto[i] ){  // cnt 데이터의 인덱스번호를 사용하여 lotto숫자를불러오고, i를 사용하여 lotto숫자를 불러와 비교한다
                    maxNumber = lotto[numPoint];
                } else if (lotto[numPoint] < lotto[i] ){
                    maxNumber = lotto[i];
                } else if (lotto[numPoint] == lotto[i] ){
                    maxNumber = lotto[i];
                }
            }
        }

//        System.out.println(" ");
        System.out.println(" 행운의 로또번호 추첨기, 번호 1개만 제공합니다 . ");
        // cnt = 가장 높은 카운트 횟수 , numPoint = 해당 인덱스 번호
        System.out.println(" 가장 높은 중복 횟수 : " + cnt );
        System.out.println(" 오늘의 번호 : " + maxNumber);

    }
}
