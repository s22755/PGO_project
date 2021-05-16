import java.util.Arrays;
import java.util.Random;

public class Container {

    protected double weight;

    protected double length;
    protected double width;
    protected double height;

    protected int serialNumber;
    protected static int[] takenNumbers;

    protected double maxWeight;

    protected Container(double weight, double length, double width, double height, double maxWeight) {
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.maxWeight = maxWeight;

        Random rand = new Random();
        while (true) {
            int temp = rand.nextInt(22755);
            if (!Arrays.asList(takenNumbers).contains(temp)) {
                this.serialNumber = temp;
                break;
            };
        }
    }

    protected void unloadCargo() {
        System.out.println("Unloading " + this.weight + " kg...");
        this.weight = 0;
    }

    protected void loadCargo(double mass) throws OverfillException {
        if(this.weight + mass > this.maxWeight) {
            throw new OverfillException("");
        }
        this.weight += mass;
        System.out.println("Current mass: " + this.weight);
    }

    protected void unloadCargo(int mass) {
        this.weight = Math.max(0,this.weight - mass);
        System.out.println("Unloading " + mass + " kg...");
    }
    public String getInfo() {return "Container";};
}