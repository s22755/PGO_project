public class liquidContainer extends Container implements Explosible{
    private boolean isSafe;


    protected liquidContainer(double weight, double length, double width, double height, double maxWeight, boolean isSafe) {
        super(weight, length, width, height, maxWeight);
        this.isSafe = isSafe;
    }

    @Override
    public void explode() {
        System.out.println("Liquid container with serial number: " +this.serialNumber+ " exploded!");
    }

    @Override
    public void loadCargo(double mass) throws Exception {
        if(!isSafe) {
            if(this.weight + mass > this.maxWeight/2) {
                explode();
                throw OverfillException;
            } else {
                this.weight += mass;
                System.out.println("Current load: " + this.weight);
            }
        } else {
            if(this.weight + mass > this.maxWeight * .9) {
                explode();
                throw OverfillException;
            } else {
                this.weight += mass;
                System.out.println("Current load: " + this.weight);
            }
        }
    }
    @Override
    public String getInfo() {
        return "Type: Liquid Container | " + this.weight + " kg | " + (isSafe ? "Safe" : "Not Safe");
    }
}
