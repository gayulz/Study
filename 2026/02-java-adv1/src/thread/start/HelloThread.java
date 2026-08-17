package thread.start;

/**
 * @author : gayul.kim
 * @date : 2026. 2. 20.
 * @fileName : HelloThread
 */
public class HelloThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() +" : run() ");
        System.out.println(Thread.currentThread().getName() +" : ✅");
        System.out.println(Thread.currentThread().getName() +" : ✅ ✅");
        System.out.println(Thread.currentThread().getName() +" : ✅ ✅ ✅");
        System.out.println(Thread.currentThread().getName() +" : ✅ ✅ ✅ ✅");
        System.out.println(Thread.currentThread().getName() +" : ✅ ✅ ✅ ✅ ✅");
    }
}
