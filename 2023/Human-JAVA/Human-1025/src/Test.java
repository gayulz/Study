public class Test {
    public static void main(String[] args) {
        String[] testseet = new String[30];
        for (int i = 1, v = 1; i < 31 ; i++) {
            if ( i > 6 || i >= 8 ){
                System.out.println("\t"+ v);
                v++;
            } else {
                System.out.print("\t" + v);
                v++;
            }
        }
    }
}
