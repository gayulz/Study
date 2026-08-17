package reflection;

import java.lang.reflect.Field;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 15.
 * @fileName : FieldUtil
 */
public class FieldUtil {

    /*
    * String 이 null 이면  " " 빈 문자로 변경
    * Integer 가 null 이면 0 으로 변경
    * 어떤 객체든 받아서 기본 값을 적용하는 유틸리티 클래스
    * */
    public static void nullFieldToDefault(Object target) throws IllegalAccessException{
        Class<?> aClass = target.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for(Field field : declaredFields){
            field.setAccessible(true);
            if (field.get(target) != null) {
                continue;
            }

            if (field.getType() == String.class) {
                field.set(target, "");
            } else if(field.getType() == int.class){
                field.set(target, 0);
            }
        }
    }
}
