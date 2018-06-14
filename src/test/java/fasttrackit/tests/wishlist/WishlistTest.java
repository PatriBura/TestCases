package fasttrackit.tests.wishlist;


import fasttrackit.DriverFactory;
import fasttrackit.LoginForm;
import fasttrackit.org.webviews.ProductGrid;
import fasttrackit.tests.TestBase;
import fasttrackit.tests.TestUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class WishlistTest extends TestBase {

    @Test
    public void addItemToWishlist() {


        this.loginUserForWishlist();


        TestUtils.mouseOverAndClickLast(By.linkText("MEN"), By.linkText("Shirts"));
        ProductGrid productGrid = PageFactory.initElements(DriverFactory.getDriver(), ProductGrid.class);
        productGrid.getAddToWishlistLink().click();
        assertThat("Item could not be added to Wishlist", TestUtils.getSuccessMessageContainer().isDisplayed());
        assertThat(TestUtils.getSuccessMessageContainer().getText(),is("Plaid Cotton Shirt has been added to your wishlist. Click here to continue shopping."));

    }


    public void loginUserForWishlist() {

        TestUtils.mouseClick(By.linkText("ACCOUNT"));
        TestUtils.mouseClick(By.linkText("Log In"));
        LoginForm loginForm = PageFactory.initElements(DriverFactory.getDriver(), LoginForm.class);
        loginForm.login("patribura@mailinator.com", "sakuralove13");


    }




}
