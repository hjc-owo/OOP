import java.util.List;

public class Ticket {
    private final Train train;
    private final Line line;
    private final String startStation;
    private final String endStation;
    private final String seat;
    private int number;
    private double price;
    private final double unitPrice;
    private String isPaid;
    private int numberOfStudent;

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    public Train getTrain() {
        return train;
    }

    public Line getLine() {
        return line;
    }

    public String getStartStation() {
        return startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public String getSeat() {
        return seat;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    public Ticket(Train train, Line line, String startStation, String endStation, String seat,
                  int number, double unitPrice, double price, int numberOfStudent) {
        this.train = train;
        this.line = line;
        this.startStation = startStation;
        this.endStation = endStation;
        this.seat = seat;
        this.number = number;
        this.unitPrice = unitPrice;
        this.price = price;
        this.isPaid = "F";
        this.numberOfStudent = numberOfStudent;
    }

    public static Ticket getTicketByTrainAndStation(List<Ticket> tickets, Train train, String startStation, String endStation) {
        for (Ticket ticket : tickets) {
            if (ticket.train.id.equals(train.id) && ticket.startStation.equals(startStation) && ticket.endStation.equals(endStation)) {
                return ticket;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "[" + train.id + ": " + startStation + "->" + endStation +
                "] seat:" + seat + " num:" + number + " price:" + String.format("%.2f", unitPrice * number) + " paid:" + isPaid;
    }
}
