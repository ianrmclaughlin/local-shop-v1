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
    @Test
    public void givenOneAppleBoughtInFuture_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("1 apple, bought in 3 days time,");
        Assert.assertEquals(9,basketPrice);
    }
    @Test
    public void givenOneAppleBoughtInNearFuture_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("1 apple, bought in 2 days time,");
        Assert.assertEquals(10,basketPrice);
    }
    @Test
    public void givenOneAppleBoughtInFarFuture_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("1 apple, bought in 70 days time,");
        Assert.assertEquals(10,basketPrice);
    }
    @Test
    public void givenTwoSoupOneBread_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("2 tins of soup and 1 loaf of bread, bought today,"); // 130 + 80 - 40
        Assert.assertEquals(170,basketPrice);
    }
    @Test
    public void givenSixSoupThreeBread_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("6 tins of soup and 3 loaves of bread, bought today,"); // 390 + 240 - 120
        Assert.assertEquals(510,basketPrice);
    }
    @Test
    public void givenSixSoupTwoBread_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("6 tins of soup and 2 loaves of bread, bought today,"); // 390 + 160 - 80
        Assert.assertEquals(470,basketPrice);
    }
    @Test
    public void givenSixSoupFourBread_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("6 tins of soup and 4 loaves of bread, bought today,"); // 390 + 320 - 120
        Assert.assertEquals(590,basketPrice);
    }
    @Test
    public void givenTwoSoupOneBreadFarFuture_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("2 tins of soup and 1 loaf of bread, bought in 7 days time,"); // 130 + 80 - 0
        Assert.assertEquals(210,basketPrice);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void givenThreeSoupTwoBread_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("3 tins of soup and 2 loaves of bread, bought today,");
        Assert.assertEquals(315,basketPrice);
    }
    @Test
    public void givenSixAppleOneMilk_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("6 apples and a bottle of milk, bought today,");
        Assert.assertEquals(190,basketPrice);
    }
    @Test
    public void givenSixAppleOneMilkFuture_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("6 apples and a bottle of milk, bought in 5 days time,");
        Assert.assertEquals(184,basketPrice);
    }
    @Test
    public void givenThreeAppleTwoSoupOneBreadFuture_whenCalculateBasketPrice_thenReturnCorrectPrice(){
        Grocer grocer = new Grocer();
        long basketPrice = grocer.priceABasket("3 apples, 2 tins of soup and a loaf of bread, bought in 5 days time,");
        Assert.assertEquals(197,basketPrice);
    }













}
