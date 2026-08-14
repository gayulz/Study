package reflection;

import reflection.data.User;

import java.lang.reflect.Field;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 14.
 * @fileName : FieldV2
 */
public class FieldV2 {
    /*
    * setAccessible(true / false)
    * true시 private 변수에 변경을 진행 할 수 있다.
    * 하지만 이는 객체 지향 프로그래밍의 원칙을 위한하는 행위로 간주된다.
    * 'private' 접근 제어자는 클래스 내부에서만 데이터를 보호하고 외부에서의 직접적인 접근을 방지하기 위해 사용 된다.
    * 리플렉션을 통해 이러한 접근 제한을 무시하는 것은 캡슐화 및 유지보수성에 악영향을 미칠 수 있다.
    *
    * 리플렉션을 사용 시 반드시 신중하게 접근해야하며
    * 가능한 경우 접근 메서드(getter, setter)를 사용하는 것이 바람직함
    * 리플렉션은 주로 테스트나 라이브러리 개발 같은 특별한 상황에서 유용하게 사용된다.
    * 일시적인 애플리케이션 코드에선 미권장.
    * 무분별하게 사용되면 코드의가독성 저하, 안정성을 크게 저하시킨다.
    */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User("id1", "userA", 20);
        System.out.println("기존 이름: " + user.getName());

        Class<? extends User> aClass = user.getClass();
        Field nameField = aClass.getDeclaredField("name");

        // private 필드에 접근 허용, private 메서드도 이렇게 호출 가능함
        nameField.setAccessible(true);
        nameField.set(user, "userB");
        System.out.println("변경된 이름: " + user.getName());
    }
}
