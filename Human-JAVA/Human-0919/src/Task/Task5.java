package Task;

public class Task5 {
    public static void main(String[] args) {
        //업 , 다운 게임
        int conNum = 30; // 컴퓨터 번호
        int youNum = 30; // 게임자 번호

        // 게임자 번호가 컴퓨터 번호를 비교하여 컴퓨터 번호보다 up이면 up이라고하고
        // 다운이면 다운이라고 출력하시오

        if (conNum > youNum){
            System.out.println(" 업 ");
        } else if (conNum < youNum ){
            System.out.println(" 다운 ");
        } else {
            System.out.println("정답이라우");
        }
    }
}
