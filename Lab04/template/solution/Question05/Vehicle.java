public abstract class Vehicle {
    protected int wheelCount;

    public Vehicle(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public Vehicle() {
        this(0);
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    abstract public String toString();


}

class wheel {
}

class engine {
}