package TASK;
public class task03 {
    public static void main(String[] args) {
        int[] p = {40,32,21,7};
        int[] restList = {2,1,0,3};
        int[] pTime = new int[4];
        int[] eTime = new int[4];
        int idxTmp = 0;

        while (true) {
            int tmp = restList[0];
            p[tmp] -= 2;
            eTime[tmp] += 1;
            for (int j = 0; j < restList.length; j++) {
                if (j != tmp) pTime[j] += 1;
                else if (j == tmp) continue;
            }
            for (int i = 0; i <= restList.length; i++) {
                if ( i == 0 ) {
                    idxTmp = restList[0];
                }
                else if ( i <= 3) {
                    restList[i-1] = restList[i];
                }
                else if ( i == 4) {
                    restList[3] = idxTmp;
                }
            }
            if (p[0] <= 0 ) break;
        }
        for (int i = 0; i < p.length; i++) {
            int tmp = restList[i];
            System.out.println( restList[tmp] + " 번째 사람의 잔여 사탕 : " + p[tmp] + " / 먹은 시간 : " + eTime[tmp] + " / 대기시간 : " + pTime[tmp]);
        }

        for (int i = 0; i < restList.length; i++) {
            System.out.println(restList[i]);
        }
    }
}
