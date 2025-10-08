package laba2;

abstract class Vehicle {
    private String brand;
    private int year;
    private double maxSpeed;
    private static int totalVehicles = 0;

    public Vehicle(String brand, int year, double maxSpeed) {
        this.brand = brand;
        this.year = year;
        this.maxSpeed = maxSpeed;
        totalVehicles++;
    }

    public Vehicle() {
        this("Неизвестно", 2000, 100);
    }

    public abstract void move();

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getMaxSpeed() { return maxSpeed; }
    public void setMaxSpeed(double maxSpeed) { this.maxSpeed = maxSpeed; }

    public void showInfo() {
        System.out.println("Марка: " + brand + ", Год: " + year + ", Макс. скорость: " + maxSpeed + " км/ч");
    }

    public static int getTotalVehicles() {
        return totalVehicles;
    }
}

abstract class LandVehicle extends Vehicle {
    private int wheels;

    public LandVehicle(String brand, int year, double maxSpeed, int wheels) {
        super(brand, year, maxSpeed);
        this.wheels = wheels;
    }

    public LandVehicle() {
        this("Неизвестно", 2000, 100, 4);
    }

    public int getWheels() { return wheels; }
    public void setWheels(int wheels) { this.wheels = wheels; }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Количество колёс: " + wheels);
    }
}

class Car extends LandVehicle {
    private int passengers;

    public Car(String brand, int year, double maxSpeed, int wheels, int passengers) {
        super(brand, year, maxSpeed, wheels);
        this.passengers = passengers;
    }

    public Car() {
        this("Toyota", 2020, 200, 4, 5);
    }

    public int getPassengers() { return passengers; }
    public void setPassengers(int passengers) { this.passengers = passengers; }

    @Override
    public void move() {
        System.out.println("Легковой автомобиль едет по дороге.");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Количество пассажиров: " + passengers);
    }
}

class Truck extends LandVehicle {
    private double loadCapacity;

    public Truck(String brand, int year, double maxSpeed, int wheels, double loadCapacity) {
        super(brand, year, maxSpeed, wheels);
        this.loadCapacity = loadCapacity;
    }

    public Truck() {
        this("Volvo", 2018, 140, 6, 20.0);
    }

    public double getLoadCapacity() { return loadCapacity; }
    public void setLoadCapacity(double loadCapacity) { this.loadCapacity = loadCapacity; }

    @Override
    public void move() {
        System.out.println("Грузовой автомобиль перевозит грузы.");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Грузоподъёмность: " + loadCapacity + " тонн");
    }
}

class Motorcycle extends LandVehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, int year, double maxSpeed, int wheels, boolean hasSidecar) {
        super(brand, year, maxSpeed, wheels);
        this.hasSidecar = hasSidecar;
    }

    public Motorcycle() {
        this("Yamaha", 2022, 180, 2, false);
    }

    public boolean hasSidecar() { return hasSidecar; }
    public void setSidecar(boolean hasSidecar) { this.hasSidecar = hasSidecar; }

    @Override
    public void move() {
        System.out.println("Мотоцикл мчится по дороге.");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Есть коляска: " + (hasSidecar ? "Да" : "Нет"));
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("BMW", 2023, 250, 4, 5);
        Truck truck = new Truck("MAN", 2020, 140, 8, 30.5);
        Motorcycle bike = new Motorcycle("Ducati", 2024, 280, 2, false);

        car.showInfo();
        truck.showInfo();
        bike.showInfo();

        System.out.println("Всего создано транспортных средств: " + Vehicle.getTotalVehicles());
    }
}

