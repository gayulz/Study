package Chapter_List;

public class chapter_8 {
    public static <test> void main(String[] args) {

        int[][] test = {
                        {1,2,3,4,5,6} ,
                        {7,8,9,10,11,12},
                        {13,14,15,16,17,18},
                        {19,20,21,22,23,24},
                        {25,26,27,28,29,30},
                        {31,32,33,34,35,36}
                        };

        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test.length; j++) {
                int tmp = test[i][j];
                System.out.print(" [" + tmp + "]" + j +"\t ");
            }
            System.out.println( i + "의 회차갱신");
        }
    }
}
