package test;

public class test {
    public static void main(String[] args) {
        int times = 20;
        int cost1 = 10000;
        int cost2 = 30000;
        int cost3 = 60000;
        int daycost1 = 40000;
        int daycost2 = 60000;
        int daycost3 = 80000;

        int subtime=times-24;

        if (subtime >= 24 ) System.out.println(times-24);
        else if (!(times % 24 == 0) || times >= 24) System.out.println((times-24)*cost1+daycost1);
        else System.out.println(cost1);
    }
}
