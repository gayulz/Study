package Study;

public class Study01 {
    public static void main(String[] args) {
        String test = "aaamvvccm";
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            char aaa = test.charAt(i);
            if (aaa == 'm') {
                cnt++;
                System.out.println(" m 의 위치 : " + i);
            }
        }
        System.out.println(" m 의 갯수 : " + cnt + "개 입니다.");
        System.out.println(test);
    }
}
