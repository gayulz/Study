package annotation.validator;

import java.lang.reflect.Field;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 17.
 * @fileName : Validator
 */
public class Validator {

    public static void validate(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();

        for(Field field : fields){
            field.setAccessible(true);

            if (field.isAnnotationPresent(NotEmpty.class)) {
                Object value = (String) field.get(obj);
                NotEmpty annotation = field.getAnnotation(NotEmpty.class);
                if (value == null || ((String) value).isEmpty()) {
                    throw new RuntimeException(annotation.Message());
                }
            }

            if (field.isAnnotationPresent(Range.class)) {
                long value = field.getLong(obj);
                Range annotation = field.getAnnotation(Range.class);
                if (value < annotation.min() || value > annotation.max()) {
                    throw new RuntimeException(annotation.Message());
                }
            }
        }
    }
}
