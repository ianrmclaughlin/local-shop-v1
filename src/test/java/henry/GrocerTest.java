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
    @Test
    public void givenASoup_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("a tin of soup");
        Assert.assertEquals(65,basketPrice);
    }
    @Test
    public void givenThreeBread_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("3 loaves of bread");
        Assert.assertEquals(240,basketPrice);
    }
    @Test
    public void givenABread_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("a loaf of bread");
        Assert.assertEquals(80,basketPrice);
    }
    @Test
    public void givenThreeMilk_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("3 bottles of milk");
        Assert.assertEquals(390,basketPrice);
    }
    @Test
    public void givenAnApple_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("an apple");
        Assert.assertEquals(10,basketPrice);
    }
    @Test
    public void givenThreeApples_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("3 apples");
        Assert.assertEquals(30,basketPrice);
    }
    @Test
    public void givenMultipleItems_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("4 loaves of bread, 3 bottles of milk, 2 apples and a tin of soup");
        Assert.assertEquals(795,basketPrice);
    }
    @Test
    public void givenOneSoupBoughtToday_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("1 tin of soup, bought today,");
        Assert.assertEquals(65,basketPrice);
    }







}
