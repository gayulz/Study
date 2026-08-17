package annotation.validator;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 17.
 * @fileName : User
 */
public class User {

    @NotEmpty(Message = "이름이 비었습니다.")
    private String name;

    @Range(min = 1, max = 100, Message = "나이는 1과 100 사이여야 합니다.")
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
