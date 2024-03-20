import java.io.*;

public class Ticket {

//seat, price, and Person
    private String row;
    private int seat;
    private int price;
     private Person person;

//    Constructor
    public Ticket(String row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
public void save(){
    try{
        String filename= (row.toUpperCase()+seat+".txt");
        File fileOBJ=new File("/Users/ryanfernando/Documents/IIT/Software Dev/SEM2/SD II/CW/w2051524_PlaneManagement/Files/"+filename);
        FileWriter writer=new FileWriter(filename);
        writer.write("\nName    :  "+person.getName());
        writer.write("\nSuranme :  "+person.getSurname());
        writer.write("\nEmail   :  "+person.getEmail());
        writer.write("\nSeat    :  "+row.toUpperCase());
        writer.write("\nNumber  :  "+seat);
        writer.close();
        System.out.println("Ticket File Created Successfully..");

    }catch (IOException e){
        System.out.println("An Error occurred!");
    }
}
public static void DeleteFile(String row, int seat){
    String filename=(row+seat+".txt");
    File fileOBJ=new File(filename);
    if(fileOBJ.exists()){
        if(fileOBJ.delete()){
            System.out.println(filename+"File Deleted successfully");
        }else{
            System.out.println("Error in Deletion Process..");
        }
    }else{
        System.out.println("File Not found!");
    }

}
public static void FileExist(String row,int seat){
        String filename=(row+seat+".txt");
        File fileOBJ=new File(filename);
        if(fileOBJ.exists()){
            try (FileReader fileReader = new FileReader(filename);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line); // Process each line
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
}
