package thread.start;

/**
 * @author : gayul.kim
 * @date : 2026. 2. 20.
 * @fileName : HelloThreadMain
 */
public class HelloThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 전");

        helloThread.start();

        System.out.println(Thread.currentThread().getName() + ": start() 호출 후");

        System.out.println(Thread.currentThread().getName() + ": main() ❤️");
        System.out.println(Thread.currentThread().getName() + ": main() ❤️ ❤️");
        System.out.println(Thread.currentThread().getName() + ": main() ❤️ ❤️ ❤️");
        System.out.println(Thread.currentThread().getName() + ": main() ❤️ ❤️ ❤️ ❤️");
        System.out.println(Thread.currentThread().getName() + ": main() ❤️ ❤️ ❤️ ❤️ ❤️");

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }
}
