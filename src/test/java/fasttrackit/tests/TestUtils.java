package fasttrackit.tests;

import fasttrackit.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static fasttrackit.DriverFactory.getDriver;

public class TestUtils {

    public static void mouseOverAndClickLast(By firstLocator, By secondLocator) {

        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(firstLocator)).perform();
        actions.click(getDriver().findElement(secondLocator))
                .perform();
    }
    public static void mouseClick(By locator){
        Actions actions = new Actions(getDriver());
        actions.click(getDriver().findElement(locator)).perform();
        }

        public static WebElement getSuccessMessageContainer(){
           return DriverFactory.getDriver().findElement(By.className("success-msg"));
        }
}
