
import java.util.ArrayList;

public class ContainerShip {
    public static ContainerShip createShip;
    private ArrayList<Container> containers;
    private double maxSpeed;
    private static int maxContainers;

    static {
        maxContainers = 22755 * 5;
    }

    private ContainerShip(double maxSpeed) {
        this.maxSpeed = maxSpeed;
        this.containers = new ArrayList<Container>();
    }
    private ContainerShip(double maxSpeed, ArrayList<Container> containers) {
        this.maxSpeed = maxSpeed;
        this.containers = containers;
    }

    public static ContainerShip createShip(double maxSpeed) {
        return new ContainerShip(maxSpeed);
    }
    public static ContainerShip createShip(double maxSpeed, ArrayList<Container> containers) {
        return new ContainerShip(maxSpeed,containers);
    }

    public void addContainer(Container container) {
        if(containers.size() < maxContainers) this.containers.add(container);

    }
    public void addContainer(ArrayList<Container> containers) {
        this.containers.addAll(containers);
    }
    public void deleteContainer(Container container) {
        this.containers.remove(container);
    }
    public void deleteContainer(int i) {
        this.containers.remove(i);
    }
    public void deleteContainer(ArrayList<Container> containers) {
        this.containers.removeAll(containers);
    }
    public void changeContainer(int index, Container container) {
        this.containers.remove(index);
        this.containers.add(index,container);
    }
    public ArrayList<Container> getContainers() {
        return this.containers;
    }
    public static void transportContainers(ContainerShip shipFrom, ContainerShip shipTo) {
        shipTo.addContainer(shipFrom.getContainers());
        shipFrom.deleteContainer(shipFrom.getContainers());
    }

    public void unloadContainers() {
        for(Container a : this.containers) {
            a.unloadCargo();
        }
    }
}
