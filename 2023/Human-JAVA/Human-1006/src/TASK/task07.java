package TASK;

public class task07 {
    public static void main(String[] args) {
        int[] carnum = {1232,1221,1235,1252,1234,4536,3457,3238,3229,2599};
        int[] parking = new int[10];
        int carTagget = 0;

        for (int i = 0; i < carnum.length; i++) {
            carTagget = carnum[i]%10;
            if(parking[carTagget] == 0 ) {
                parking[carTagget] = carnum[i];
            } else {
                if (carTagget+1!=parking.length) parking[carTagget+1] = carnum[i];
                else parking[(carTagget+1)%10] = carnum[i];
            }
        }
        for (int i = 0; i < parking.length; i++) {
            System.out.println(i + "번 주차칸 차량 정보 : " + parking[i]);
        }
    }
}
