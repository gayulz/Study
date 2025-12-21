package inheritance_study;

public class Study_02 extends Study_01 {
    // Study_01의 클래스를 상속받음
    static int multiply(int num1, int num2){
        return num1*num2;
    }

    static int division(int num1, int num2){
        return num1/num2;
    }

     public static int add(int num1, int num2){
        int num3 = Study_01.add(num1, num2) + 10;
        return num3;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 2;
        int c = add(a,b);


        System.out.println(add(a, b));
        System.out.println(minus(a,b));
        System.out.println(multiply(a, b));
        System.out.println(division(a, b));
        System.out.println(c);
    }
}
