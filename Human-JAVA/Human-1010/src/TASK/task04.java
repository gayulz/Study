package TASK;

public class task04 {
    public static void main(String[] args) {
        int[] p = {40, 32, 21, 7};
        int[] restList = {2, 1, 0, 3};

        int totalTime = 0; // 총 소요 시간
        int maxEatTime = 2; // 쉬는 시간에 먹을 수 있는 최대 사탕 개수

        for (int i = 0; i < p.length; i++) {
            int candiesToEat = p[i]; // 현재 사람이 소유한 사탕 개수

            while (candiesToEat > 0) {
                // 현재 사람이 먹을 수 있는 사탕 개수를 구함
                int eatCount = Math.min(maxEatTime, candiesToEat);

                // 현재 사람이 먹을 시간을 더하고
                totalTime += eatCount;

                // 남은 사탕 개수를 업데이트
                candiesToEat -= eatCount;

                // 현재 사람이 모든 사탕을 다 먹었으면 대기 시간 추가
                if (candiesToEat == 0) {
                    totalTime += restList[i];
                }
            }
        }

        System.out.println("0번 사람이 사탕을 모두 먹기 위해 필요한 시간: " + totalTime);
    }
}
