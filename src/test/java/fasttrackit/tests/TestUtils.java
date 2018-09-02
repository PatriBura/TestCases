package fasttrackit.tests;

import fasttrackit.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;

import static fasttrackit.DriverFactory.getDriver;



public class TestUtils {

    public static void mouseOverAndClickLast(By firstLocator, By secondLocator) {

        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(firstLocator)).perform();
        actions.click(getDriver().findElement(secondLocator))
                .perform();
    }

    public static void mouseClick(By locator) {
        Actions actions = new Actions(getDriver());
        actions.click(getDriver().findElement(locator)).perform();
    }

    public static WebElement getMessageContainer(String className) {
        return DriverFactory.getDriver().findElement(By.className(className));
    }

    public static void mouseClickOnLink(String href) {
        List<WebElement> anchors = getDriver().findElements(By.tagName("a"));

        for(WebElement anchor: anchors) {
            System.out.println(anchor.getAttribute("href"));
            if (anchor.getAttribute("href").contains(href)) {
                Actions actions = new Actions(getDriver());
                actions.click(anchor).perform();
            }
        }

    }
    public static WebElement wishlistItemComment(){
        WebElement commentField = DriverFactory.getDriver().findElement(By.xpath("//div[@class='fieldset']/table/tbody/tr/td[2]/textarea"));
   return commentField;
    }

    public static WebElement wishlistItemQuantity(){
        WebElement commentField = DriverFactory.getDriver().findElement(By.xpath("//div[@class='fieldset']/table/tbody/tr/td[3]/div/div/input"));
        return commentField;
    }

    public static WebElement diplayProductName(){
        WebElement productName = DriverFactory.getDriver().findElement(By.xpath("//div[@class='product-shop']/div[1]/span"));
        return productName;
    }

    public static WebElement deleteItemButton(){
        WebElement commentField = DriverFactory.getDriver().findElement(By.xpath("//div[@class='fieldset']/table/tbody/tr/td[6]/a"));
        return commentField;
    }

    public static Alert getAlert(){
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        return alert;
    }

    public static List<WebElement> getProductList(){

        List<WebElement> list = DriverFactory.getDriver().findElements(By.xpath("//li[@class='item last']"));

        return list;
    }
    public static List<WebElement> getWishlistProducts(){
        List<WebElement> tableRows = DriverFactory.getDriver().findElements(By.xpath("//*[@class='fieldset']/table/tbody/tr"));
        return tableRows;
    }
}
