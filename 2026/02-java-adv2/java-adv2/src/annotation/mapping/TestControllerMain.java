package annotation.mapping;

import java.lang.reflect.Method;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 17.
 * @fileName : TestControllerMain
 */
public class TestControllerMain {
    public static void main(String[] args) {
        TestController testController = new TestController();
        Class<? extends TestController> aClass = testController.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for(Method m : declaredMethods){
            SimpleMapping annotation = m.getAnnotation(SimpleMapping.class);
            if (annotation != null) {
                System.out.println("[" + annotation.value() + "] -> " + m );
            }
        }
    }
}
