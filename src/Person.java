public class Person {
//    Attributes
    private String name;

    private String surname;
    private String email;

//  Constructor


    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  void printPerson(){
        System.out.println("name: "+name);
        System.out.println("surname: "+surname);
        System.out.println(email);


    }


}