package thread.sync;

/**
 * @author : gayul.kim
 * @date : 2026. 6. 2.
 * @fileName : BankAccount
 */
public interface BankAccount {

    boolean withdraw(int amount);

    int getBalance();
}
