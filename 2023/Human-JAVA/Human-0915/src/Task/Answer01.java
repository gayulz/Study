package TEST;

public class Answer01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        int num3 = 30;
        System.out.println(num1+num2+num3);
        int[] num4 = {10, 20, 30};
        int sum = 0;

        for (int i = 0; i < num4.length; i++) {
            sum += num4[i];
        }
        System.out.println(sum);
    }
}
