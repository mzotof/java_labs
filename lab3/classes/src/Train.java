import java.sql.Time;

public class Train {
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
