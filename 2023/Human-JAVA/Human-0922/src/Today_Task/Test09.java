package Today_Task;

public class Test09 {
    public static void main(String[] args) {
        /*
        문제 9 : 어떤 자연수 n이 있을때, d(n)을 n의 각 자릿수 숫자들과 n 자신을 더한 숫자라고 정의하자
        예를 들어, d(91) = 9 + 1 + 91 = 101
        이때 , n을 d(n)의 제너레이터(generator)라고 한다, 위의 예시에서 91은 101의 제너레이터이다
        어떤 숫자들은 하나 이상의 제너레이터를 가지고 있는데
        101의 제너레이터는 91 뿐만 아니라 100도 있다.
        그런데 반대로, 제너레이터가 없는 숫자들도 있으며 이런 숫자들을 인도의 수학자 Kapreka가 셀프넘버(self-nember)라 이름 불렀다
        예를들어 1.3.5.7.9.20.31은 셀프 넘버들이다
        1 이상이고 5000 보다 작은 모든 셀프 넘버들의 합을 구하라
        */

        int tot = 0;
        int bIn = 0;
        for (int i = 1; i <= 5000; i++) {
            for (int j = 0; j <=i ; j++) {
                int num1000 = j/1000;
                int num100 = (j%1000)/100;
                int num10 = ((j%1000)%100)/10;
                int num1 = ((j%1000)%100)%10;
                int sigleNum = num1+num10+num100+num1000+j;
                if (i == sigleNum) {
                    bIn = sigleNum;
                }
            }
            if ( i != bIn ){
                tot+=i;
                System.out.println(i);
            }
        }
        System.out.println(tot);
    }
}
