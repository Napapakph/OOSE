import java.util.Scanner;

public class ATM {

    Scanner scanner = new Scanner(System.in);
    private Account_Bank[] accounts;
    private String account;
    private String password;
    private String name;
    private int balance;

    // รับ Account จากภายนอก
    // Constructor สำหรับกำหนดค่า accounts โดยเรียกใช้ getAccounts()
    public ATM() {
        this.accounts = Account_Bank.getAccounts();
    }

    public Account_Bank account_Bank = new Account_Bank(account, password, name, balance);

    public void detail() {

        if (accounts == null) { // ตรวจสอบว่า accounts มีค่าอยู่หรือไม่
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("ATM ComputerThanyaburi Bank");

        do {
            System.out.print("account ID = ");
            account = scanner.nextLine();

            // ตรวจสอบความยาวและรูปแบบ (ต้องเป็นตัวเลขทั้งหมด)
            if (account.length() != 13 || !account.matches("\\d+")) {
                System.out.println("Invalid accountID number. Please enter exactly 13 digits.");
            }
        } while (account.length() != 13 || !account.matches("\\d+"));// เช็คว่าครบ 13 หลักมั้ย

        do {
            System.out.print("Password = ");
            password = scanner.nextLine();
            if (password.length() != 4 || !password.matches("\\d+")) {
                System.out.println("Invalid accountID number.Please enter password within 4 digit");
            }
        } while (password.length() != 4 || !password.matches("\\d+"));

        // ตรวจสอบ ID และ Password
        boolean passed = false;
        for (Account_Bank accountCheck : accounts) {
            if (accountCheck.getAccountID().equals(account) && accountCheck.getPassword().equals(password)) {
                passed = true;
                break;
            }
        }

        int count_mistake = 0;
        // แสดงผลลัพธ์
        if (passed) {
            menu(account);

        } else {
            System.out.println("Account ID and Password don't match \n");
            if (count_mistake >= 3) {
                System.err.println(
                        "ERROR You entered Account ID and Password don't match 3 times, \n .\n.\n. \nlogged out");
            }
            count_mistake += 1;
            detail();
        }

    }

public void menu(String accountID) {
        System.out.println("ATM ComputerThanyaburi Bank");
            for (Account_Bank accountCheck : accounts) {
                if (accountCheck.getAccountID().equals(accountID)) {
                    accountID = accountCheck.getAccountID();
                }
            }
        System.out.println("\nAccount ID : " +accountID);
        System.out.println("Menu Service");
        System.out.println("1. Account Balance \n2. Withdrawal \n3. Exit \n");
        System.out.print("Choose : ");
        int choose = scanner.nextInt();

        switch (choose) {
            case 1:
                System.out.println("--- Account Balance ---");
                accountBalancec(account);
                break;
            case 2:
                System.out.println("--- Withdrawal ---");
                withdrawal(account);
                break;
            case 3:
                System.out.println("--- Exit ---");
                exit();
                break;
            default:
                break;
        }

    }

    public void accountBalancec(String accountID) {
        for (Account_Bank accountCheck : accounts) {
            if (accountCheck.getAccountID().equals(accountID)) {
                balance = accountCheck.getBalance();
                System.out.println("balance all = " + balance);
            }
        }
        menu();
    }

    public void withdrawal(String accountID) {
        for (Account_Bank accountCheck : accounts) {
            if (accountCheck.getAccountID().equals(accountID)) {
                balance = accountCheck.getBalance();
            }
        }
        System.out.print("Enter amount to withdraw : ");
        int amount_withdraw = scanner.nextInt();
        if (amount_withdraw > balance) {
            System.out.println("The amount is not enough. Please make a new transaction.");

        }
        balance = balance - amount_withdraw;
        System.out.println("Balance = " + balance);
    }

    public void exit() {

    }

}
