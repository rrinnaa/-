abstract class Bicycle {
    // Поля
    private String brand;
    private String model;
    private int gearCount;


    private static int bicycleCount = 0;


    public Bicycle() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.gearCount = 1;
        bicycleCount++;
    }


    public Bicycle(String brand, String model, int gearCount) {
        this.brand = brand;
        this.model = model;
        this.gearCount = gearCount;
        bicycleCount++;
    }


    public abstract void ride(); // Езда на велосипеде
    public abstract void brake(); // Торможение


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGearCount() {
        return gearCount;
    }

    public void setGearCount(int gearCount) {
        this.gearCount = gearCount;
    }


    public static int getBicycleCount() {
        return bicycleCount;
    }


    public void showInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Gears: " + gearCount);
    }
}


class MountainBike extends Bicycle {
    private String suspensionType;


    public MountainBike() {
        super();
        this.suspensionType = "Standard";
    }


    public MountainBike(String brand, String model, int gearCount, String suspensionType) {
        super(brand, model, gearCount);
        this.suspensionType = suspensionType;
    }


    public String getSuspensionType() {
        return suspensionType;
    }

    public void setSuspensionType(String suspensionType) {
        this.suspensionType = suspensionType;
    }


    @Override
    public void ride() {
        System.out.println("Riding a mountain bike with " + getSuspensionType() + " suspension.");
    }


    @Override
    public void brake() {
        System.out.println("Braking the mountain bike.");
    }
}


class KidsBike extends Bicycle {
    private boolean hasTrainingWheels;


    public KidsBike() {
        super();
        this.hasTrainingWheels = true;
    }


    public KidsBike(String brand, String model, int gearCount, boolean hasTrainingWheels) {
        super(brand, model, gearCount);
        this.hasTrainingWheels = hasTrainingWheels;
    }


    public boolean isHasTrainingWheels() {
        return hasTrainingWheels;
    }

    public void setHasTrainingWheels(boolean hasTrainingWheels) {
        this.hasTrainingWheels = hasTrainingWheels;
    }


    @Override
    public void ride() {
        if (hasTrainingWheels) {
            System.out.println("Riding a kids bike with training wheels.");
        } else {
            System.out.println("Riding a kids bike without training wheels.");
        }
    }


    @Override
    public void brake() {
        System.out.println("Braking the kids bike.");
    }
}


class BMX extends Bicycle {
    private boolean hasPegs;


    public BMX() {
        super();
        this.hasPegs = false;
    }


    public BMX(String brand, String model, int gearCount, boolean hasPegs) {
        super(brand, model, gearCount);
        this.hasPegs = hasPegs;
    }


    public boolean isHasPegs() {
        return hasPegs;
    }

    public void setHasPegs(boolean hasPegs) {
        this.hasPegs = hasPegs;
    }


    @Override
    public void ride() {
        if (hasPegs) {
            System.out.println("Riding a BMX with pegs for stunts.");
        } else {
            System.out.println("Riding a BMX without pegs.");
        }
    }


    @Override
    public void brake() {
        System.out.println("Braking the BMX.");
    }
}


public class Main {
    public static void main(String[] args) {

        MountainBike mtb = new MountainBike("Trek", "X-Caliber", 21, "Full");
        KidsBike kidsBike = new KidsBike("Giant", "Kids Pro", 1, true);
        BMX bmx = new BMX("Mongoose", "Legion", 1, true);

        // Вызов методов
        mtb.showInfo();
        mtb.ride();
        mtb.brake();

        kidsBike.showInfo();
        kidsBike.ride();
        kidsBike.brake();

        bmx.showInfo();
        bmx.ride();
        bmx.brake();


        System.out.println("Total bicycles created: " + Bicycle.getBicycleCount());
    }
}
