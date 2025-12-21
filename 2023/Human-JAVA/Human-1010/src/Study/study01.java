package Study;
public class study01 {
    public static void main(String[] args) {
        int[] ele = {4,5,9,8,3,2,1,8};
        for (int i = 0; i < 9-1; i++) {
            System.out.println(i + "번째 큰 값 찾는 중 ");
            for (int j = 0; j < ele.length-1-i; j++) {
                System.out.println(j+" / " + (j+1) + "버블비교");
                if (ele[j] > ele[j+1]){
                    int temp = ele[j];
                    ele[j] = ele[j+1];
                    ele[j+1]=temp;
                }
            }
//            for (int j = 0; j < ele.length; i++) {
//                System.out.print(ele[j]+ " ");
//            }
//            System.out.println();
        }
    }
}

