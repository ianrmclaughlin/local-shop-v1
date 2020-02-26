package henry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Grocer {

    final int SOUP_PRICE = 65;
    final int BREAD_PRICE = 80;
    final int MILK_PRICE = 130;
    final int APPLE_PRICE = 10;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public long priceABasket(String freeText) {
        String tokenizedBasket = getTokenizedBasket(freeText);
        Map<String, Long> orderMap = getOrderMap(tokenizedBasket);
        long basketCost = getBasketCost(orderMap);
        return basketCost;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String getTokenizedBasket(String freeText) {
        String tokenizedBasket = freeText
                .replaceAll("bought today", " ")
                .replaceAll(" and ", " ")
                .replaceAll(",", " ")
                .replaceAll(" a ", " 1 ")
                .replaceAll(" an ", " 1 ")
                .replaceAll("^a ", "1 ")
                .replaceAll("^an ", "1 ")
                .replaceAll("tin.*soup", ":soup,")
                .replaceAll("loa.*bread", ":bread,")
                .replaceAll("bot.*milk", ":milk,")
                .replaceAll("apples?", ":apple,")
                .replaceAll(" ", "");
        return tokenizedBasket;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Map<String, Long> getOrderMap(String tokenizedBasket) {
        String[] orderArray = tokenizedBasket.split(",");
        Map<String, Long> orderMap = new HashMap<>();
        for (String orderLine : orderArray) {
            String[] a = orderLine.split(":");
            String itemName = a[1];
            Long itemCount = Long.parseLong(a[0]);
            orderMap.put(itemName, itemCount);
        }
        return orderMap;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private long getBasketCost(Map<String, Long> orderMap) {
        long basketCost = 0;
        Collection<String> cs = orderMap.keySet();
        for (String itemName : cs) {
            long itemCount = orderMap.get(itemName);
            if (itemName.equals("soup")) {
                basketCost = basketCost + itemCount * SOUP_PRICE;
            }
            if (itemName.equals("bread")) {
                basketCost = basketCost + itemCount * BREAD_PRICE;
            }
            if (itemName.equals("milk")) {
                basketCost = basketCost + itemCount * MILK_PRICE;
            }
            if (itemName.equals("apple")) {
                basketCost = basketCost + itemCount * APPLE_PRICE;
            }
        }
        return basketCost;
    }

}
