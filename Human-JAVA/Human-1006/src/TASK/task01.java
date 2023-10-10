package TASK;

public class task01 {
    public static void main(String[] args) {
        int[] elevator = {4, 5, 9, 8, 3, 2, 1, 8};
        int[] tmpIdx = new int[20];
        int ltCnt = 0;
        int rtCnt = elevator.length - 1;

        for (int i = 0; i < elevator.length; i++) {
            // 3 이하 숫자 제거
            if (elevator[i] <= 3) continue;
            if (elevator[rtCnt] <= 3) {
                rtCnt--;
                i--;
                continue;
            }

            // 오른쪽 숫자가 왼쪽보다 클 경우 왼쪽 숫자를 tmpIdx에 저장 후 포인트이동
            if (elevator[i] < elevator[rtCnt]) {
                tmpIdx[ltCnt] = elevator[i];
                ltCnt++;
            }
            // 왼쪽 숫자가 오른쪽 숫자보다 클 경우 오른쪽 숫자를 tmpIdx에 저장 후 포인트이동
            else if (elevator[i] > elevator[rtCnt]) {
                if (tmpIdx[ltCnt - 1] != elevator[rtCnt]) {
                    tmpIdx[ltCnt] = elevator[rtCnt];
                    i--;
                    rtCnt--;
                    ltCnt++;
                }
                if (tmpIdx[ltCnt - 1] == elevator[rtCnt]) {
                    tmpIdx[ltCnt] = elevator[i];
                    break;
                }
            }
            // 왼쪽 포인트가 오른쪽 포인트숫자와 같거나 커지면 for문 종료
            if (ltCnt >= rtCnt) break;
        }

        System.out.println(" 입력하신 층 정보입니다 ");

        // 출력문

        // max 값 = rtCnt 저장 , min값 ltCnt저장 변수 재이용

        for (int i = 0; i < tmpIdx.length; i++) {
            int tmp = 0;
            for (int j = 0; j < tmpIdx.length; j++) {
                if (i + 1 == tmpIdx.length) {
                    break;
                }
                if (tmpIdx[i] > tmpIdx[i + 1]) {
                    tmp = tmpIdx[i];
                    tmpIdx[i] = tmpIdx[i + 1];
                    tmpIdx[i + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < tmpIdx.length; i++) {
            if (tmpIdx[i] > 3) System.out.println(tmpIdx[i] + "층");
        }
    }
}