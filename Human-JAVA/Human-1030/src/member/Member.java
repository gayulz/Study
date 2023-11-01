package member;

public class Member {
    // Member Class 추상화
    // 접근제어자
    private String name = null;
    private int age = 0;

    // 생성자
    public Member(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // name변수의 값을 유효성을 체크하여 값을 저장할 것인지 안할것인지 판단

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
