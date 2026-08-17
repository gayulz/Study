package thread.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

/**
 * @author : gayul.kim
 * @date : 2026. 6. 2.
 * @fileName : BankAccountV1
 */
public class BankAccountV5 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();
    public BankAccountV5(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

        try {
            if(!lock.tryLock(500, TimeUnit.MILLISECONDS)) {
                log("[진입 실패] 이미 처리중인 작업이 있습니다.");
                return false;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            log("[검증 시작] 출금액 : " + amount + ", 잔액 : " + balance);

            if (balance < amount) {
                log("[검증 실패] 출금액 : " + amount + ", 잔액 : " + balance);
                return false;
            }

            // 잔고가 출금액 보다 많으면 진행
            log("[검증 완료] 출금액 : " + amount + ", 잔액 : " + balance);
            sleep(1000); // 출금에 걸리는 시간으로 가정
            balance = balance - amount;
            log("[출금 완료] 출금액 : " + amount + ", 잔액 : " + balance);
        } finally {
            lock.unlock(); // lock을 걸면 반드시 unlock을 호출한뒤 해제
        }

        log("거래 종료: " + getClass().getSimpleName());
        return true;
    }

    @Override
    public int getBalance() {

        lock.lock();
        try{
            log("잔액 : " + balance);
            return balance;
        } finally {
            lock.unlock(); // lock을 걸면 반드시 unlock을 호출한뒤 해제
        }
    }
}
