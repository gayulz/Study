package Study;

public class Study01 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            if (i%2==0) {
                sum+=i;
                continue;
            }
        }
        System.out.println(sum);
    }
}
