package thread.sync;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

/**
 * @author : gayul.kim
 * @date : 2026. 6. 2.
 * @fileName : BankMain
 */
public class BankMain {
    public static void main(String[] args) throws InterruptedException {
//        BankAccountV1 account = new BankAccountV1(1000);
//        BankAccountV2 account = new BankAccountV2(1000);
//        BankAccountV3 account = new BankAccountV3(1000);
//        BankAccountV4 account = new BankAccountV4(1000);
        BankAccountV5 account = new BankAccountV5(1000);


        Thread t1 = new Thread(new WithdrawTask(account, 800), "t1");
        Thread t2 = new Thread(new WithdrawTask(account, 800), "t2");
        sleep(500);
        t1.start();
        t2.start();

        log("t1 state: " + t1.getState());
        log("t2 state: " + t2.getState());

        t1.join();
        t2.join();

        log("최종 잔액: " + account.getBalance());
    }
}
