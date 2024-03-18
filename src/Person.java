public class Person {
//    Attributes
    private String name;

    private String surname;
    private String email;

//  Constructor
     Person(String name,String surname,String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

     void setName(String name){
        this.name=name;
    }
    String getName(){
        return name;
    }
     void setSurname(String surname) {
        this.surname = surname;
    }
     String getSurname(){
        return surname;
    }

     void setEmail(String email) {
        this.email = email;
    }
     String getEmail(){
        return email;
    }


}