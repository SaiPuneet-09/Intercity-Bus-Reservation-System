    import java.util.Scanner;

public class BusReservationSystemss {

    static Scanner sc = new Scanner(System.in);
    static double[][] seats = new double[4][5];

    static String busNumber = "";
    static String route = "";
    static String travelDate = "";
    static String departureTime = "";
    static String arrivalTime = "";
    static double ticketPrice = 0;
    static double totalAmount = 0;
    static int bookedSeats = 0;

    // Method to display seat map
    static void displaySeats() {
        System.out.println("\n========== SEAT MAP ==========");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {

                int seatNo = i * 5 + j + 1;

                if (seats[i][j] == 0)
                    System.out.print(seatNo + "[A]  ");
                else
                    System.out.print(seatNo + "[X]  ");
            }
            System.out.println();
        }

        System.out.println("A = Available   X = Booked");
    }

    // Method to book a seat
    static void bookSeat() {
        if (route.equals("")) {
            System.out.println("Please search a bus first.");
            return;
        }

        System.out.print("Enter seat number (1-20): ");
        int seatNo = sc.nextInt();

        if (seatNo < 1 || seatNo > 20) {
            System.out.println("Invalid seat number.");
            return;
        }

        int row = (seatNo - 1) / 5;
        int col = (seatNo - 1) % 5;

        if (seats[row][col] != 0) {
            System.out.println("Seat already booked.");
            return;
        }

        System.out.println("Ticket Price: Rs. " + ticketPrice);
        System.out.print("Confirm booking? (1-Yes / 0-No): ");
        int confirm = sc.nextInt();

        if (confirm == 1) {
            seats[row][col] = ticketPrice;
            bookedSeats++;
            totalAmount += ticketPrice;

            System.out.println("Seat " + seatNo + " booked successfully!");
        } else {
            System.out.println("Booking cancelled.");
        }
    }

    // Method to cancel a seat
    static void cancelSeat() {
        System.out.print("Enter seat number to cancel: ");
        int seatNo = sc.nextInt();

        if (seatNo < 1 || seatNo > 20) {
            System.out.println("Invalid seat number.");
            return;
        }

        int row = (seatNo - 1) / 5;
        int col = (seatNo - 1) % 5;

        if (seats[row][col] == 0) {
            System.out.println("Seat is not booked.");
            return;
        }

        totalAmount -= seats[row][col];
        seats[row][col] = 0;
        bookedSeats--;

        System.out.println("Reservation cancelled successfully.");
    }

    public static void main(String[] args) {

        int choice = 0;

        while (choice != 6) {

            System.out.println("\n================================");
            System.out.println(" INTERCITY BUS RESERVATION SYSTEM");
            System.out.println("================================");
            System.out.println("1. Search Bus");
            System.out.println("2. Display Seat Map");
            System.out.println("3. Book Seat");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. View Reservation");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n1. Hyderabad to Bangalore");
                    System.out.println("2. Hyderabad to Chennai");
                    System.out.println("3. Hyderabad to Vijayawada");

                    System.out.print("Select route: ");
                    int r = sc.nextInt();

                    if (r == 1) {
                        route = "Hyderabad to Bangalore";
                        busNumber = "TS1010";
                        departureTime = "08:00 PM";
                        arrivalTime = "07:50 AM";
                        ticketPrice = 950;
                    } 
                    else if (r == 2) {
                        route = "Hyderabad to Chennai";
                        busNumber = "TS2026";
                        departureTime = "09:00 PM";
                        arrivalTime = "08:15 AM";
                        ticketPrice = 1499;
                    } 
                    else if (r == 3) {
                        route = "Hyderabad to Vijayawada";
                        busNumber = "TS6048";
                        departureTime = "07:00 PM";
                        arrivalTime = "09:00 AM";
                        ticketPrice = 899;
                    } 
                    else {
                        System.out.println("Invalid route.");
                        break;
                    }

                    System.out.print("Enter travel date: ");
                    travelDate = sc.next();

                    System.out.println("\nBus Found!");
                    System.out.println("Bus Number : " + busNumber);
                    System.out.println("Route      : " + route);
                    System.out.println("Date       : " + travelDate);
                    System.out.println("Departure  : " + departureTime);
                    System.out.println("Arrival    : " + arrivalTime);
                    System.out.println("Price      : Rs. " + ticketPrice);
                    break;

                case 2:
                    displaySeats();
                    break;

                case 3:
                    bookSeat();
                    break;

                case 4:
                    cancelSeat();
                    break;

                case 5:
                    System.out.println("\n========== RESERVATION ==========");

                    if (bookedSeats == 0) {
                        System.out.println("No seats booked.");
                    } else {
                        System.out.println("Bus Number : " + busNumber);
                        System.out.println("Route      : " + route);
                        System.out.println("Travel Date: " + travelDate);
                        System.out.println("Booked Seats: " + bookedSeats);
                        System.out.println("Total Amount: Rs. " + totalAmount);
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}

