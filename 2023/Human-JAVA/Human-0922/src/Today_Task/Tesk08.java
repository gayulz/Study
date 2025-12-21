package Today_Task;

public class Tesk08 {
    public static void main(String[] args) {
        // 문제 8번 : 코드를 분석하여 a문자열에 a가 몇개 있는지 구하는 프로그램을 작성하세요


        String test = "abcdeabce";
        int cnt = 0;
        for (int i = 0; i < test.length(); i++) {
            char aaa=test.charAt(i);
            if (aaa == 'a') {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
