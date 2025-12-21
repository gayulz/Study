package TASK;

public class Test06 {
    public static void main(String[] args) {
        /*
            범인을 찾아라. 0부터 100까지 숫자중 하나이다. 0부터 1 2 3 순서대로 합한 값을
            누적한다. 합한 값이 44를 넘어가게 하는 숫자 한개가 범인이다.
            범인 숫자를 출력하시오.. (단, 수업시간에 다루지 않은 기술을 사용금지)
        */

        int cnt = 0;
        int sum = 0;

        for (int i = 0; i < 100; i++) {
            sum += i;
            if (sum < 44) {
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);

    }
}



