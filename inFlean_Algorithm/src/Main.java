import java.util.Scanner;

public class Main {
    public String solution(int cnt){
        Scanner in = new Scanner(System.in);
        String answer="";
        String[] task = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            task[i] = in.next();
            StringBuffer taskrevers = new StringBuffer(task[i]);
            String revers = taskrevers.reverse().toString();
            task[i] = revers;
        }

        for (int i = 0; i < cnt; i++) {
            System.out.println(task[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();
        System.out.println(T.solution(cnt));
    }
}
