public class Main {
    public static void main(String [] args){
        Manager manager = new Manager(null, null, null, null, null);
        manager.createManager();

        Account_Bank account_Bank = new Account_Bank("", "",0,"","","");
        
        account_Bank.createAccount();
        
        ATM atm = new ATM(); 
        atm.detail();

    }
}
