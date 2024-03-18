//import java.util.*;
//
//
//public class planeManagement2 {
//    private static final char[] rowLet = {'A', 'B', 'C', 'D'};
//    private static final int[][] seatNum = {{14}, {12}, {12}, {14}};
//
//    private static int[][] seatingPlan;
//
//    public static void main(String[] args) {
//        System.out.println("""
//                Welcome to the Plane Management application\s
//                ****************************************************
//                *                    MAIN MENU                     *
//                ****************************************************
//                \t 1) Buy a seat
//                \t 2) Cancel a seat
//                \t 3) Find first available seat
//                \t 4) show seating plan
//                \t 5) Print ticket information and total sales
//                \t 6) Search Ticket
//                \t 0) Quit
//                ****************************************************
//                """);
//        menu();
//
//    }
//    public static void  menu(){
//        try{
//            System.out.println("Enter option number from Menu: ");
//            option = input.nextInt();
//            switch (option) {
//                case 1:
//                    buy_seat();
//                    break;
//                case 2:
//                    cancel_seat();
//                    break;
//                case 3:
//                    find_first_available();
//                    break;
//                case 4:
//                    show_seat_planning();
//                    break;
//                case 5:
//                    print_ticket_info();
//                    break;
//                case 6:
//                    search_ticket();
//                    break;
//                case 0:
//                    System.out.println("Exitting...");
//                    break;
//                default:throw new InputMismatchException("ERROR! Enter valid menu number");
//            }
//
//        }catch (InputMismatchException e){
//            System.out.println("Enter valid Menu Number");
//        }
//    }
//    public static void  buy_seat( ){
//        while (true){
//            char rowLet=getValidRowInput();
//            int seatNum=getValidSeatNumber(rowLet);
//            if (isSeatAvailable(rowLet, seatNum)) {
//                seatingPlan[getRowIndex(rowLet)][seatNum] = 1;
//                System.out.println("Seat +{row}{seatNumber + 1} purchased successfully!");
//                return;
//            } else {
//                System.out.println("Seat already taken. Please try again.");
//            }
//        }
//
//
//        }
//
//        }
//
//
//
//
//    }
//    public rawInput(){
//
//
//    }
//    private static char getValidRowInput() {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.print("Enter row letter (A-D): ");
//            char row = scanner.next().toUpperCase().charAt(0);
//            if (isValidRow(row)) {
//                return row;
//            } else {
//                System.out.println("Invalid row letter. Please try again.");
//            }
//        }
//    }
//
//    private static int getValidSeatNumber(char row) {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.print("Enter seat number (1-" + getSeatCapacity(row) + "): ");
//            int seatNumber = scanner.nextInt() - 1; // Adjust for 0-based indexing
//            if (isValidSeatNumber(row, seatNumber)) {
//                return seatNumber;
//            } else {
//                System.out.println("Invalid seat number. Please try again.");
//            }
//        }
//    }
//
//    private static boolean isValidRow(char row) {
//        for (char validRow : ROW_LETTERS) {
//            if (row == validRow) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private static int getSeatCapacity(char row) {
//        int rowIndex = getRowIndex(row);
//        return rowIndex != -1 ? SEAT_CAPACITIES[rowIndex][0] : 0;
//    }
//
//    private static int getRowIndex(char row) {
//        for (int i = 0; i < ROW_LETTERS.length; i++) {
//            if (ROW_LETTERS[i] == row) {
//                return i;
//            }
//        }
//
//   }
//}