package Chapter_List;
import java.util.Scanner;

public class chapter_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();
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
    }
}
