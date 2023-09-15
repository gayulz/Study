import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Scanner;

/* PC 카톡에서 모르는 사람들을 개별적인 삭제가 어려워
 * 자동으로 삭제하는 메크로 소스코드를 짜봤습니다
 * 아직 JAVA 초보라 많이 미숙하지만
 * 더 좋은 개발자가 되도록 노력하겠습니다 !
 * 많은 피드백 부탁드려용
 */

public class Delete_friend {
    public static void main(String[] args) {

        // 특정 키 입력시 종료됨
        Scanner scer = new Scanner(System.in);
        System.out.println("삭제할 사람들의 숫자를 입력하세요.\n");
        System.out.println("딱 그만큼만 삭제 후 종료 됩니다 : ");
        int num = scer.nextInt();  // 정수 입력
        int zero = 0;

        while (zero < num)
        {
            try {
                Robot rb = new Robot();
                rb.mouseMove(2334,930);     // 삭제원하는 친구 이름 좌표입력
                rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);    // 해당 좌표 클릭
                rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);    // 떼기
                rb.mousePress(InputEvent.BUTTON3_DOWN_MASK);    // 우측 클릭
                rb.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);   // 우클릭 해제
                Thread.sleep(500); // 0.5 초기다림
                rb.mouseMove(2388,942);     // 채팅하기로 이동
                rb.mouseMove(2388,975);     // 밑으로 순차적 이동
                rb.mouseMove(2388,1158);     // 차단 칸으로 이동
                Thread.sleep(500); // 0.5 초기다림
                rb.mouseMove(2247, 1166);     // 메세지차단 칸으로 이동
                Thread.sleep(500); // 0.5 초기다림
                rb.mouseMove(2247, 1180);     // 메세지+프로필 칸으로 이동
                Thread.sleep(500); // 0.5 초기다림
                rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);    // 좌클릭
                rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);    // 떼기
                rb.mouseMove(2419,1185);     //확인이동
                rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);    // 좌클릭
                rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);    // 떼기
                Thread.sleep(1000); // 1 초기다림
                zero++;
            } catch (Exception exception){
                System.out.println("실패ㅜㅜ");
                break;
            }
        }
    }
}