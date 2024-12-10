public interface ATMService {
    void checkable(String accountID);
    void withdrawalable(String accountID);
    void depositeable(String accountID);
    void tranferable(Account_Bank sourceAccount);
    void exitable();
}
