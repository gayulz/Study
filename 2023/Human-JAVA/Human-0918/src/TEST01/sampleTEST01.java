package TEST01;

public class sampleTEST01 {
    public static void main(String[] args) {
        // 문제 1
        // int point = 89
        // 40 점 미만이면 과락, 60점 미만이면 불합격, 60점 이상이면 합격이라고 출력하시오

        int point = 30;

        if (point >= 60) {
            System.out.println("합격");
        }
        else if (point <= 60 && point >= 40 ) // 60점 미만, 40점 이상
        {
            System.out.println("불합격 ");
        }
        else {
            System.out.println("과락");
        }
    }
}
