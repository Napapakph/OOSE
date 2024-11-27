public class Main {
    public static void main(String [] args){
        Account_Bank account_Bank = new Account_Bank(null, null);
        
        account_Bank.createAccount();
        
        ATM atm = new ATM(); 
        atm.detail();

        

    }
}
