import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class var4_ex10 {
    public static void main(String[] args) {
        String[] stations1 = {
                "Moscow", "Paris", "Rome"
        };
        TrainForOffice train1 = new TrainForOffice(1,
                LocalDateTime.of(2022, 4, 1, 17, 30),
                stations1, 100);
        String[] stations2 = {
                "Moscow", "Paris", "Rome"
        };
        TrainForOffice train2 = new TrainForOffice(2,
                LocalDateTime.of(2023, 3, 15, 12, 0),
                stations2, 300);
        String[] stations3 = {
                "Moscow", "Berlin", "Rome"
        };
        TrainForOffice train3 = new TrainForOffice(3,
                LocalDateTime.of(2023, 3, 15, 12, 0),
                stations3, 150);
        String[] stations4 = {
                "Moscow", "Minsk", "Paris"
        };
        TrainForOffice train4 = new TrainForOffice(4,
                LocalDateTime.of(2023, 3, 15, 12, 0),
                stations4, 200);

        RailwayTicketOffice office = new RailwayTicketOffice();
        AdministratorOffice administrator = new AdministratorOffice(office);

        administrator.addTrain(train1);
        administrator.addTrain(train2);
        administrator.addTrain(train3);
        administrator.addTrain(train4);

        System.out.println("Trains:\n" + office.getTrains());

        Passenger passenger1 = new Passenger("Ivan", "Paris",
                LocalDateTime.of(2023, 3, 15, 12, 0));

        System.out.println("Passenger1:\n" + passenger1);

        office.findSuitableTrains(passenger1);

        Passenger passenger2 = new Passenger("Peter", "Istanbul",
                LocalDateTime.of(2023, 3, 15, 12, 0));

        System.out.println("\nPassenger2:\n" + passenger2);

        office.findSuitableTrains(passenger2);

        Passenger passenger3 = new Passenger("Anna", "Rome",
                LocalDateTime.of(2023, 4, 1, 9, 45));

        System.out.println("\nPassenger3:\n" + passenger3);

        office.findSuitableTrains(passenger3);
    }
}
