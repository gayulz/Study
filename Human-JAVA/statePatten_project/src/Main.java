import controller.RemoteControl;

public class Main extends RemoteControl {
//    public static void main(String[] args) {
//        new RemoteControl();
//    }


    public static void main(String[] args) {
        // todo : test

        String number = "010r2222s2323";

        String tempNum = number.replaceAll("[^0-9]","");

        System.out.println(tempNum);

    }
}