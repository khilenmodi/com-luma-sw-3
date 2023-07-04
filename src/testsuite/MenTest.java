package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart()
    {
        //* Mouse Hover on Men Menu
        WebElement menMenu = driver.findElement(By.xpath("//span[normalize-space()='Men']"));
        Actions menu = new Actions(driver);
        menu.moveToElement(menMenu).build().perform();


        //* Mouse Hover on Bott;oms
        WebElement menBottoms = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]/span[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menBottoms).build();

        //* Click on Pants
        WebElement menPants = driver.findElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        Actions pants = new Actions(driver);
        pants.moveToElement(menPants).click();

        //* Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
        WebElement product = driver.findElement(By.xpath("//a[text()='Cronus Yoga Pant']"));
        WebElement size = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(product).build().perform();
        action1.moveToElement(size).click().build().perform();
        //* Mouse Hover on product name‘Cronus Yoga Pant’ and click on colour Black.
        WebElement colour = driver.findElement(By.xpath("//div[@id='option-label-color-93-item-49']"));
        pants.moveToElement(colour).click().build().perform();// Mouse Hover on product name Cronus Yoga Pant’ and click on colourBlack.
        //* Mouse Hover on product name‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        WebElement cart = driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']"));
        Actions pant = new Actions(driver);
        pant.moveToElement(cart).click().build().perform();// Mouse Hover on product name ‘Cronus Yoga Pant’ and click on‘Add To Cart’ Button.

        //* Verify the text‘You added Cronus Yoga Pant to your shopping cart.’

        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        Assert.assertEquals(expectedText,actualText);

        //* Click on ‘shopping cart’ Link into message
        driver.findElement(By.xpath("//a[contains(text(),'shopping cart')]")).click();

        //* Verify the text ‘Shopping Cart.’
        String verifyText = "Shopping Cart";
        String actualVerifyText = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(verifyText,actualVerifyText);
        //* Verify the product name ‘Cronus Yoga Pant’
        String productName = "Cronus Yoga Pant";
        String actualProductName = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")).getText();
        Assert.assertEquals(productName,actualProductName);
        //* Verify the product size ‘32’
        String productSize = "32";
        String actualProductSize = driver.findElement(By.xpath("//dd[contains(text(),'32')]")).getText();
        Assert.assertEquals(productSize,actualProductSize);
        //* Verify the product colour ‘Black’
        String productColour = "Black";
        String actualProductColour = driver.findElement(By.xpath("//dd[contains(text(),'Black')]")).getText();
        Assert.assertEquals(productColour,actualProductColour);


    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
