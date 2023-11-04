package study;

public class Test {
    public void kkk() throws InterruptedException {
        int[] a = new int[3];
        try {
            a[0] = 0;
            a[1] = 10/a[0];
            a[2] = 50;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("아");
//            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("프");
//            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("다");
//            e.printStackTrace();
        } finally {
            System.out.println("finally");
            System.out.println(" >> " + a[0] + a[1] + a[2]);
        }
        kkk2();
    }

    private void kkk2() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        System.out.println("I'am kkk2()");
        for (int i = 1; i < 5; i++) {
            System.out.println(i + "초");
            Thread.sleep(1000);
        }
    }
}
