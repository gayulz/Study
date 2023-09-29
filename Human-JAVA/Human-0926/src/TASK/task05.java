package TASK;

public class task05 {
    public static void main(String[] args) {
        /*
        문제 : 난건물주
        int[] arr = {1,0,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,0,1}
        int size=2;
        arr 배열에서 0이 의미하는 것은 공터이다.
        size는 건물의 크기 이다. 건물은 하나만 짓는다. 공터는 연속적으로 있어야 한다.
        size 설정값에 따라 공터에 건물을 지을 수 있는 위치는 모두 몇개인가?
        size가 2일경우에 7개이다.
        */

        //선언문
        int[] arr = {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1};
        int size = 3; // 사이즈
        int cnt = 0;
        int bilding = 0;

        // 빌딩 갯수 계산처리문
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                cnt++;
            } else {
                cnt=0;
            }
            if (cnt == size){
                bilding++;
                cnt--;
            }
        }

        // 출력문
        System.out.println(bilding);
    }
}
