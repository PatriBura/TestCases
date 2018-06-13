package fasttrackit.tests.wishlist;


import fasttrackit.DriverFactory;
import fasttrackit.InvalidLoginError;
import fasttrackit.LoginForm;
import fasttrackit.tests.TestBase;
import fasttrackit.tests.TestUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

import static fasttrackit.DriverFactory.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;


public class WishlistTest extends TestBase {
    @Test
    public void addItemToWishlist() {


        this.loginUserForWishlist();


        TestUtils.mouseOverAndClickLast(By.linkText("MEN"), By.linkText("Shirts"));
//
        TestUtils.mouseClick(By.linkText("Add to Wishlist"));
        try {
            Thread.sleep(3000);

        } catch (InterruptedException err) {
            System.out.println("Results did not contain keyword");
        }

    }

    public void loginUserForWishlist() {

        TestUtils.mouseClick(By.linkText("ACCOUNT"));
        TestUtils.mouseClick(By.linkText("Log In"));
        LoginForm loginForm = PageFactory.initElements(DriverFactory.getDriver(), LoginForm.class);
        loginForm.login("patribura@mailinator.com", "sakuralove1");


        InvalidLoginError loginErrorContainer = PageFactory.initElements(DriverFactory.getDriver(), InvalidLoginError.class);
        boolean loginFailed = loginErrorContainer.getLoginError() == null;
        assertThat("Invalid password or email", loginFailed);
    }


}
