package study;

public class Main {
    public static void main(String[] args) {
        // TODO : 호랑이를 관리하는 샘플 코드
        Tiger[] p = new Tiger[5];
        Tiger t = new Tiger();
        t.tigerName = "호돌이";
        t.tigerAge = 3;
        p[0] = t;
        t = new Tiger();
        p[1] = t;
        t.tigerName = "abc";
        System.out.println(p[0].tigerName);
        System.out.println(p[1].tigerName);
        System.out.println(t.tigerName);
        p[2] = new Tiger();
        p[2].tigerName = "ccc";
        p[3] = p[2];
        t = null;
        p[1] = null;
//        System.out.println(t.tigerName);
        System.out.println(p[0].tigerName);
//        System.out.println(p[1].tigerName);
        System.out.println(p[2].tigerName);
        String a = new String("aaa");
        System.out.println(a);
    }
}
