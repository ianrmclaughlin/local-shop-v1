package henry;

import java.util.*;

public class Grocer {

    final int SOUP_PRICE = 65;
    final int BREAD_PRICE = 80;
    final int MILK_PRICE = 130;
    final int APPLE_PRICE = 10;
    final int APPLE_PRICE_DISCOUNTED = 9;
    final int ONE_DAY = 86400000;
    final int BREAD_DISCOUNT_PERIOD = 7;
    final int BREAD_PRICE_REDUCTION = 40;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public long priceABasket(String freeText) {
        long dayOffset = getDayOffset(freeText);
        freeText = freeText.replaceAll(", bought in.*", "");
        String tokenizedBasket = getTokenizedBasket(freeText);
        Map<String, Long> orderMap = getOrderMap(tokenizedBasket);
        long basketCost = getBasketCost(orderMap, dayOffset);
        return basketCost;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private long getDayOffset(String basketContents) {
        long dayOffset = 0;
        if (basketContents.contains("bought in")) {
            String dayOffsetStr = basketContents
                    .replaceAll(".*bought in ", "")
                    .replaceAll("days time,", "")
                    .replaceAll(" ", "");
            dayOffset = Long.parseLong(dayOffsetStr);
        }
        return dayOffset;
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
    private long getBasketCost(Map<String, Long> orderMap, long dayOffset) {
        long breadDiscount = getBreadDiscount(orderMap, dayOffset);
        long applePrice = getApplePrice(dayOffset);
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
                basketCost = basketCost + itemCount * applePrice;
            }
        }
        return basketCost - breadDiscount;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    long getApplePrice(long dayOffset) {
        long applePrice = APPLE_PRICE_DISCOUNTED;
        Date today = new Date();
        Date nextMonthLastDate = getNextMonthLastDate(today);
        long ms = today.getTime();
        ms = ms + (ONE_DAY * dayOffset);
        Date purchaseDate = new Date(ms);
        if (purchaseDate.after(nextMonthLastDate) || dayOffset < 3) {
            applePrice = APPLE_PRICE;
        }
        return applePrice;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    Date getNextMonthLastDate(Date nowDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(nowDate);
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DATE, c.getMaximum(Calendar.DATE));
        Date nextDate = c.getTime();
        return nextDate;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private long getBreadDiscount(Map<String, Long> orderLines, long dayOffset) {
        if (dayOffset >= BREAD_DISCOUNT_PERIOD) {
            return 0;
        }
        long breadDiscount = 0;
        long breadCount = 0;
        long soupCount = 0;
        try {
            soupCount = orderLines.get("soup");
            breadCount = orderLines.get("bread");
        } catch (Exception e) {
            // Do nothing if no soup or bread
        }
        long maxDiscount = (soupCount / 2) * BREAD_PRICE_REDUCTION;
        long possibleDiscount = breadCount * BREAD_PRICE_REDUCTION;
        if (maxDiscount > possibleDiscount) {
            breadDiscount = possibleDiscount;
        } else {
            breadDiscount = maxDiscount;
        }
        return breadDiscount;
    }


}
