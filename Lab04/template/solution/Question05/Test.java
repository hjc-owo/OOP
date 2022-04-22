public class Test {
    public static void main(String[] args) {
        Motorbike mb = new Motorbike();
        Brother brother = new Brother("brother");
        Sister sister = new Sister("sister");
        mb.setWheelCount(2);
        mb.setDriver(brother);
        mb.setPassenger(sister);
        System.out.println(mb);
        Car car = new Car();
        car.setWheelCount(4);
        System.out.println(car);
        Tank tank = new Tank();
        tank.setWheelCount(2);
        System.out.println(tank);
    }
}
