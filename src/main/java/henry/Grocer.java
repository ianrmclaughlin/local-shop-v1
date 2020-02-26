package henry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Grocer {
    public long priceABasket(String freeText) {
        String tokenizedBasket = freeText
                .replaceAll("^a ","1 ")
                .replaceAll("tin.*soup",":soup,")
                .replaceAll("loa.*bread",":bread,")
                .replaceAll(" ","")
                ;

        String[] orderArray = tokenizedBasket.split(",");

        Map<String,Long> orderMap = new HashMap<>();

        for ( String orderLine : orderArray ) {
            String[] a = orderLine.split(":");
            String itemName = a[1];
            Long itemCount = Long.parseLong(a[0]);
            orderMap.put(itemName,itemCount);
        }

        long basketCost = 0;

        Collection<String> cs = orderMap.keySet();
        for ( String itemName : cs ) {
            long itemCount = orderMap.get(itemName);
            if(itemName.equals("soup")){
                basketCost = basketCost + itemCount * 65;
            }
            if(itemName.equals("bread")){
                basketCost = basketCost + itemCount * 80;
            }
        }

        return basketCost;


    }
}
