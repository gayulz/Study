import java.util.Scanner;
class Main {
    public int solution(String str) {
        String tmpStr = str.replaceAll("[a-zA-Z]","");
        int answer = Integer.parseInt(tmpStr);
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(T.solution(str));
    }
}