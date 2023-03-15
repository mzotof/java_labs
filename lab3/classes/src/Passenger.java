import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Passenger {
    private final String name;
    private final String destinationStation;
    private final LocalDateTime travelDTTM;

    public Passenger(String name, String destinationStation, LocalDateTime travelDTTM) {
        this.name = name;
        this.destinationStation = destinationStation;
        this.travelDTTM = travelDTTM;
    }

    public String getName() {
        return name;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public LocalDateTime getTravelDTTM() {
        return travelDTTM;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
        return "Passenger{" +
                "name=" + name +
                ", destinationStation='" + destinationStation + '\'' +
                ", travelDate='" + formatter.format(travelDTTM) + '\'' +
                '}';
    }
}
