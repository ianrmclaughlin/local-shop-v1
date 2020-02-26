package henry;

public class Grocer {
    public long priceABasket(String freeText) {
        String tokenizedBasket = freeText
                .replaceAll("tin.*soup",":soup")
                .replaceAll(" ","")
                ;

        String[] a = tokenizedBasket.split(":");

        long count = Long.parseLong(a[0]);

        long itemCost = count * 65;

        return itemCost;
    }
}
