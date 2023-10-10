package TASK;

public class task08 {
    public static void main(String[] args) {
        int[] pang = {1, 0, 0, 0, 2, 3, 4, 4, 6, 2, 2, 2, 2, 5};
        int cnt = 0;
        int cntIdx = 0;
        for (int i = 0; i < pang.length; i++) {
            cnt = 0;
            for (int j = i; j < pang.length; j++) {
                if (pang[i] == pang[j]) {
                    cnt++;
                } else {
                    break;
                }
                if (cnt == 1){
                    cntIdx = i;
                }
            }
            if (cnt >= 3) {
                System.out.println(pang[i] + "번 캐릭터는 " + cnt + "개 연속됩니다. 캐릭터 시작위치는 " + (cntIdx+1) + " 입니다. ");
            }
            i += cnt - 1;
        }
    }
}
