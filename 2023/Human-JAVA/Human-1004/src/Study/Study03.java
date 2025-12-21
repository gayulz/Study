package Study;

public class Study03 {
    public static void main(String[] args) {
        int[] a = { 35,45,37,29,38,4 };

        for (int i = 0; i < a.length; i++) {
            if (a[i]%2==0){
                a[i]=0;
                continue;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (i < a.length-1 ) {
                System.out.print(a[i]);
                System.out.print(" | ");
            } else if ( i == a.length-1 ){
                System.out.println(a[i]);
            }
        }
    }
}
