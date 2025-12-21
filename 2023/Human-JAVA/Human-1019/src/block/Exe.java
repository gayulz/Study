package block;
import java.util.Scanner;

public class Exe {
    Scanner in = new Scanner(System.in);
    // 생성자
    public Exe() {
        boolean flag = true;
        while (flag) {
            String choice = info();
            if (choice.equals("1")) new MemoryTest();
            else if (choice.equals("2"))  new InfiniteGame();
            else {
                flag = false;
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    // 시작 멘트
    public String info () {
        System.out.println(" ▉▉▉▉   ▉   ▉   ▉ ▉▉▉▉▉  ▉   ▉ ▉▉▉▉▉ ▉   ▉ ▉   ▉" + "ニ|∧,,∧\n" +
                "▉      ▉ ▉  ▉▉ ▉▉ ▉      ▉▉ ▉▉ ▉     ▉▉  ▉ ▉   ▉" + "ニ(・ω・;）\n" +
               "▉ ▉▉  ▉▉▉▉▉ ▉ ▉ ▉ ▉▉▉▉▉  ▉ ▉ ▉ ▉▉▉▉▉ ▉ ▉ ▉ ▉   ▉" + "ニと　 )\n"+
                "▉   ▉ ▉   ▉ ▉   ▉ ▉      ▉   ▉ ▉     ▉  ▉▉ ▉   ▉"+"ニと_ノ\n"+
                " ▉▉▉  ▉   ▉ ▉   ▉ ▉▉▉▉▉  ▉   ▉ ▉▉▉▉▉ ▉   ▉  ▉▉▉"+"ニ|\n");
        System.out.println("\t⓵ 게임은 총 2개 입니다\n\t\t☞ 1. 단기기억력 TEST영단어 게임\t☞ 2. 무한 영단어 깨기 ");
        System.out.println("\t⓶ MENU 화면에서 프로그램 종료 시 [ 3 ] 입력해 주세요");
        System.out.println("\t⓷ 게임 플레이 중 종료 희망시 [ Q ] 입력해 주세요 ");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════\n");
        System.out.print(" Player ⌦ ⌦  ");
        String userRetrun = in.nextLine();
        return userRetrun;
    }
}
