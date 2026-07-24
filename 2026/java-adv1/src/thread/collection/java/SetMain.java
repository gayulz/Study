package thread.collection.java;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author : gayul.kim
 * @date : 2026. 7. 22.
 * @fileName : SetMain
 */
public class SetMain {
    public static void main(String[] args) {

        Set<Integer> copySet = new CopyOnWriteArraySet<>();
        copySet.add(1);
        copySet.add(2);
        copySet.add(3);
        System.out.println("copySet = " + copySet);


        Set<Object> skipSet = new ConcurrentSkipListSet<>(copySet);
        skipSet.add(1);
        skipSet.add(2);
        skipSet.add(3);
        System.out.println("skipSet = " + skipSet);
    }
}
