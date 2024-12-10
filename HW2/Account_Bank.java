import java.util.Scanner;

public class Account_Bank extends Person{
    private Scanner input = new Scanner(System.in);
    private static Account_Bank[] accounts; // Array เก็บบัญชีทั้งหมด
    private int number;
    private String accountID;
    private String nameID;
    private String password;
    private double balance;

    //constructor
    public Account_Bank(String accountID,String password,double balance,String idCard,String fullName,String gender){
        super(idCard, fullName, gender);
        this.accountID = accountID;
        this.password = password;
        this.nameID = fullName;
        this.balance = balance;
    }


    public void createAccount(){
        do{
            System.out.print("Step 1. Enter amount of all accountID = ");
            number = input.nextInt();
            input.nextLine(); // เคลียร์ buffer หลังจากรับ int
            if(number>5){
                System.out.println("Please enter more than or equal to 5 accountIDs.");
            }
        }while(number>5);
        accounts = new Account_Bank[number]; 
        
        System.out.println("Step 2. Enter Detail od each accountID \n");

        for (int i=0; i<number ; i++){
                System.out.println("No."+(i+1));
                do{
                    System.out.print("account ID = ");
                    accountID = input.nextLine();

                   // ตรวจสอบความยาวและรูปแบบ (ต้องเป็นตัวเลขทั้งหมด)
                    if (accountID.length() != 13 ) {
                        System.out.println(" Please enter exactly 13 digits.");
                        continue;
                    }
                    if(!accountID.matches("\\d+")){
                        System.out.println("Invalid accountID number");
                        continue;
                    }
                    break;
                }while(true);

                
                do{
                    System.out.print("ID Card = ");
                    String idCardInput= input.nextLine();
                    
                    // ตรวจสอบความยาวและรูปแบบ (ต้องเป็นตัวเลขทั้งหมด)
                    if (idCardInput.length() != 13 ) {
                        System.out.println(" Please enter exactly 13 digits.");
                        continue;
                    }
                    if(!idCardInput.matches("\\d+")){
                        System.out.println("Invalid ID Card number");
                        continue;
                    }
                    
                    setIdCard(idCardInput);
                    break;
                }while(true);

                do{
                    System.out.print("Fullname ID = ");
                    nameID = input.nextLine();
                    if (nameID.length() > 50 ) {
                        System.out.println("Please enter Fullname less than 50 character.");
                        continue;
                    }
                    setName(nameID);
                    break;
                }while(true);

                do {
                    System.out.print("Gender = ");
                    String genderInput = input.nextLine();
                    genderInput = genderInput.toLowerCase();
                    if(genderInput.equals("male")||genderInput.equals("female")){
                        setGender(genderInput);
                        break;
                    }
                    System.out.println("Please enter Male or Female only");
                    continue;
                    
                } while (true);

                do {
                    System.out.print("Password = ");
                    password = input.nextLine();
                    if(password.length() != 4 ){
                        System.out.println("Please enter password within 4 digit");
                        continue;
                    }
                    if(!password.matches("\\d+")){
                        System.out.println("Invalid password number.");
                        continue;
                    }
                    break;
                } while (true);

                do {
                    System.out.print("Balance = ");
                    balance = input.nextDouble();
                    input.nextLine(); 
                    if(balance >1000000){
                        System.out.println("Please enter Balance less than 1000000 bath");
                        continue;
                    }
                    break;
                } while (true);

                accounts[i] = new Account_Bank(accountID,password,balance,getIdCard(),getFullName(),getGender()); // สร้างบัญชีและเพิ่มลง array
                
                System.out.println();

            }


    }

    public String getAccountID(){
        return this.accountID;
    }

    public String getNameID(){
        return this.nameID;
    }

    public String getPassword(){
        return this.password;
    }

    public double getBalance(){
        return this.balance;
    }
    public String getGender(){
        return super.getGender();
    }

    public String getIdCard(){
        return super.getIdCard();
    }

    //setter
    public void setBalance(double balance){
        this.balance=balance;
    }

     // Method สำหรับดึง array ของบัญชี
    public static Account_Bank[] getAccounts() {
        return accounts;
    }


}
