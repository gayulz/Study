package TASK;
public class task08 {
    public static void main(String[] args) {
        int[] carnum = {1232, 1221, 1235, 1251, 1234, 4536, 3457, 3238, 3229, 2599};
        int[] parking = new int[10];
        boolean[] flag = new boolean[10];
        int carTagget = 0;

        for (int i = 0; i < carnum.length; i++) {
            // 차량 끝 번호 가져오기 ( 주차칸 번호 )
            carTagget = carnum[i] % 10;

            // 해당 번호가 false 라면 (빈칸)이라면
            if (flag[carTagget] == false) {
                parking[carTagget] = carnum[i];
                flag[carTagget] = true;
            }

            // 기존 주차가 된 칸이라면
            else if (flag[carTagget] == true) {

                // 타겟번호가 9일 경우 1을 더해 10을 만든 뒤 뒤에있는 번호를 가져와 주차칸에 넣는다
                if (carTagget+1 == carnum.length ){
                    parking[(carTagget+1) % 10] = carnum[i];
                }

                // 타겟번호가 9 가 아니고 기존 주차칸의 다음칸이 비어있을 경우
                else if (flag[carTagget+1] == false) {
                    parking[carTagget+1] = carnum[i];
                    flag[carTagget+1] = true; }

                else
                // 모두 안되어 주차 실패할 경우 출력
                {
                    System.out.println("차량번호 [" + carnum[i] + "] 는 주차불가 입니다 ");
                }
            }
        }
        for (int i = 0; i < parking.length; i++) {
            System.out.println(i + "번 주차칸 차량 정보 : " + parking[i]);
        }
    }
}
