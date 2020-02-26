package henry;

import org.junit.Assert;
import org.junit.Test;

public class GrocerTest {
    @Test
    public void givenOneSoup_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("1 tin of soup");
        Assert.assertEquals(65,basketPrice);
    }
    @Test
    public void givenTwoSoup_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("2 tins of soup");
        Assert.assertEquals(130,basketPrice);
    }
    @Test
    public void givenThreeSoup_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("3 tins of soup");
        Assert.assertEquals(195,basketPrice);
    }


}
