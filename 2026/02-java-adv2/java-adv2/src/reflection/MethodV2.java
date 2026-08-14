package reflection;

import reflection.data.BasicData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 14.
 * @fileName : MethodV2
 */
public class MethodV2 {
    /*
    * 동적 메서드 호출
    * */

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 정적 메서드 호출 : 일반적인 호출
        // 이 방식은 코드를 수정하지 않는 이상 call() 대신 다른 메서드로 변경하는 것이 불가
        BasicData helloInstance = new BasicData();
        helloInstance.call();

        System.out.println();
        // 동적 메서드 호출 : 리플렉션 사용
        // methodName은 변수, 예를 들어 사용자 콘솔 입력을 통해 얼마든지 호출할 methodName을 변경할 수 있음
        Class<? extends BasicData> helloClass = helloInstance.getClass();
        String methodName = "hello";

        // 메서드 이름을 변수로 변경할 수 있다
        Method method1 = helloClass.getDeclaredMethod(methodName, String.class);
        Object returnValue = method1.invoke(helloInstance, "hi");
        System.out.println("returnValue = " + returnValue);
    }
}
