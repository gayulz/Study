package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Field;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 14.
 * @fileName : FieldV1
 */
public class FieldV1 {
    /*
    * 리플렉션을 활용해 필드를 탐색하고 필드 값을 변경 활용
    * fields() : 해당 클래스와 상위 클래스에서 상속된 모든 public 필드를 반환
    * declaredFileds() : 해당 클래스에서 선언된 모든 필드를 반환하며, 접근 제어자에 관계없이 반환 / 단 상속된 필드는 미포함
    * */
    public static void main(String[] args) {
        Class<BasicData> helloClass = BasicData.class;

        System.out.println("============ fields() ============");
        Field[] fields = helloClass.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }

        System.out.println();
        System.out.println("============ declaredFields() ============");
        Field[] declaredFields = helloClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("field = " + field);
        }
    }
}
