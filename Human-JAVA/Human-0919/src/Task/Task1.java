package Task;

public class Task1 {
    public static void main(String[] args) {

        //문제 1 : a가 3000 이상이면 a 에서 + 100 하고 아니면 a 에서 -100을 하시오
        int a = 4536;
        if (a >= 3000){
            a+=100;
        } else {
            a-=100;
        }
        System.out.println(a);

    }
}
