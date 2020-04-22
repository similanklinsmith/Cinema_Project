package cinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Cinema {
 
    public static void main(String[] args) {
        boolean check = false;
        int option = 0;
        ArrayList<Show> shows = new ArrayList<Show>();
        ArrayList<Theatre> theatres = new ArrayList<Theatre>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Scanner select = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);

        Theatre testTheatre = new Theatre(1);
        testTheatre.createRows(1, 10, 7);
        theatres.add(testTheatre);
        shows.add(new Show("Der SpongeBob Schwammkopf - Film", LocalDateTime.of(2019, Month.APRIL, 20, 15, 30), theatres.get(0), "HORROR"));
        do {
            System.out.println("<<Menu>>");
            System.out.println(" 1.) Add Theatre");
            System.out.println(" 2.) Add Show");
            System.out.println(" 3.) Display Shows");
            System.out.println(" 4.) Make Booking");
            System.out.println(" 5.) Cancel Booking");
            System.out.println(" 6.) Exit\n");
            try {
                System.out.print("Enter choice : ");

                option = select.nextInt();
                check = false;

                if (option == 1) {
                    System.out.println("ADD THEATRE Selected");
                    System.out.println("-------------------------\n");
                    System.out.print("Enter a name for the theatre: \n");
                    String theatreName = choice.nextLine();
                    System.out.print("Enter a number for the theatre: \n");
                    int theatreNumber = choice.nextInt();
                    System.out.println("Enter the number of rows:");
                    int rowCount = choice.nextInt();
                    Theatre theatre = new Theatre(theatreNumber,"sdf");
                    theatre.createRows(1, 10, rowCount);
                    theatre.createRows(1, 5, 5);
                    theatres.add(theatre);
                }

                if (option == 2) {
                    System.out.println("ADD SHOW Selected");
                    System.out.println("-------------------------\n");
                    System.out.println("Enter the date of the Show [DD/MM/YYYY]:");
                    String userInput = choice.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    LocalDateTime showDate = LocalDateTime.parse(userInput, formatter);
                    System.out.print("Enter name of Show: \n");
                    String showName = choice.nextLine();
                    System.out.println("Select a theatre by typing the number:");
                    for (int i = 0; i < theatres.size(); i++) {
                        System.out.println(i + 1);
                    }
                    int theatreNumber = choice.nextInt();
                    shows.add(new Show(showName, showDate, theatres.get(theatreNumber - 1),"HORROR"));
                }

                if (option == 3) {
                    System.out.println("DISPLAY SHOWS Selected");
                    System.out.println("-------------------------\n");
                    for (int i = 0; i < shows.size(); i++) {
                        int showNumber = i + 1;
                        System.out.println("Show Number: " + showNumber);;
                        System.out.println("Show Name: " + shows.get(i).getShowName());
                        System.out.println("Show Date: " + shows.get(i).getShowDate());
                        //System.out.println("Seat Status:" + shows.get(i).getFreeSeatsCount());
                        System.out.println("\n");
                    }
                    System.out.println("End of Show List.\n");
                }

                if (option == 4) {
                    System.out.println("MAKE BOOKING Selected");
                    System.out.println("-------------------------\n");
                    Random rnd = new Random();
                    int costumerId = rnd.nextInt(999);
                    Customer customer = new Customer("Banhkok", 635983619, 25952, "Similan", "Klinsmith");
                    customers.add(customer);
                    for (int i = 0; i < shows.size(); i++) {
                        int showNumber = i + 1;
                        System.out.println("Show Number: " + showNumber);;
                        System.out.println("Show Name:   " + shows.get(i).getShowName());
                        System.out.println("Show Date:   " + shows.get(i).getShowDate());
                        System.out.print("\n");
                    }
                    System.out.println("-------------------------");
                    System.out.print("Enter the show number: ");
                    int showNumber = choice.nextInt();
                    int repeat = 0;
                    System.out.println();
                    do {
                        shows.get(showNumber - 1).getTheatre().printSeatPlan();
                        System.out.print("Enter the row: ");
                        int selectedRow = choice.nextInt();
                        System.out.print("Enter the seat: ");
                        int selectedSeat = choice.nextInt();
                        System.out.println();
                        Booking booking = new Booking(customer, shows.get(showNumber - 1));
                        if (booking.reserveSeat(selectedRow - 1, selectedSeat - 1)) {
                            bookings.add(booking);
                            System.out.println("The seat is now reserved for you.");
                        } else {
                            System.out.println("Sorry the seat is already reserved.");
                        }
                        System.out.println();
                        System.out.print("Enter 1 to reserve another seat or 2 to check out: ");
                        repeat = choice.nextInt();
                    } while (repeat == 1);
                    System.out.println();
                    System.out.println("Your Bill");
                    System.out.println("-------------------------");
                    int totalCost = 0;
                    for (Booking booking : bookings) {
                        if (booking.getCostumer().getPersonId() == customer.getPersonId()) {
                            totalCost += booking.getCost();
                        }
                    }
                    System.out.println("Costumer ID: " + customer.getPersonId());
                    System.out.println("Total costs: " + totalCost + " Euro");
                    System.out.println();
                }

                if (option == 5) {
                    System.out.println("CANCEL BOOKING Selected");
                    System.out.println("-------------------------\n");
                    System.out.print("Enter the costumer id: ");
                    int customerId = choice.nextInt();
                    for (Customer customer : customers) {
                        if (customer.getPersonId() == customerId) {
                            for (Booking booking : bookings) {
                                if (booking.getCostumer().getPersonId() == customer.getPersonId()) {
                                    if (booking.unreserveSeat()) {

                                    }
                                }
                            }
                            System.out.println("Your reservation has been canceled!");
                        }
                    }
                    System.out.println();
                }

                if (option == 6) {
                    System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("You have to inform only number");
                select.next();
                check = true;
                
            }
        } while (!check);

    }
    
}
