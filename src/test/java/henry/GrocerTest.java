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
}
