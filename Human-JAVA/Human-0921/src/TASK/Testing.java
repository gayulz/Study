package TASK;

public class Testing{
    public static void main(String[] args) {
        int sum = 0, junjun = 0, jun = 0, pi=1;

        for (int i = 1; i < 8; i++) {
            sum = sum+pi;
            System.out.print(pi + " + ");
            junjun = jun;
            jun = pi;
            pi = junjun + jun;
        }
        System.out.println(sum);
    }
}
