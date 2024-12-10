import java.util.Scanner;

public class Manager extends Person{
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private String username;
    private String password;
    private static Manager manager;

    public Manager(String idCard,String fullName,String gender,String username,String password){
        super(idCard, fullName,gender);
        this.name = fullName;
        this.username = username;
        this.password = password;
    }

    public void createManager(){

        System.out.println("------ Setting Manager ------");
        System.out.println("Please enter information of Maneger.");

            do{
                System.out.print("ID Card = ");
                String idCardInput= scanner.nextLine();
                
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
                name = scanner.nextLine();
                if (name.length() > 50 ) {
                    System.out.println("Please enter Fullname less than 50 character.");
                    continue;
                }
                setName(name);
                break;
            }while(true);
    
            do {
                System.out.print("Gender = ");
                String genderInput = scanner.nextLine();
                genderInput = genderInput.toLowerCase();
                if(genderInput.equals("male")||genderInput.equals("female")){
                    setGender(genderInput);
                    break;
                }
                System.out.println("Please enter Male or Female only");
                continue;
                
            } while (true);
    
    
            System.out.print("Username = ");
            username = scanner.nextLine();

    
            do {
                System.out.print("Password = ");
                password = scanner.nextLine();
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

            manager = new Manager(getIdCard(),getFullName(),getGender(),username,password);
            System.out.println();

        login();

    }

    public void login(){
        int count_mistake = 0;
        boolean passed = false;

        System.out.println("--- Login Manger ---");
       do {
        System.out.print("Username = ");
        String usernameInput = scanner.nextLine();
        if(!this.username.equals(usernameInput)){
            System.out.println("Don't have this Username");
            continue;
        }
        
        break;
       } while (true);
        
        do {
            System.out.print("Password = ");
            String passwordInput = scanner.nextLine();
            if(password.length() != 4 ){
                System.out.println("Please enter password within 4 digit");
                continue;
            }
            if(!password.matches("\\d+")){
                System.out.println("Invalid password number.");
                continue;
            }
            if(this.password.equals(passwordInput)){
                passed = true;
                break;
            }else{
                System.out.println("Invalid Password. Please try again.");
                count_mistake+=1;
            }
            
            if (count_mistake == 2) { // 3 ครั้ง
                System.err.println(
                        "ERROR You entered Account ID and Password don't match 3 times, \n.\n.\n. \nlogged out");
                System.exit(0); // หยุดการทำงานของโปรแกรมทั้งหมด
            }
        } while (!passed);
                
            // แสดงผลลัพธ์
            if(passed)
            {
                System.out.println("\n----- Login Passed! -----");
                System.out.println("Manager name : "+getFullName());
                System.out.println("Manager ID: "+getIdCard());
                System.out.println("-------------------------\n");

                //ใช้งาน ATM ใน main ต่อ
                count_mistake = 0;

            }
    }


    public String getName(){
        return this.name;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public static Manager getManagers() {
        return manager;
    }
}
