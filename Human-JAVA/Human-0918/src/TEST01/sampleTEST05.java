package TEST01;

public class sampleTEST05 {
    public static void main(String[] args) {
        // int typeFlag = 47;
        // 3의 배수이면서 5의 배수이면 현재 저장된 값을 출력하시오

        int typeFlag = 15;
        if ((typeFlag % 3 == 0) && (typeFlag % 5 == 0)) {
            System.out.println(typeFlag + "는 3의 배수 && 5의 배수가 맞습니다 ");
        }
        else { System.out.println(typeFlag + "는 3의 배수 && 5의 배수가 아닙니다 ");
        }
    }
}
