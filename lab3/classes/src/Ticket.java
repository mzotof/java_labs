public class Ticket {
    private final Passenger passenger;
    private final TrainForOffice train;

    public Ticket(Passenger passenger, TrainForOffice train) {
        this.passenger = passenger;
        this.train = train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public TrainForOffice getTrain() {
        return train;
    }

    public String toString() {
        return "Ticket{" +
                "passenger=" + passenger +
                ", train='" + train + '\'' +
                '}';
    }
}
