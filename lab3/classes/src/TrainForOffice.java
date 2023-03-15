import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class TrainForOffice {
    private final int trainNumber;
    private final LocalDateTime departureDTTM;
    private final String[] stations;
    private final double price;

    public TrainForOffice(int trainNumber, LocalDateTime departureDTTM, String[] stations, double price) {
        this.trainNumber = trainNumber;
        this.departureDTTM = departureDTTM;
        this.stations = stations;
        this.price = price;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public LocalDateTime getDepartureDTTM() {
        return departureDTTM;
    }

    public String[] getStations() {
        return stations;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
        return "Train{" +
                "trainNumber=" + trainNumber +
                ", departureDate='" + formatter.format(departureDTTM) + '\'' +
                ", stations=" + Arrays.toString(stations) +
                ", price=" + price +
                '}';
    }
}
