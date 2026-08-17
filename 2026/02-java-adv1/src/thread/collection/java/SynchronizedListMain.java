package thread.collection.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author : gayul.kim
 * @date : 2026. 7. 22.
 * @fileName : SynchronizedListMain
 */
public class SynchronizedListMain {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("DATA-1");
        list.add("DATA-2");
        list.add("DATA-3");
        System.out.println(list.getClass());
        System.out.println("List : " + list);
    }
}
