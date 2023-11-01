package test;

public class Main {
    public static void main(String[] args) {
        user n = new user();
        System.out.println(n.add(3,3));

//        String userName = "김가율";
//        String userAdd = "수원시";
//        int age = 32;
//
//        String userName1 = "김땡땡";
//        String userAdd1 = "용인시";
//        int age1 = 32;
//
//        String userName2 = "김모씨";
//        String userAdd2 = "서울시";
//        int age2 = 33;
//
//
        System.out.println(n.users("김가율", "수원시", 32, "영화"));
        System.out.println(n.users("김땡땡", "서울시", 32, "애니"));
        System.out.println(n.users("김모씨", "용인시", 32, "놀기"));
    }
}
