import java.sql.Time;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Train {
    private String destination;
    private int trainNumber;
    private Time departureTime;
    private int generalSeats;
    private int compartmentSeats;
    private int reservedSeats;
    private int suiteSeats;

    public Train(String destination, int trainNumber, Time departureTime,
                 int generalSeats, int compartmentSeats, int reservedSeats, int suiteSeats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.generalSeats = generalSeats;
        this.compartmentSeats = compartmentSeats;
        this.reservedSeats = reservedSeats;
        this.suiteSeats = suiteSeats;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public int getGeneralSeats() {
        return generalSeats;
    }

    public void setGeneralSeats(int generalSeats) {
        this.generalSeats = generalSeats;
    }

    public int getCompartmentSeats() {
        return compartmentSeats;
    }

    public void setCompartmentSeats(int compartmentSeats) {
        this.compartmentSeats = compartmentSeats;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public int getSuiteSeats() {
        return suiteSeats;
    }

    public void setSuiteSeats(int suiteSeats) {
        this.suiteSeats = suiteSeats;
    }

    public String toString() {
        return "Train{" +
                "destination='" + destination + '\'' +
                ", trainNumber=" + trainNumber +
                ", departureTime='" + departureTime + '\'' +
                ", generalSeats=" + generalSeats +
                ", compartmentSeats=" + compartmentSeats +
                ", reservedSeats=" + reservedSeats +
                ", suiteSeats=" + suiteSeats +
                '}';
    }
}

class TrainNotFoundException extends Exception {
    private final String message;
    public String getMessage() {
        return message;
    }
    public TrainNotFoundException(String[] param_names, String[] param_values){
        super();
        StringBuilder sb = new StringBuilder("Продукты с ");
        for (int i = 0; i < param_names.length; i++)
            sb.append(param_names[i]).append(" \"").append(param_values[i]).append("\" и ");
        sb.delete(sb.length() - 3, sb.length()).append(" не найдены");
        message = sb.toString();
    }
}
public class var2_ex10 {
    private static List<Train> getTrainsByDestination(Train[] trains, String destination) throws TrainNotFoundException {
        List<Train> res = new ArrayList<>();
        for (Train train : trains)
            if (train.getDestination().equals(destination))
                res.add(train);
        if (res.size() == 0)
            throw new TrainNotFoundException(new String[]{"пунктом назначения"}, new String[]{destination});
        return res;
    }
    private static List<Train> getTrainsByDestinationAndDepTime(Train[] trains, String destination, Time depTime) throws TrainNotFoundException {
        List<Train> res = new ArrayList<>();
        for (Train train : trains)
            if (train.getDestination().equals(destination) && train.getDepartureTime().after(depTime))
                res.add(train);
        if (res.size() == 0)
            throw new TrainNotFoundException(new String[]{"пунктом назначения", "временем отправления >"},
                    new String[]{destination, depTime.toString()});
        return res;
    }
    private static List<Train> getTrainsWithGenSeatsByDestination(Train[] trains, String destination) throws TrainNotFoundException {
        List<Train> res = new ArrayList<>();
        for (Train train : trains)
            if (train.getDestination().equals(destination) && train.getGeneralSeats() > 0)
                res.add(train);
        if (res.size() == 0)
            throw new TrainNotFoundException(new String[]{"пунктом назначения", "количеством общих мест >"},
                    new String[]{destination, "0"});
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Train[] trains = {
                new Train("Париж", 1, new Time(10, 0, 0), 200, 100, 50, 20),
                new Train("Бердин", 2, new Time(12, 30, 0), 150, 80, 40, 10),
                new Train("Лондон", 3, new Time(14, 45, 0), 250, 120, 60, 30),
                new Train("Париж", 4, new Time(15, 0, 0), 0, 60, 30, 10)
        };
        System.out.print("Введите пункт назначения: ");
        String destination = in.nextLine();
        try {
            List<Train> trainsByDestination = getTrainsByDestination(trains, destination);
            System.out.println("\nСписок поездов с пунктом назначения '" + destination + "':");
            for (Train train : trainsByDestination)
                System.out.println(train);
        } catch (TrainNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("\nВведите час отправления: ");
        int hour;
        try {
            hour = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо ввести число типа int");
            return;
        }
        System.out.print("Введите минуту отправления: ");
        int minute;
        try {
            minute = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо ввести число типа int");
            return;
        }
        Time depTime = new Time(hour, minute, 0);
        try {
            List<Train> trainsByDestinationAndDepTime = getTrainsByDestinationAndDepTime(trains, destination, depTime);
            System.out.println("\nСписок поездов с пунктом назначения '" + destination + "' и временем отправления > " + depTime + ":");
            for (Train train : trainsByDestinationAndDepTime)
                System.out.println(train);
        } catch (TrainNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            List<Train> trainsWithGenSeatsByDestination = getTrainsWithGenSeatsByDestination(trains, destination);
            System.out.println("\nСписок поездов со свободными общими местами и пунктом назначения '" + destination + "':");
            for (Train train : trainsWithGenSeatsByDestination)
                System.out.println(train);
        } catch (TrainNotFoundException e) {
            System.out.println("\n" + e.getMessage());
        }
    }
}
