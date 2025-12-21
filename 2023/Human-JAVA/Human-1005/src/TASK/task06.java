package TASK;

public class task06 {
    public static void main(String[] args) {
        int[] a ={34,55,23,56,34,45,34};
        int[] b ={36,49};
        int bCnt = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (b[i] < a[j]){
                    bCnt++;
                }
            }
            System.out.println(" [a] 배열의 값에 " + b[i] + "보다 큰 숫자는 " + bCnt + "개 있습니다.");
            bCnt=0;
        }
    }
}
