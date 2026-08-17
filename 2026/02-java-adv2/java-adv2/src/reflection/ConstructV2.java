package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 15.
 * @fileName : ConstructV1
 */
public class ConstructV2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 클래스 정보를 동적 조회 (메타데이터 조회)
        Class<?> aClass = Class.forName("reflection.data.BasicData");
        // 해당 클래스의 생성자를 조회
        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class);

        // private 생성자 접근 허용 옵션
        constructor.setAccessible(true);

        // 찾은 생성자를 사용해 객체 생성
        Object instance = constructor.newInstance("hello");
        System.out.println("instance = " + instance);

        // 해당 인스턴스에 call 이라는 이름의 메서드를 동적으로 찾아 호출
        Method method1 = aClass.getDeclaredMethod("call");
        method1.invoke(instance);
    }

}
