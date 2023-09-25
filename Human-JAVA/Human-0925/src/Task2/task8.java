package Task2;

public class task8 {
    public static void main(String[] args) {
        // 문제 8 :  int[] arr = {1,2,3,0,0,0,1,2,2,4,2,2,2,2,2,0,0,0,0,0,3,3}
        //   숫자는 터널의 번호이다. 터널의 길이가 가장 긴 숫자와 길이를 출력하시오.

        // 선언부
        int[] arr = {1, 2, 3, 0, 0, 0, 0, 0, 1, 2, 2, 4, 2, 2, 2, 2, 2, 0, 0, 0, 0, 3, 3};
        int maxNum = 0, maxCnt= 0, tagetNum = 0, tagetCnt = 0, maxCnt1 = 0, maxNum1 = 0;
        // tagetNum = 타겟된 숫자
        // tagetCnt = 타겟 숫자의 누적 개수
        // maxNum = 가장 높은 누적수의 숫자
        // maxCnt = 가장 높은 누적숫자의 실제 누적 개수

        // 출력부
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == tagetNum ) {        // 현재 i의 값과 타겟번호를 비교함, 같을 경우
                tagetCnt++;                   // 타겟 누적을 증가시킴
                if (tagetCnt > maxCnt) {      // 타겟번호의 누적 개수와 큰 수의 누적 갯수 비교 / 타겟번호 누적개수가 더 크다면
                    maxCnt = tagetCnt;        // 타겟 누적 횟수를 를 큰 수 누적 횟수에 입력
                    maxNum = tagetNum;        // 타겟 번호를 큰 수 번호에 대입
                } else if (tagetCnt == maxCnt){
                    maxCnt1 = tagetCnt;
                    maxNum1 = tagetNum;
                }
            } else {                          // i의 값과 타겟번호가 다를 경우
                tagetNum = arr[i];            // 큰 수의 카운팅이 더 크다면 타겟넘버에 해당 인덱스i번째의 수를 대입시킴
                tagetCnt = 1;                 // 타겟넘버의 횟수 초기화
            }
        }
        System.out.println("가장 긴 숫자 : " + maxNum + " / " + maxNum1);
        System.out.println("가장 긴 숫자의 크기 : " + maxCnt + " / " + maxCnt1);
    }
}