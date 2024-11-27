import java.util.Scanner;

public class ATM {

    Scanner scanner = new Scanner(System.in);
    private Account_Bank[] accounts;

    // รับ Account จากภายนอก
    // Constructor สำหรับกำหนดค่า accounts โดยเรียกใช้ getAccounts()
    public ATM() {
        this.accounts = Account_Bank.getAccounts(); 
    }

    public void detail() {

        if (accounts == null) { // ตรวจสอบว่า accounts มีค่าอยู่หรือไม่
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("ATM ComputerThanyaburi Bank");
        String account;
        String password;

        do {
            System.out.print("accountID ID = ");
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

        // แสดงผลลัพธ์
        if (passed) {
            System.out.println("Menu Service");
            System.out.println("1. Account Balance \n2. Withdrawal \n3. Exit \n");

            System.out.print("Choose");
            int choose = scanner.nextInt();

        } else {
            System.out.println("Invalid ID or Password.");
        }

    }

}
