package TASK;

public class task02 {
    public static void main(String[] args) {
        int[] e ={4,5,9,8,3,2,1,8,12,18,15,20};
        for (int i = 0; i < e.length; i++) {
            for (int j = 0; j < e.length; j++) {
                int tmp;
                if (j+1 == e.length) break;
                if (e[j] > e[j+1]){
                    tmp = e[j];
                    e[j] = e[i+1];
                    e[i+1] = tmp;
                }
            }
        }
        for (int i = 0; i < e.length; i++) {
            System.out.print(e[i] + " ");
        }
    }
}
