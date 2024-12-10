import java.util.Scanner;

public class ATM implements ATMService {
    private Scanner scanner = new Scanner(System.in);
    private Account_Bank[] accounts;
    private String account;
    private String password;
    private String fullName;
    private String idCard;
    private String gender;
    private double balance;
    private int count_mistake = 0;

    // รับ Account จากภายนอก
    // Constructor สำหรับกำหนดค่า accounts โดยเรียกใช้ getAccounts()
    public ATM() {
        this.accounts = Account_Bank.getAccounts();

    }

    public Account_Bank account_Bank = new Account_Bank(account, password, balance,idCard,fullName,gender);


    public void detail() {

        System.out.println("ATM ComputerThanyaburi Bank");

        boolean found = false;
        do {
            System.out.print("account ID = ");
            account = scanner.nextLine();

            // ตรวจสอบความยาวและรูปแบบ (ต้องเป็นตัวเลขทั้งหมด)
            if (account.length() != 13) {
                System.out.println(" Please enter exactly 13 digits.");
                
                continue;
            }

            if (!account.matches("\\d+")) {
                System.out.println("Invalid accountID number");
                continue;
            }

            // ตรวจสอบว่า accountID มีอยู่ในระบบหรือไม่
            for (Account_Bank accountCheck : accounts) {
                if (accountCheck.getAccountID().equals(account)) {
                    found = true;
                    break; // เจอ account แล้ว หยุดการวนลูป
                }
            }

            if (!found) {
                System.out.println("Account ID not found in the Account of Bank.");
                continue; // ย้อนกลับไปเริ่มลูปใหม่
            }
            break;

            
        }while(true);

    do{
        System.out.print("Password = ");
        password = scanner.nextLine();
        if (password.length() != 4) {
            System.out.println("Please enter password within 4 digit");
            continue;
        }
            if (!password.matches("\\d+")) {
                System.out.println("Invalid password number.");
                continue;
            }
        break;
            
        
    }while(true);

    // ตรวจสอบ ID และ Password
    boolean passed = false;
    for(Account_Bank accountCheck:accounts)
    {
        if (accountCheck.getAccountID().equals(account) && accountCheck.getPassword().equals(password)) {
            passed = true;
            break;
        }
    }

    // แสดงผลลัพธ์
    if(passed)
    {
        menu(account);
        count_mistake = 0;

    }else
    {
        System.out.println("Account ID and Password don't match \n");
        if (count_mistake == 2) { // 3 ครั้ง
            System.err.println(
                    "ERROR You entered Account ID and Password don't match 3 times, \n.\n.\n. \nlogged out");
            System.exit(0); // หยุดการทำงานของโปรแกรมทั้งหมด
        }
        count_mistake += 1;
        detail();
    }

    }

    public void menu(String accountID) {
        System.out.println("\nATM ComputerThanyaburi Bank");

        Account_Bank sourceAccount = null;

        for (Account_Bank accountCheck : accounts) {
            if (accountCheck.getAccountID().equals(accountID)) {
                accountID = accountCheck.getAccountID();
                fullName = accountCheck.getFullName(); 
                sourceAccount = accountCheck;

            }
        }

        System.out.println("Account ID : " + sourceAccount.getAccountID());
        System.out.println("Fullname : " + sourceAccount.getFullName());

        System.out.println("\nMenu Service");
        System.out.println("1. Account Balance \n2. Withdrawal \n3. depositeable \n4. tranferable\n5. Exit \n");
        System.out.print("Choose : ");
        int choose = scanner.nextInt();

        switch (choose) {
            case 1:
                System.out.println("--- check Balnace ---");
                checkable(sourceAccount.getAccountID());
                break;
            case 2:
                System.out.println("--- Withdrawal ---");
                withdrawalable(sourceAccount.getAccountID());
                break;
            case 3:
                System.out.println("--- deposite ---");
                depositeable(sourceAccount.getAccountID());
                break;
            case 4:
                System.out.println("--- tranfer ---");
                tranferable(sourceAccount);
                break;
            case 5:
                System.out.println("--- Exit ---");
                exitable();
                break;
            default:
                break;
        }

    }
    @Override
    public void checkable(String accountID) {
        for (Account_Bank accountCheck : accounts) {
            if (accountCheck.getAccountID().equals(accountID)) {
                balance = accountCheck.getBalance();
                System.out.println("balance all = " + balance);
            }
        }
        System.out.println("-----------------------");
        menu(accountID);
    }

    @Override
    public void withdrawalable(String accountID) {
        Account_Bank sourceAccount = null;
        for (Account_Bank accountCheck : accounts) {
            if (accountCheck.getAccountID().equals(accountID)) {
                sourceAccount = accountCheck;
                break;
            }
        }
        System.out.print("Enter amount to withdraw : ");
        int amount_withdraw = scanner.nextInt();
        if (amount_withdraw > sourceAccount.getBalance()) {
            System.out.println("The amount is not enough. Please make a new transaction.");

        }
        // อัปเดตยอดเงิน
        sourceAccount.setBalance(sourceAccount.getBalance() - amount_withdraw);
        System.out.println("Balance = " + sourceAccount.getBalance());
        System.out.println("-----------------------");
        menu(accountID);
    }
    
    @Override
    public void depositeable(String accountID){
            Account_Bank sourceAccount = null;

            for (Account_Bank accountCheck : accounts) {
                if (accountCheck.getAccountID().equals(accountID)) {
                    sourceAccount = accountCheck;
                    break;
                }
            }

        System.out.print("Enter amount to deposite : ");
        int amount_deposite = scanner.nextInt();
        // อัปเดตยอดเงิน
        sourceAccount.setBalance(sourceAccount.getBalance() + amount_deposite);
        System.out.println("Balance = " + sourceAccount.getBalance());
        System.out.println("-----------------------");
        menu(accountID);
    }

    @Override
    public void tranferable(Account_Bank sourceAccount){
        System.out.println("Account List !");
        // แสดงบัญชีทั้งหมดใน Array
        for(Account_Bank accountCheck:accounts){
            System.out.println(accountCheck.getAccountID()+" : "+ accountCheck.getFullName());
        }
        
        System.out.println("\nPlease choose account to Tranfer Money");

        Account_Bank destinationAccount = null;
        do {
            scanner.nextLine(); 
            System.out.print("account ID = ");
            String destinationAccountID = scanner.nextLine();

            // ตรวจสอบความยาวและรูปแบบ (ต้องเป็นตัวเลขทั้งหมด)
            if (destinationAccountID.length() != 13) {
                System.out.println(" Please enter exactly 13 digits.");
                continue;
            }

            if (!destinationAccountID.matches("\\d+")) {
                System.out.println("Invalid accountID number");
                continue;
            }

                // ตรวจสอบว่า accountID มีอยู่ในระบบหรือไม่
            for (Account_Bank accountCheck : accounts) {
                if (accountCheck.getAccountID().equals(destinationAccountID)) {
                    destinationAccount = accountCheck;
                    break;
                }
            }

                // ตรวจสอบว่าไม่ใช่บัญชีต้นทาง
            if (destinationAccount == sourceAccount) {
                System.out.println("You cannot transfer money to the same account. Please try again.");
                continue;
            }

            break;
        }while(true);

        System.out.print("Enter Amount to Transfer: ");
        double amount = scanner.nextDouble();

            // ตรวจสอบยอดเงินในบัญชีต้นทาง
        if (sourceAccount.getBalance() < amount) {
            System.out.println("Insufficient funds. Transfer cancelled.");
            return;
        }

        // ทำการโอนเงิน
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);

        System.out.println("\nTransfer Successful!");
        System.out.println("Balance of " + sourceAccount.getAccountID() + " = " + sourceAccount.getBalance());
        System.out.println("Balance of " + destinationAccount.getAccountID() + " = " + destinationAccount.getBalance());
        System.out.println("-----------------------");
        menu(sourceAccount.getAccountID());
    }

    @Override
    public void exitable() {
        System.exit(0); // หยุดการทำงานของโปรแกรมทั้งหมด
    }


}
