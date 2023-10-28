package study;

public class SingleTone {

    private static SingleTone address;
    private static String name;
    // 생성자는 외부에서 호출못하게 private 으로 지정해야 한다.
    private SingleTone() {
    }

    public static SingleTone getAddress(){
        if (address == null) {
            address = new SingleTone();
            name = "이건 초기값이다";
        }
        return address;
    }

}
