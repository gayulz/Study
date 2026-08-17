package annotation.basic;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 17.
 * @fileName : ElementDataMain
 */
public class ElementDataMain {
    public static void main(String[] args) {

        Class<ElementData1> elementData1Class = ElementData1.class;
        AnnoElement annotation = elementData1Class.getAnnotation(AnnoElement.class);

        String value = annotation.value();
        System.out.println("value = " + value);

        int count = annotation.count();
        System.out.println("count = " + count);

        String[] tags = annotation.tags();
        for (String tag : tags) {
            System.out.println("tag = " + tag);
        }
    }
}
