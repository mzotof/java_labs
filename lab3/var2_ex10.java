import java.sql.Time;
import java.util.Scanner;

public class var2_ex10 {
    private static void getTrainsByDestination(Train[] trains, String destination) {
        System.out.println("\nList of trains with destination '" + destination + "':");
        for (Train train : trains) {
            if (train.getDestination().equals(destination)) {
                System.out.println(train);
            }
        }
    }
    private static void getTrainsByDestinationAndDepTime(Train[] trains, String destination, Time depTime) {
        System.out.println("\nList of trains with destination '" + destination +
                "' and departure time > " + depTime + ":");
        for (Train train : trains) {
            if (train.getDestination().equals(destination) && train.getDepartureTime().after(depTime)) {
                System.out.println(train);
            }
        }
    }
    private static void getTrainsWithGenSeatsByDestination(Train[] trains, String destination) {
        System.out.println("\nList of trains with general seats and destination '" + destination + "':");
        for (Train train : trains) {
            if (train.getDestination().equals(destination) && train.getGeneralSeats() > 0) {
                System.out.println(train);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Train[] trains = {
                new Train("Paris", 1, new Time(10, 0, 0), 200, 100, 50, 20),
                new Train("Berlin", 2, new Time(12, 30, 0), 150, 80, 40, 10),
                new Train("London", 3, new Time(14, 45, 0), 250, 120, 60, 30),
                new Train("Paris", 4, new Time(15, 0, 0), 0, 60, 30, 10)
        };
        System.out.println("Enter destination:");
        String destination = in.nextLine();
        getTrainsByDestination(trains, destination);

        System.out.print("\nEnter departure hour: ");
        int hour = in.nextInt();
        System.out.print("Enter departure minute: ");
        int minute = in.nextInt();
        getTrainsByDestinationAndDepTime(trains, destination, new Time(hour, minute, 0));

        getTrainsWithGenSeatsByDestination(trains, destination);

//        Input:
//        Paris
//        9
//        30
    }
}
