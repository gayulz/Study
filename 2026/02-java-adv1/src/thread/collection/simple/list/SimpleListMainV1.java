package thread.collection.simple.list;

/**
 * @author : gayul.kim
 * @date : 2026. 7. 22.
 * @fileName : SimpleListMainV1
 */
public class SimpleListMainV1 {
    public static void main(String[] args) {
        SimpleList list = new BasicList();

        list.add("A");
        list.add("B");

        System.out.println("List = " + list);
    }
}
