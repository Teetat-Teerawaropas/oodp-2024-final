import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.Scanner;
import java.text.DateFormatSymbols;
import java.io.*;

public class main {

    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        trycatcherror tce = new trycatcherror();

        // Declare variables
        int a = 0;
        int room = 0;

        do {

            // Create objects
            Day checkIn = new Day();
            Day checkOut = new Day();

            NormalRoom normalRoom = new NormalRoom();
            SuiteRoom suiteRoom = new SuiteRoom();
            LuxuryRoom luxuryRoom = new LuxuryRoom();

            Guest guest = new Guest();

            guest.setCheckIn(checkIn);
            guest.setCheckOut(checkOut);

            // First response
            System.out.println(" Welcome to Ban Soi 4 Hotel!!! ");
            System.out.println("--------------------------------------");
            System.out.println(" Would you like to book a room?");
            System.out.println(" [1] Yes or [2] No ");
            System.out.println(" Please enter only number!");

            int reserve = tce.tryPaseInt(" Your selection : ");

            // Reservation
            if (reserve == 1) {

                System.out.println("--------------------------------------");

                // Get checkIn date
                System.out.print(" Enter your date of check-in (dd/mm/yy) : ");
                checkIn.setDate(keyboard.nextLine());

                // Get checkOut date
                System.out.print(" Enter your date of check-out (dd/mm/yy) : ");
                checkOut.setDate(keyboard.nextLine());

                // Get guest quantity
                System.out.println("--------------------------------------");
                System.out.print(" How many guests? : ");
                guest.setMember(keyboard.nextInt());

                do {

                    // Select room function
                    if (guest.getMember() > 0) {

                        // Get room size
                        System.out.println(" Please select room size :");
                        System.out.println("[1] " + normalRoom.getRoomSize() + " [2] " + suiteRoom.getRoomSize()
                                + " [3] " + luxuryRoom.getRoomSize());

                        room = tce.tryPaseInt(" Your choice : ");
                        System.out.println();

                        // Switch for select room
                        switch (room) {

                            // For get normalRoom
                            case 1:

                                guest.setGuestRoom(normalRoom);
                                // Response
                                System.out.print(" Price 1/day for " + guest.getGuestRoom().getRoomSize() + " is $ "
                                        + guest.getGuestRoom().getCost());
                                System.out.println();

                                break;

                            // For get suiteRoom
                            case 2:

                                guest.setGuestRoom(suiteRoom);
                                System.out.print(" Price 1/day for " + guest.getGuestRoom().getRoomSize() + " is $ "
                                        + guest.getGuestRoom().getCost());
                                System.out.println();

                                break;

                            // For get luxuryRoom
                            case 3:

                                guest.setGuestRoom(luxuryRoom);
                                System.out.print(" Price 1/day for " + guest.getGuestRoom().getRoomSize() + " is $ "
                                        + guest.getGuestRoom().getCost());
                                System.out.println();

                                break;

                            // For default response
                            default:

                                System.out.println(" Select 1 2 or 3. Please try again.");
                                System.out.println();

                                break;

                        }

                    } 

                    else if (guest.getMember() > 0) {

                        System.out.println(" Your room  is " + guest.getGuestRoom().getRoomSize() + " room");

                        System.out.println(" Price 1/day for " + guest.getGuestRoom().getRoomSize() + " is $"
                                + guest.getGuestRoom().getCost());

                    } 

                } while (room >= 4);

                System.out.println("--------------------------------------");

                System.out.println(" Your Reservation ");
                System.out.println(" Check - in :" + guest.getCheckIn().getDate());
                System.out.println(" Check - out :" + guest.getCheckOut().getDate());
                System.out.println(" Total days: " + guest.getBetweenDay());
                System.out.println(" Total guests: " + guest.getMember());

                if (room == 1) {
                    System.out.println(" Total price : $ " + guest.getBetweenDay() * 1500);
                }

                else if (room == 2) {
                    System.out.println(" Total price :  $ " + guest.getBetweenDay() * 3000);
                } else {
                    System.out.println(" Total price :  $ " + guest.getBetweenDay() * 6000);
                }
            }
            if (room == 1) {
                System.out.println(" Room type : Normal Room");
            }

            else if (room == 2) {
                System.out.println(" Room type : Sweet room");
            }

            else if (room == 3) {
                System.out.println(" Room type : Luxury room");
            }

            // If doesn't want to reserve
            if (reserve == 2) {
                System.out.println("We're sorry we weren't able to help you.");
            }

            Namearray(guest.getMember());

            // if

            System.out.println("--------------------------------------");

            System.out.println(" Would you like to book another room?");
            System.out.println(" (1) for Booking Room ");
            System.out.println(" (2) for End");

            a = tce.tryPaseInt("You selected: ");

        } while (a != 2);

        System.out.println(" We're glad to be able to help you today.");

        ArrayList<String> rating = new ArrayList<String>();
        rating.add("{1) Poor");
        rating.add("(2) Could be better");
        rating.add("(3) Satisfactory");
        rating.add("(4) Excellent");
        System.out.println("--------------------------------------");
        System.out.println(" Please rate our service today : ");
        System.out.println(rating);
        tce.tryPaseInt(" Your selection : ");
        System.out.println(" Thank you! Your feedback will help us provide better service in the future. ");

        try {
            File file = new File("output.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                try {
                    FileOutputStream fos = new FileOutputStream("output.txt");
                    PrintStream ps = new PrintStream(fos);
                    System.setOut(ps);
                    System.out.println("You have completed a booking today!");
                    System.setOut(ps);
                    ps.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void Namearray(int member1) {

        int[] phNum = new int[2];
        String YN;

        System.out.println("--------------------------------------");
        System.out.print(" Do you want to confirm\n YES or NO:\n:");
        YN = String.valueOf(new Scanner(System.in).nextLine());
        String YN2 = YN.toUpperCase();

        switch (YN2) {

            case "YES":

                System.out.print(" Please give your name : ");
                YN = String.valueOf(new Scanner(System.in).nextLine());

                if (member1 >= 2) {
                    System.out.println(" Please leave two reachable contact numbers : ");
                    for (int i = 0; i < phNum.length; i++) {
                        System.out.print(" : ");
                        phNum[i] = Integer.parseInt(new Scanner(System.in).nextLine());

                    }

                } else {
                    System.out.println(" Thank you for using our services today!");

                }
                break;

            case "NO":

                Stack<String> Thank = new Stack<>();
                Thank.push(" Thank you for your attention.");

                System.out.println("" + Thank.pop());
                break;
        }// switchYN2
    }// Namearray

}// namee