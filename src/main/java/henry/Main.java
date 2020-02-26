package henry;

public class Main {
    public static void main(String[] args) {
        Grocer g = new Grocer();
        String price = g.priceABasketWrapper(args);
        System.out.println("Expected total cost = " + price);
    }
}
