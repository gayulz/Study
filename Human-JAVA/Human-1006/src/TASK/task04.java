package TASK;

public class task04 {
    public static void main(String[] args) {
        int[] arr = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
        double avg = 0;

        for (int i = 0; i < arr.length; i++) {
            avg += (double)arr[i];
        }

        System.out.println(avg/arr.length);
    }
}
