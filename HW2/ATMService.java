public interface ATMService {
    void checkBalance(String accountID);
    void withdraw(String accountID);
    void deposit(String accountID);
    void transfer(Account_Bank sourceAccount);
    void exit();
}
