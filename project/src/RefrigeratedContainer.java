import java.util.Random;

public class RefrigeratedContainer extends Container {

    private static String[][] possibleProducts;
    private String product;
    private double temperature;
    private Exception ProductNotFound;
    static {
        //s22755
        possibleProducts = new String[][]{new String[]{"Ryba","2"}, new String[]{"Mrożona pizza","-30"}, new String[]{"Parówki","5"}};

    }

    public RefrigeratedContainer(double weight, double length, double width, double height, double maxWeight, String product) throws Exception {
        super(weight, length, width, height, maxWeight);
        for (String[] possibleProduct : possibleProducts) {
            if (possibleProduct[0].contains(product)) {
                this.product = product;
                temperature = Double.parseDouble(possibleProduct[1]);
            } else {
                System.out.println("Please enter product from the list!");
                throw ProductNotFound;
            }
        }
    }
    public RefrigeratedContainer(double weight, double length, double width, double height, double maxWeight) throws Exception {
        super(weight, length, width, height, maxWeight);
        Random rand = new Random();
        int temp = rand.nextInt(possibleProducts.length);
        this.product = possibleProducts[temp][0];
        this.temperature = Double.parseDouble(possibleProducts[temp][1]);
    }
    @Override
    public String getInfo() {
        return "Type: Refrigerated Container | "+ this.product + " | " + this.temperature;
    }
}
