// Q04

// a)
class Vehicle {
    protected String vehicleName;


    public Vehicle() {
        this("Unknown Vehicle");
    }


    public Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    // a)
    public void displayVehicleDetails() {
        System.out.println("Vehicle Name: " + vehicleName);
    }

    // b)
    public double calculateSpeed() {
        return 0.0;
    }


    public double calculateSpeed(double factor) {
        return calculateSpeed() * factor;
    }
}

// c)
class Car extends Vehicle {
    private int engineCapacity;
    private double topSpeed;

    // e)
    public Car() {
        this("Car", 0, 0.0);
    }

    public Car(String vehicleName, int engineCapacity, double topSpeed) {
        super(vehicleName);
        this.engineCapacity = engineCapacity;
        this.topSpeed = topSpeed;
    }

    // c)
    @Override
    public double calculateSpeed() {
        return topSpeed;
    }

    // c)
    @Override
    public void displayVehicleDetails() {
        super.displayVehicleDetails();
        System.out.println("Engine Capacity: " + engineCapacity + " CC");
        System.out.println("Top Speed: " + calculateSpeed() + " km/h");
    }
}

// d)
class Bicycle extends Vehicle {
    private int gearCount;
    private double maxPedalSpeed;


    public Bicycle() {
        this("Bicycle", 0, 0.0);
    }

    // e)
    public Bicycle(String vehicleName, int gearCount, double maxPedalSpeed) {
        super(vehicleName);
        this.gearCount = gearCount;
        this.maxPedalSpeed = maxPedalSpeed;
    }

    // d)
    @Override
    public double calculateSpeed() {
        return maxPedalSpeed;
    }


    @Override
    public void displayVehicleDetails() {
        super.displayVehicleDetails();
        System.out.println("Gear Count: " + gearCount);
        System.out.println("Maximum Pedaling Speed: "
                + calculateSpeed() + " km/h");
    }
}

// e)
public class VehicleApp {
    public static void main(String[] args) {


        Car car = new Car();


        Bicycle bicycle = new Bicycle("Mountain Bicycle", 21, 40.0);

        System.out.println("Car");


        car.displayVehicleDetails();


        System.out.println("Original Speed: "
                + car.calculateSpeed() + " km/h");
        System.out.println("Scaled Speed (factor 0.5): "
                + car.calculateSpeed(0.5) + " km/h");

        System.out.println();
        System.out.println("Bicycle");


        bicycle.displayVehicleDetails();


        System.out.println("Original Speed: "
                + bicycle.calculateSpeed() + " km/h");
        System.out.println("Scaled Speed (factor 0.5): "
                + bicycle.calculateSpeed(0.5) + " km/h");
    }
}