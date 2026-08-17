package thread.sync;

/**
 * @author : gayul.kim
 * @date : 2026. 6. 2.
 * @fileName : WithdrawTask
 */
public class WithdrawTask implements Runnable{

    private BankAccount bankAccount;
    private int amount;

    public WithdrawTask(BankAccount bankAccount, int amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        bankAccount.withdraw(amount);
    }
}
