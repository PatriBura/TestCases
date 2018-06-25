package fasttrackit.tests;

import fasttrackit.DriverFactory;
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

    public static WebElement getSuccessMessageContainer() {
        return DriverFactory.getDriver().findElement(By.className("success-msg"));
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
}
