public class Ticket {
    private final Train train;
    private final Line line;
    private final String startStation;
    private final String endStation;
    private final String seat;
    private final int number;
    private final double price;


    public Ticket(Train train, Line line, String startStation, String endStation, String seat, int number, double price) {
        this.train = train;
        this.line = line;
        this.startStation = startStation;
        this.endStation = endStation;
        this.seat = seat;
        this.number = number;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + train.id + ": " + startStation + "->" + endStation +
                "] seat:" + seat + " num:" + number + " price:" + String.format("%.2f", price);
    }
}
