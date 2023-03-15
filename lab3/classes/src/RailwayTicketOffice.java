import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RailwayTicketOffice {
    private final Scanner in = new Scanner(System.in);
    private final List<TrainForOffice> trains;
    private final List<Ticket> tickets;

    public RailwayTicketOffice() {
        trains = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    public void addTrain(TrainForOffice train) {
        trains.add(train);
    }

    public void findSuitableTrains(Passenger passenger) {
        List<TrainForOffice> suitableTrains = new ArrayList<>();
        for (TrainForOffice train : trains)
            if (train.getDepartureDTTM().equals(passenger.getTravelDTTM()))
                for (String station : train.getStations())
                    if (station.equals(passenger.getDestinationStation()))
                        suitableTrains.add(train);
        if (suitableTrains.size() > 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < suitableTrains.size(); i++)
                sb.append((i + 1) + " - ").append(suitableTrains.get(i)).append("\n");
            System.out.println("\nPlease, choose train:\n" + sb);
            System.out.print("Your choice: ");
            generateInvoice(passenger, suitableTrains.get(in.nextInt() - 1));
        } else {
            System.out.println("\nWe are sorry but there are no suitable trains for you :(");
        }
    }

    private void generateInvoice(Passenger passenger, TrainForOffice train) {
        double price = train.getPrice();
        Ticket ticket = new Ticket(passenger, train);
        tickets.add(ticket);
        System.out.println("\nYou have to pay " + price + " for ticket. Have a pleasant trip!");
        System.out.println("Your ticket:\n" + ticket);
    }

    public String getTrains() {
        StringBuilder sb = new StringBuilder();
        for (TrainForOffice train : trains) {
            sb.append(train).append("\n");
        }
        return sb.toString();
    }

    public String getTickets() {
        StringBuilder sb = new StringBuilder();
        for (Ticket ticket : tickets) {
            sb.append(ticket).append("\n");
        }
        return sb.toString();
    }
}
