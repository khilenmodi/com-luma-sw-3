package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter(){
        //Mouse Hover on Women Menu
        WebElement womenMenu = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(womenMenu).build().perform();

        //* Mouse Hover on Tops
        WebElement topMenu = driver.findElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(topMenu).build().perform();


        //* Click on Jackets
        driver.findElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]")).click();

        //* Select Sort By filter “Product Name”
        WebElement dropDown = driver.findElement(By.id("sorter"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Product Name");

        //* Verify the products name display in alphabetical order
        WebElement productSort = driver.findElement(By.xpath("//div[2]//div[1]//strong[2]"));

    }

    @Test
    public void verifyTheSortByPriceFilter()throws InterruptedException{
        Thread.sleep(1000);
        //* Mouse Hover on Women Menu
        WebElement womenMenu = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(womenMenu).click().build().perform();

        //* Mouse Hover on Tops
        WebElement topMenu = driver.findElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(topMenu).click().build();

        //* Click on Jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //* Select Sort By filter “Price”
        WebElement dropDown = driver.findElement(By.id("sorter"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price");

       /* //* Verify the products price display in Low to High
        driver.findElement(By.id("mode-grid")).click();
        String expectedResult = "price display in low to high";
*/


    }

    @After
    public void tearDown(){
       // closeBrowser();
    }


}
