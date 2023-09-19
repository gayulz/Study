package Task;

public class Task6 {
    public static void main(String[] args) {
        int me = 2;
        int you = 0;
        String Victory = "";
        // 1은 가위, 2는 바위, 0은 보이다
        // 가위바위보 게임의 승자를 판별하시오


        if (me == 1) {
            if (you == 0) {
                System.out.println("이긴사람 me");
            } else if (you == 1) {
                System.out.println("이긴 사람 없음");
            } else {
                System.out.println("이긴사람 you");
            }
        }

        if (me == 0)
            if (you == 0) {
                System.out.println("이긴 사람 없음");
            } else if (you == 1) {
                System.out.println("이긴사람 you");
            } else {
                System.out.println("이긴사람 me");
            }

        if (me == 2) {
            if (you == 0) {
                System.out.println("이긴사람 you");
            } else if (you == 1) {
                System.out.println("이긴사람 me");
            } else {
                System.out.println("이긴사람 없음");
            }
        }
    }
}
