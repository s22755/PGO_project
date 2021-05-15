public class GasContainer extends Container implements Explosible {
    private double pressure;

    public GasContainer(double weight, double length, double width, double height, double maxWeight, double pressure) {
        super(weight, length, width, height, maxWeight);
        this.pressure = pressure;
    }

    @Override
    public void explode() {
        System.out.println("Gas container with serial number:" + this.serialNumber + " exploded!");
    }

    @Override
    public void loadCargo(double mass) throws Exception {
        if(this.weight + mass > this.maxWeight) {
            explode();
            throw OverfillException;
        }
        this.weight += mass;
    }

    @Override
    public void unloadCargo() {
        System.out.println("Unloading " + this.weight + " kg...");
        this.weight = (int)(this.maxWeight * .05);
    }
    @Override
    public String getInfo() {
        return "Type: Gas Container | " + this.weight + " kg | " + this.pressure;
    }
}
