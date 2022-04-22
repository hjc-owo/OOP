public class Motorbike extends Vehicle {
    Person driver;
    Person passenger;

    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    public Person getPassenger() {
        return passenger;
    }

    public void setPassenger(Person passenger) {
        this.passenger = passenger;
    }


    @Override
    public String toString() {
        return "This motorbike has " + wheelCount + " wheels.\n"
                + "The driver is " + driver + " and the passenger is "+ passenger
                + ".\nThe passenger says: " + passenger.say();
    }
}
