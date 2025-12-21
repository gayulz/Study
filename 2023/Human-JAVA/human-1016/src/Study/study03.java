package Study;

public class study03 {
    public static void main(String[] args) {
        int[][] arr = new int[4][3];

        for (int i = 0 , v = 10; i < 4; i++,v++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = v;
                v+=4;
            }
            v-=12;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
