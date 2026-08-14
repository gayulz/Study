package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 14.
 * @fileName : BasicV2
 */
public class BasicV2 {
    /* 클래스 메타데이터로 어떤 일을 할 수 있을 까 ? */

    public static void main(String[] args) {
        Class<BasicData> basicDataClass = BasicData.class;
        System.out.println("basicDataClass.getName() = " + basicDataClass.getName());
        System.out.println("basicDataClass.getSimpleName() = " + basicDataClass.getSimpleName());
        System.out.println("basicDataClass.getPackage() = " + basicDataClass.getPackage());
        System.out.println("basicDataClass.getSuperclass() = " + basicDataClass.getSuperclass());
        System.out.println("basicDataClass.getInterfaces() = " + Arrays.toString(basicDataClass.getInterfaces()));
        System.out.println("basicDataClass.isInterface() = " + basicDataClass.isInterface());
        System.out.println("basicDataClass.isEnum() = " + basicDataClass.isEnum());
        System.out.println("basicDataClass.isAnnotation() = " + basicDataClass.isAnnotation());

        System.out.println("=======================================================");
        int modifiers = basicDataClass.getModifiers();
        System.out.println("modifiers = " + modifiers);
        System.out.println("Modifier.isPublic(modifiers) = " + Modifier.isPublic(modifiers));
        System.out.println("Modifier.toString(modifiers) = " + Modifier.toString(modifiers));
    }

}
