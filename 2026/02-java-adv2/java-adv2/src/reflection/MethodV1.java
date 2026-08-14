package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Method;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 14.
 * @fileName : MethodV1
 */
public class MethodV1 {
    /* 메서드 메타데이터 정보 확인 방법*/
    public static void main(String[] args) {
        Class<BasicData> helloClass = BasicData.class;

        System.out.println("================== Method ==================");
        Method[] methods = helloClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }
        System.out.println();
        /*
        * getMethods() : 해당 클래스와 상위 클래스에서 상속된 모든 public 메서드를 반환한다.
        * getDeclaredMethods() : 해당 클래스에서 선언된 모든 메서드를 반환, 접근 제어자에 관계 없이 반환 / 단 상속된 메서드는 미포함
        * */

        System.out.println("================== declaredMethods() ==================");
        Method[] declaredMethods = helloClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod);
        }
    }
}
