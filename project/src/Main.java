
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void check(int a) throws Exception {
        if(a<1) throw new Exception("Use positive integers!");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Zadanie 1
	    ContainerShip ship = ContainerShip.createShip(rand.nextInt(50) + 40);

        // Zadanie 2
        System.out.println("Enter quantity between 1 and " +22755*5 + ": ");
        int quantity = sc.nextInt();
        sc.nextLine();
        check(quantity);
        System.out.println("Enter container type [Gas, Liquid, Refrigerated]: ");
        String type = sc.nextLine();
        switch(type.toLowerCase()) {
            case "gas":
                for(int i = 0;i<quantity;i++) {
                    ship.addContainer(new GasContainer(rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextDouble()));
                }
                break;
            case "liquid":
                for(int i = 0;i<quantity;i++) {
                    ship.addContainer(new liquidContainer(rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextBoolean()));
                }
                break;
            case "refrigerated":
                for(int i = 0;i<quantity;i++) {
                    ship.addContainer(new RefrigeratedContainer(rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextDouble()));
                }
                break;
            default:
                throw new Exception("Use containers from the list!");
        }
        // Zadanie 3
        ContainerShip ship2 = ContainerShip.createShip(rand.nextInt(50)+40);

        // Zadanie 4
        ContainerShip.transportContainers(ship, ship2);

        // Zadanie 5
        ship.unloadContainers();
        ship2.unloadContainers();

        // Zadanie 6
        System.out.println("Enter quantity between 1 and "+ship2.getContainers().size()+": ");
        quantity = sc.nextInt();
        sc.nextLine();
        check(quantity);
        System.out.println("Enter container type [Gas, Liquid, Refrigerated]: ");
        type = sc.nextLine().replace("\n","");
        switch (type.toLowerCase()) {
            case "gas":
                for (int i = 0; i < quantity; i++) {
                    ship2.changeContainer(i, new GasContainer(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble()));
                }
                break;
            case "liquid":
                for (int i = 0; i < quantity; i++) {
                    ship2.changeContainer(i, new liquidContainer(rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextBoolean()));
                }
                break;
            case "refrigerated":
                for (int i = 0; i < quantity; i++) {
                    ship2.changeContainer(i, new RefrigeratedContainer(rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextDouble()));
                }
                break;
            default:
                throw new Exception("Use containers from the list!");
        }

        // Zadanie 7
        // s22755 - nieparzysta
        for(int i = 0; i < ship2.getContainers().size();i++) {
            if(i%2 ==0) continue;
            ship2.deleteContainer(i);
        }

        // Zadanie 8
        for(Container a: ship2.getContainers()) {
            System.out.println(a.getInfo());
        }
    }
}
