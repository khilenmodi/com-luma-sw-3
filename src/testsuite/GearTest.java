package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart()throws InterruptedException{
        //* Mouse Hover on Gear Menu
        WebElement gearMenu = driver.findElement(By.xpath("//span[contains(text(),'Gear')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(gearMenu).click().build().perform();

        Thread.sleep(1000);
        //* Click on Bags
        clickOnElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/span[1]"));

        //* Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));

        //* Verify the text ‘Overnight Duffle’
        String verifyText = "Overnight Duffle";
        String actualVerifyText = driver.findElement(By.xpath("//span [text() = 'Overnight Duffle']")).getText();
        Assert.assertEquals(verifyText,actualVerifyText);

        //* Change Qty 3
        driver.findElement(By.id("qty")).clear();
        driver.findElement(By.id("qty")).sendKeys("3");

        //* Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button [@title = 'Add to Cart']"));

        //* Verify the text‘You added Overnight Duffle to your shopping cart.’
        String expectedMessage = "You added Overnight Duffle to your shopping cart.";
        String actualMessage = driver.findElement(By.xpath("//div [@data-bind = 'html: $parent.prepareMessageForHtml(message.text)']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        //* Click on ‘shopping cart’ Link into message

        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //* Verify the product name ‘Overnight Duffle’
        String productName = "Overnight Duffle";
        String actualProductName = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']")).getText();
        Assert.assertEquals(productName,actualProductName);
        //* Verify the Qty is ‘3’
        /*String verifyQty = "3";
        String actualVerifyQty = driver.findElement(By.name("cart[237972][qty]")).getText();
        Assert.assertEquals(verifyQty,actualVerifyQty);*/

        //* Verify the product price ‘$135.00’
        String productPrice = "$135.00";
        String actualProductPrice = driver.findElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']")).getText();
        Assert.assertEquals(productPrice,actualProductPrice);

        //* Change Qty to ‘5’
        driver.findElement(By.xpath("//input[@id='cart-237972-qty']")).clear();
        //clickOnElement(By.xpath("//tbody/tr[2]/td[1]/div[1]/a[1]"));
        driver.findElement(By.id("cart-237972-qty")).sendKeys("5");

        //* Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span [text() = 'Update Cart']"));
        //* Verify the product price ‘$225.00’
        String expectedPrice = "$225.00";
        String actualPrice = driver.findElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']")).getText();
        Assert.assertEquals(expectedPrice,actualPrice);
    }
    @After
    public void tearDown(){
        //closeBrowser();
    }
}
