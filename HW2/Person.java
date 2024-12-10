public class Person {
    private String idCard;
    private String fullName;
    private String gender;

    //constructor
    public Person(String idCard,String fullName,String gender){
        this.idCard = idCard;
        this.fullName = fullName;
        this.gender = gender;
    }
    //อ่านอย่างเดียว getter
    public String getIdCard(){
        return this.idCard;
    }
    public String getFullName(){
        return this.fullName;
    }
    public String getGender(){
        return this.gender;
    }
    

//แก้ไขข้อมูลได้ setter
    public void setIdCard(String idCard){
        this.idCard = idCard;
    }
    public void setName(String fullname){
        this.fullName = fullname;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

}
