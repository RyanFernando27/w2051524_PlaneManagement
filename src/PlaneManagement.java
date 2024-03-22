import java.util.*;
public class PlaneManagement {

    static boolean[] rowA=new boolean[14];//rowA 14 seats
    static boolean[] rowB=new boolean[12];//rowB 12 seats
    static boolean[] rowC=new boolean[12];//rowC 12 seats
    static boolean[] rowD=new boolean[14];//rowD 14 seats
    static int ticketsSold =0;//use for save ticketArray index
    static Ticket[] ticketArray=new Ticket[52];//save Ticket objects in array
    static String rowLet;
    static int seatNo;
    static String opt="y";//after user enter "n" for exit loop and opt="n" by this  set opt variable to "y" to use in other methods while loops.
    static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {
//        Prints Main Menu options
        System.out.println("""
               
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

//        after print heading ,menu method started to execute .
        menu();
    }
    public static void  menu(){
        //while true user can input menu items by preferred integer to select options(0-6).
        // if user enter invalid input program gives an error.
        // return nothing
        while (true) {
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
                        System.exit(0);//user enter 0 the program exits safely.
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

        //when user inputs 1 in menu method this method started to run,
        //after input row Letter (a-d) and input seat number(0-14/0-12),then ask for personal information
        //then all valid it will change false to true in relevant array.
        //return nothing.


        System.out.println("""

                *************************
                *         Buy Seat      *
                *************************""");
        opt="y";
//while opt not equal to "n" loop the code.
        while(!opt.equals("n")){
                try {
                    try{
                        System.out.print("Enter Row Letter:");//ask user to enter row letter
                        rowLet = input.next();
//                    check the rowletter that equals to A,B,C,D.
                        if (rowLet.equals("a") || rowLet.equals("b") || rowLet.equals("c") || rowLet.equals("d")) {
                            System.out.print("Enter Seat number: "); //ask user to enter seat number
                            seatNo = input.nextInt();

                            if (seatNo >= 1 && seatNo < 15)// seat number should be above 0.
                            {
                                int SPrice = seatPrice(seatNo);//pass the seat number to seatPrice method to
                                // calculate the price of seat.and store it in variable SPrice.

                                switch (rowLet) {
                                    case "a":
                                        //
                                        if (!rowA[seatNo - 1]) {// rowA[seatNo-1]==false then the value change true for
                                            //display as sold .
                                            rowA[seatNo - 1] = true;
                                            personInfo(SPrice);//pass seatprice to personinfo method that essential to
                                            // create object.

                                            System.out.println(rowLet.toUpperCase() + seatNo + " sold\n");
                                            //after sold this message will print

                                        } else {
                                            //if seat booked this will print
                                            System.out.println(rowLet.toUpperCase() + seatNo + " already booked try another seat");
                                        }
                                        break;
                                    case "b":
                                        if (!rowB[seatNo - 1]) {
                                            rowB[seatNo - 1] = true;
                                            personInfo(SPrice);
                                            System.out.println(rowLet.toUpperCase() + seatNo + " sold");
//
                                        } else {
                                            System.out.println(rowLet.toUpperCase() + seatNo + " already booked try another seat");
                                        }
                                        break;
                                    case "c":
                                        if (!rowC[seatNo - 1]) {

                                            rowC[seatNo - 1] = true;
                                            personInfo(SPrice);
                                            System.out.println(rowLet.toUpperCase() + seatNo + " sold");
                                        } else {
                                            System.out.println(rowLet.toUpperCase() + seatNo + " already booked try another seat");
                                        }
                                        break;
                                    case "d":
                                        if (!rowD[seatNo - 1]) {

                                            rowD[seatNo - 1] = true;

                                            personInfo(SPrice);
                                            System.out.println(rowLet.toUpperCase() + seatNo + " sold");
                                        } else {
                                            System.out.println(rowLet.toUpperCase() + seatNo + " already booked try another seat");
                                        }
                                        break;
                                    default:
                                        System.out.println("Enter valid Seat number!");
                                }
                            } else {
                                //if seat number less than 0
                                System.out.println("Seat Number not in range!");
                            }

                        } else {
                            System.out.println("Enter valid Row Letter!");
                        }

                    }   catch (ArrayIndexOutOfBoundsException e ){
                        System.out.println("Seat not Availabe");
                        opt=input.next();
                    }
                }catch (InputMismatchException e){//seat number not an integer this exception message will print.
                        System.out.println("Invalid input!  Enter Valid Input ");
                        opt=input.next();


                }
                System.out.println("Book another seat Press Y to continue or Press N to exit");
                opt=input.next();
        }
        menu();
    }
    public static void personInfo(int seatPrice){
        /*
        after user select a seat this method start to execute to collect person information and create
        objects and save information in Ticket Object array and save in text file.
         */
        Scanner input=new Scanner(System.in);
        System.out.print("Enter name:");
        String name=input.next();
        System.out.print("Enter surname: ");
        String surname=input.next();
        System.out.print("Enter email:");
        String email=input.next();

        //pass above details to create new person object.
        Person personObj=new Person(name,surname,email);

        //pass details to create new ticket with seat details and person information.
        Ticket ticketObj=new Ticket(rowLet,seatNo,seatPrice,personObj);
        ticketArray[ticketsSold] = ticketObj;//save created ticket object in array.
        ticketsSold++;
        ticketObj.save();//save details on a text file.
    }
    private  static void cancel_seat(){
//when user inputs 2 in menu method this method started to run,
        //after input row Letter (a-d) and input seat number(0-14/0-12),if it is a sold seat this make the seat available.
        //then all valid it will change true to false in relevant array.
        //return nothing.
//
        System.out.println("""
                ****************************
                *         Cancel Seat      *
                ****************************""");
        opt="y";
        while(!opt.equals("n")){
            try {//check inputs are valid
                try{
                    System.out.print("Enter Row Letter:");//ask user to enter row letter
                    rowLet = input.next();
//                    check the rowletter that equals to A,B,C,D.
                    if (rowLet.equals("a") || rowLet.equals("b") || rowLet.equals("c") || rowLet.equals("d")) {
                        System.out.print("Enter Seat number: "); //ask user to enter seat number
                        seatNo = input.nextInt();

                        if(seatNo>0 && seatNo<15){
                            Ticket.DeleteFile(rowLet,seatNo);//by this the text file exist to the relevant seat will be deleted;
                            switch (rowLet) {
                                case "a":
                                    //check if the seat booked or not.
                                    if (rowA[seatNo - 1]){
                                        rowA[seatNo-1] = false;// relevant seat change to available

                                        System.out.println(rowLet.toUpperCase() + seatNo + " Cancelled");//printout relevant seat cancelled.
                                    } else {
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Not booked");
                                    }
                                    break;

                                case "b":
                                    if (rowB[seatNo - 1]) {

                                        rowB[seatNo-1] = false;
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Cancelled");
                                    } else {
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Not booked");
                                    }
                                    break;

                                case "c":
                                    if (!rowC[seatNo]) {

                                        rowC[seatNo-1] = false;
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Cancelled");
                                    } else {
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Not booked");
                                    }
                                    break;
                                case "d":

                                    if (!rowD[seatNo]) {

                                        rowC[seatNo-1] = false;

                                        System.out.println(rowLet.toUpperCase() + seatNo + " Cancelled");
                                    } else {
                                        System.out.println(rowLet.toUpperCase() + seatNo + " Not booked");
                                    }
                                    break;
                            }


                        }else {
                            System.out.println("Seat Number not in range");
                        }


                    }else{
                        System.out.println("ERROR!  Enter valid Row Letter A-D");
                    }

                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Seat number not in row");

                    }


                }catch(InputMismatchException e){
                    System.out.println("Invalid input!  Enter Valid Input ");
                opt = input.next();

                }

            System.out.println("Press any key to continue or Press n to return menu");
            opt = input.next();
            //after executing above statement without error again ask from user to
            // continue again to cancel a seat

            }
        menu();
//2
}
    private  static void find_first_available() {
        /*
        when user inputs 3 in menu method this method started to run,
        after input row Letter (a-d) it will get you the first available seat in row.
        then all valid it will print out the available seat number .
        return nothing.


         */
        System.out.println("""
                ******************************
                *    Find first available    *
                ******************************""");
try{
    while (!opt.equals("n")) {

        System.out.println("Enter row number to find first seat available");
        rowLet = input.next();

        if (rowLet.equals("a") || rowLet.equals("b") || rowLet.equals("c") || rowLet.equals("d")) {


            boolean searchValue = false;
            int index = 0;
            switch (rowLet) {

                case "a":
                            /*
                            check the relevant row for the false value which means the available seat.
                            if there is a false found it will exit the loop
                            and prints out the relevant available seat.
                             */
                    while (index < rowA.length - 1 && rowA[index] != searchValue)

                    {
                        index++;
                    }
                    if (index == rowA.length) {
                        System.out.println("All Booked");
                    } else {
                        index++;
                        System.out.println("First seat available in : " + rowLet.toUpperCase() + index);
                    }
                    break;
                case "b":
                    while (index < rowB.length - 1 && rowB[index] != searchValue) {
                        index++;
                    }
                    if (index == rowB.length) {
                        System.out.println("All Booked");
                    } else {
                        index++;
                        System.out.println("First seat available in : " + rowLet.toUpperCase() + index);
                    }
                    break;
                case "c":
                    while (index < rowC.length - 1 && rowC[index] != searchValue) {
                        index++;
                    }
                    if (index == rowC.length) {
                        System.out.println("All Booked");
                    } else {
                        index++;
                        System.out.println("First seat available in : " + rowLet.toUpperCase() + index);
                    }
                    break;
                case "d":
                    while (index < rowD.length - 1 && rowD[index] != searchValue) {
                        index++;
                    }
                    if (index == rowD.length) {
                        System.out.println("All Booked");
                    } else {
                        index++;
                        System.out.println("First seat available in : " + rowLet.toUpperCase() + index);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + rowLet);
            }

        } else {
            System.out.println("Enter Valid row Letter");
        }
        System.out.println("Press any key to continue or Press n to return menu");
        opt = input.next();

        }//while end
        }catch (InputMismatchException e){
        System.out.println("Enter valid input");

        }
        menu();
    }
    private  static void show_seat_planning(){
        /*
        user inputs 4 in main menu this method start to execute.
        it shows the seating plan for look which seats available and which seats not available.
        seat available prints O and seat not available prints 1.
        return nothing
         */

        System.out.println("""
                ****************************
                *       Seat Planning      *
                ****************************""");
        System.out.print("A ");
        for (boolean value : rowA)//enhanced for loop for iterate through rowA boolean array.
        {
            if (value)//if value= true which means the seat sold .
            {
                System.out.print("X ");
            } else {
                System.out.print("O ");
            }
//4
        }

        System.out.print("\nB ");
        for (boolean value : rowB) {
            if (value) {
                System.out.print("X ");
            } else {
                System.out.print("O ");
            }
        }
        System.out.print("\nC ");
        for (boolean value : rowC) {
            if (value) {
                System.out.print("X ");
            } else {
                System.out.print("O ");
            }
        }
        System.out.print("\nD ");
        for (boolean value : rowD) {
            if (value) {
                System.out.print("X ");
            } else {
                System.out.print("O ");
            }
        }
        System.out.println("\n ");
        menu();
    }
    private  static void print_ticket_info(){
        /*
        user inputs 5 in main menu this method start to execute.
        this will print the ticket information with person details of sold seats during session .
         */
        System.out.println("""
                ***********************************
                *         Ticket Information      *
                ***********************************""");
        int total=0;

        for (int i = 0; i < ticketArray.length; i++)
            //get details from ticketArray and print details of seats.
        {

                if(ticketArray[i]!=null){
                    Ticket ticket = ticketArray[i];

                    //ticketArray index assign to ticket object to retrieve details and print .


                    System.out.println("----------------------------------\n             Ticket:"+(i+1)+"\n----------------------------------");
                    System.out.println("Row         :   "+ticket.getRow());
                    System.out.println("Seat        :   "+ticket.getSeat());
                    System.out.println("Price       :   $"+seatPrice(seatNo));

                    Person buyer=ticket.getPerson();
                    System.out.println("Name        :   "+buyer.getName());
                    System.out.println("Surname     :   "+buyer.getSurname());
                    System.out.println("email       :   "+buyer.getEmail());
                    System.out.println();
                    total=total+seatPrice(ticket.getSeat());
                    //get the total of all seats sold during the session.
                }
        }
        System.out.println("Total:  $"+total);//print the total of all sold seats during session.

    }
    private  static void search_ticket(){
        /*
        When user Enter 6 in main menu option this method start to execute
        ask user to enter seat details to check if it's available or sold.
         */
        opt="y";
        try{
            while (!opt.equals("n")){
                System.out.print("Enter Row Letter:");
                rowLet=input.next();
                if(rowLet.equals("a")||rowLet.equals("b")||rowLet.equals("c")||rowLet.equals("d")){
                    System.out.print("Enter Seat Number: ");
                    seatNo=input.nextInt();
                    if((1<=seatNo) && (seatNo < 15)){
                        switch (rowLet) {
                            //(->) a concise way to define the action for the case.
                            //user enter row letter (A-B) then it calls the search method and pass rowA Array , seat number ,rowLetter.
                            case "a" -> search(rowA, seatNo, rowLet);//
                            case "b" -> search(rowB, seatNo, rowLet);
                            case "c" -> search(rowC, seatNo, rowLet);
                            case "d" -> search(rowD, seatNo, rowLet);
                        }
                    }else {
                        System.out.println("Enter valid seat Number");
                    }
                }else {
                    System.out.println("ERROR!  Enter Valid Row Letter");
                }
                System.out.println("Search another seat Press Y to continue or Press N to exit: ");
                opt=input.next();
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Enter valid seat Number");
        }
        menu();
  }
    public static void search(boolean[] array, int value,String row) {
        //related to search_ticket method
        //get 3 arguments from search ticket method row-Array(rowA), value(seat),row(rowLet)
        //if seat already booked it retrieve details from text file that exist.
        //return nothing

        if (!array[value - 1]) {
            System.out.println("Seat Available");
        }else{
            System.out.println("Seat Booked");
            Ticket.FileExist(row,value);//call FileExist method in Ticket object to print details of sold ticket.
        }
    }
    private static int seatPrice(int seatNo) {
        //get price of relevant seat.
        // return the price
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

    }