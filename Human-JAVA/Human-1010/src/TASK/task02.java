package TASK;

public class task02 {
    public static void main(String[] args) {
        int[] p = {40,32,21,7};
        int[] restList = {2,1,0,3};
        int[] standTime = new int[4];
        int[] eatTime = new int[4];

        for (int i = 0; i < restList.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (restList[i] == j) {
                    p[j] -= 2;
                    eatTime[j] += 1;
                } else standTime[j] += 1;
            }
            if (i == 3 && p[0] > 0){
                i=0;
            }
        }

        for (int i = 0; i < restList.length; i++) {
            System.out.println(p[i] + " " +  standTime[i] + " " + eatTime[i]);
        }
    }
}
