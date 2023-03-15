public class AdministratorOffice {
    private final RailwayTicketOffice railwayTicketOffice;

    public AdministratorOffice(RailwayTicketOffice railwayTicketOffice) {
        this.railwayTicketOffice = railwayTicketOffice;
    }

    public RailwayTicketOffice getRailwayTicketOffice() {
        return railwayTicketOffice;
    }

    public void addTrain(TrainForOffice train) {
        railwayTicketOffice.addTrain(train);
    }
}
