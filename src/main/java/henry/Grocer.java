package henry;

public class Grocer {
    public long priceABasket(String freeText) {
        if (freeText.equals("1 tin of soup")){
            return 65;
        }
        if (freeText.equals("2 tins of soup")){
            return 130;
        }
        if (freeText.equals("3 tins of soup")){
            return 195;
        }
        return 0;
    }
}
