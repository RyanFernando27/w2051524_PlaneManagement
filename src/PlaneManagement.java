import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class PlaneManagement {
    static boolean[] rowA=new boolean[14];
    static boolean[] rowB=new boolean[12];
    static boolean[] rowC=new boolean[12];
    static boolean[] rowD=new boolean[14];
    static int ticketssold=0;
    static Ticket[]ticketarray=new Ticket[52];
    static String rowLet;
    static int seatNo;
    static String opt="y";
    static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("""
                Welcome to the Plane Management application\s
                ****************************************************
                *                    MAIN MENU                     *
                ****************************************************
                \t 1) Buy a seat
                \t 2) Cancel a seat
                \t 3) Find first available seat
                \t 4) show seating plan
                \t 5) Print ticket information and total sales
                \t 6) Search Ticket
                \t 0) Quit
                ****************************************************
                """);

//        after print heading menu method started to execute .
        menu();
    }
    public static void  menu(){
        boolean loopContinue = true;
        while (loopContinue) {
            try {
                System.out.println("Enter option number from Menu: ");
                int option = input.nextInt(); // Assuming option is an integer

                switch (option) {
                    case 1:
                        buy_seat();
                        break;
                    case 2:
                        cancel_seat();
                        break;
                    case 3:
                        find_first_available();
                        break;
                    case 4:
                        show_seat_planning();
                        break;
                    case 5:
                        print_ticket_info();
                        break;
                    case 6:
                        search_ticket();
                        break;
                    case 0:
                        System.out.println("Exitting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please enter a number from 0 to 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // Clear the input buffer to avoid issues in the next iteration
            }

        }


    }
    private static void buy_seat() {
        System.out.println("********************\n"+
                "*      Buy Seat    *\n"+
                "********************");
        opt="y";
//while opt not equal to "n" loop the code.
        while(!opt.equals("n")){
            try{

                    System.out.print("Enter name:");
                    String name=input.next();
                    System.out.print("Enter Surname:");
                    String surname=input.next();
                    System.out.print("Enter Email:");
                    String email=input.next();

//                store personal details input in variables.
                try{

                    System.out.print("Enter Row Letter:");
                    rowLet=input.next();
//                    check the rowletter that equals to A,B,C,D.
                    if(rowLet.equals("a") || rowLet.equals("b") || rowLet.equals("c") || rowLet.equals("d")) {
                        System.out.print("Enter Seat number: ");
                        seatNo = input.nextInt();
                        if (seatNo >= 1 && seatNo<15)// seat number should be above 0.
                        {
                            int SPrice=seatPrice(seatNo);//pass the seat number to seatPrice method to
                            // calculate the price of seat.and store it in variable.

                            switch (rowLet) {
                                case "a":
                                    //
                                    if (!rowA[seatNo - 1]) {
                                        for (int i = 0; i <= rowA.length - 1; i++) {
                                            rowA[seatNo - 1] = true;
                                        }
                                        Person personObj=new Person(name,surname,email);
                                        Ticket ticketObj=new Ticket(rowLet,seatNo,SPrice,personObj);
                                        ticketarray[ticketssold] = ticketObj;
                                        ticketssold ++;
                                        ticketObj.save();
                                        System.out.println(rowLet.toUpperCase() + seatNo + " sold\n");

                                    } else {
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Not available");
                                    }
                                    break;
                                case "b":
                                    if (!rowB[seatNo - 1]) {
                                        for (int i = 0; i <= rowB.length - 1; i++) {
                                            rowB[seatNo - 1] = true;
                                        }
                                        Person personObj=new Person(name,surname,email);
                                        Ticket ticketObj=new Ticket(rowLet,seatNo,SPrice,personObj);
                                        ticketarray[ticketssold] = ticketObj;
                                        ticketssold ++;
                                        ticketObj.save();
                                        System.out.println(rowLet.toUpperCase() + seatNo + " sold");
//
                                    } else {
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Not available");
                                    }
                                    break;
                                case "c":
                                    if (!rowC[seatNo - 1]) {
                                        for (int i = 0; i <= rowC.length - 1; i++) {
                                            rowC[seatNo - 1] = true;
                                        }
                                        Person personObj=new Person(name,surname,email);
                                        Ticket ticketObj=new Ticket(rowLet,seatNo,SPrice,personObj);
                                        ticketarray[ticketssold] = ticketObj;
                                        ticketssold ++;
                                        ticketObj.save();
                                        System.out.println(rowLet.toUpperCase() + seatNo + " sold");
                                    } else {
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Not available");
                                    }
                                    break;
                                case "d":
                                    if (!rowD[seatNo - 1]) {
                                        for (int i = 0; i <= rowD.length - 1; i++) {
                                            rowD[seatNo - 1] = true;

                                        }
                                        Person personObj=new Person(name,surname,email);
                                        Ticket ticketObj=new Ticket(rowLet,seatNo,SPrice,personObj);
                                        ticketarray[ticketssold] = ticketObj;
                                        ticketssold ++;
                                        ticketObj.save();
                                        System.out.println(rowLet.toUpperCase() + seatNo + " sold");


//

                                    } else {
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Not available");
                                    }
                                    break;
                                default:
                                    System.out.println("Enter valid Seat number");
                            }


                        }
                        else {
                            //if seat number less than 0
                            System.out.println("Seat Number not available");
                        }
                    }else{
                        System.out.println("Enter valid Row Letter");
                    }

                    System.out.println("Book another seat Press Y to continue or Press N to exit");
                    opt=input.next();

                }catch (ArrayIndexOutOfBoundsException e){
                    //seat number not in range of row. ex: row A(13 seats) user input 15 seat it is out of range.
                    System.out.println("ERROR!  Seat number not in range");
                }
            }catch (InputMismatchException e){//seat number not an integer this will
                System.out.println("Invalid input!  Enter Valid Input ");
                System.out.println(" ");
                opt=input.next();
            }

        }
        menu();

    }
    private  static void cancel_seat(){
        System.out.println("""
                ****************************
                *         Cancel Seat      *
                ****************************""");
        opt="y";
        while(!opt.equals("n")){
            try {//check inputs are valid

                System.out.print("Enter Row Letter :");
                rowLet = input.next();

                if(rowLet.equals("a") || rowLet.equals("b") || rowLet.equals("c") || rowLet.equals("d")){

                    System.out.print("Enter seat number");
                    seatNo = input.nextInt();

                    if(seatNo>0 && seatNo<15){
                        Ticket.DeleteFile(rowLet,seatNo);

                        cancelTicketArray(rowLet,seatNo);

                            switch (rowLet) {
                                case "a":
                                    if (rowA[seatNo - 1]) {
                                        for (int i = 0; i <= rowA.length - 1; i++) {
                                            rowA[seatNo-1] = false;
                                        }
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Cancelled");
                                    } else {
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Not booked");
                                    }
                                    break;

                                case "b":
                                    if (rowB[seatNo - 1]) {
                                        for (int i = 0; i <= rowB.length - 1; i++) {
                                            rowB[seatNo-1] = false;
                                        }
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Cancelled");
                                    } else {
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Not booked");
                                    }
                                    break;

                                case "c":
                                    if (!rowC[seatNo]) {
                                        for (int i = 0; i <= rowC.length - 1; i++) {
                                            rowC[seatNo-1] = false;
                                        }
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Cancelled");
                                    } else {
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Not booked");
                                    }
                                    break;
                                case "d":

                                    if (!rowD[seatNo]) {
                                        for (int i = 0; i <= rowD.length - 1; i++) {
                                            rowC[seatNo-1] = false;
                                        }
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Cancelled");
                                    } else {
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Not booked");
                                    }
                                    break;
                            }
                            System.out.println("Press any key to continue or Press n to return menu");
                            opt = input.next();
                    }
                    else{
                        System.out.println("ERROR!  Enter valid Seat Number 1-14");
                    }
                }else{
                    System.out.println("ERROR!  Enter valid Row Letter A-D");
                }
                }catch(InputMismatchException e){
                    System.out.println("Invalid input!  Enter Valid Input ");
                }
            }
        menu();
//2
}
    private  static void find_first_available(){
        System.out.println("Find first available");
        System.out.println("Enter row number to find first seat available");
        rowLet=input.next();


        boolean searchValue = false;
        int index = 0;
        switch(rowLet){

            case "a":
                while (index < rowA.length-1 && rowA[index] != searchValue) {
                    index++;
                }
                if (index == rowA.length) {
                    System.out.println("All Booked");
                } else {
                    index++;
                    System.out.println("First seat available in : "+rowLet.toUpperCase() + index );
                }
                break;
            case "b":
                while (index < rowB.length-1 && rowB[index] != searchValue) {
                    index++;
                }
                if (index == rowB.length) {
                    System.out.println("All Booked");
                } else {
                    index++;
                    System.out.println("First seat available in : "+rowLet.toUpperCase() + index );
                }
                break;
            case "c":
                while (index < rowC.length-1 && rowC[index] != searchValue) {
                    index++;
                }
                if (index == rowC.length) {
                    System.out.println("All Booked");
                } else {
                    index++;
                    System.out.println("First seat available in : "+rowLet.toUpperCase() + index );
                }
                break;
            case "d":
                while (index < rowD.length-1 && rowD[index] != searchValue) {
                    index++;
                }
                if (index == rowD.length) {
                    System.out.println("All Booked");
                } else {
                    index++;
                    System.out.println("First seat available in : "+rowLet.toUpperCase() + index );
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + rowLet);
        }
        menu();

//3
    }
    private  static void show_seat_planning(){

        System.out.println("************************\n"+
                "*      Seat Planning   *\n"+
                "************************\n");


        System.out.print("A ");
        for (int a=0;a<rowA.length;a++){
            if(rowA[a]){
                System.out.print("X ");
            }else{
                System.out.print("O ");
        }
//4
    }
        System.out.print("\nB ");
        for (int b=0;b<rowB.length;b++){
            if(rowB[b]){
                System.out.print("X ");
            }else{
                System.out.print("O ");
            }
        }
        System.out.print("\nC ");
        for (int c=0;c<rowC.length;c++){
            if(rowC[c]){
                System.out.print("X ");
            }else{
                System.out.print("O ");
            }
        }
        System.out.print("\nD ");
        for (int d=0;d<rowD.length;d++){
            if(rowD[d]){
                System.out.print("X ");
            }else{
                System.out.print("O ");
            }
        }
        System.out.println("\n ");
        menu();
    }
    private  static void print_ticket_info(){
        System.out.println("""
                ***********************************
                *         Ticket Information      *
                ***********************************""");
        int total=0;

        for (int i = 0; i < ticketarray.length; i++) {

                if(ticketarray[i]!=null){
                    Ticket ticket = ticketarray[i];

                    System.out.println("----------------------------------\n             Ticket:"+(i+1)+"\n----------------------------------");
                    System.out.println("Row:   "+ticket.getRow());
                    System.out.println("Seat:   "+ticket.getSeat());
                    System.out.println("Price:  $"+seatPrice(seatNo));

                    Person buyer = ticket.getPerson();
                    System.out.println("Name:   "+buyer.getName());
                    System.out.println("Surname:    "+buyer.getSurname());
                    System.out.println("email:  "+buyer.getEmail());
                    System.out.println();
                    total=total+seatPrice(ticket.getSeat());

                }


        }
        System.out.println("Total:  $"+total);

    }
    private  static void search_ticket(){
        opt="y";
        try{
            while (!opt.equals("n")){
                System.out.print("Enter Row Letter:");
                rowLet=input.next();
                if(rowLet.equals("a")||rowLet.equals("b")||rowLet.equals("c")||rowLet.equals("d")){
                    System.out.print("Enter Seat Number: ");
                    seatNo=input.nextInt();
                    if((1<=seatNo) && (seatNo < 15)){
                        if(rowLet.equals("a")){
                            search(rowA, seatNo,rowLet);
                        } else if (rowLet.equals("b")) {
                            search(rowB,seatNo,rowLet);
                        }else if (rowLet.equals("c")) {
                            search(rowC,seatNo,rowLet);
                        } else if (rowLet.equals("d")) {
                            search(rowD,seatNo,rowLet);
                        }
                    }else {
                        System.out.println("Enter valid seat Number");
                    }

                }else {
                    System.out.println("ERROR!  Enter Valid Row Letter");
                }
                System.out.println("Book another seat Press Y to continue or Press N to exit");
                opt=input.next();

            }

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Enter valid seat Number");
        }
//6
        menu();
  }
    private static int seatPrice(int seatNo) {
      int price = 0;
      if ( seatNo < 6) {
//          1-5 seats price is $200
          price = 200;
      }else if(seatNo<= 9){
//          6-9 seats price is $150
          price=150;
      }else if(seatNo<15){
//          10-14 seat price is $180
          price=180;
      }
      return price;
  }
    private static void cancelTicketArray(String rowLet,int seat){
    }

    public static boolean search(boolean[] array, int value,String row) {
        for (int i = 0; i < array.length; i++) {
            if (array[value-1] == false) {
                System.out.println("Seat Available");
                return true; // Found the value
            }else{
                System.out.println("Seat Booked");
                Ticket.FileExist(row,value);
                return false;
            }
        }
        return false; // Value not found in the array
    }
}


