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


        this.selectAccountButton("Log In");


        TestUtils.mouseOverAndClickLast(By.linkText("MEN"), By.linkText("Shirts"));
        ProductGrid productGrid = PageFactory.initElements(DriverFactory.getDriver(), ProductGrid.class);
        productGrid.getAddToWishlistLink().click();
        assertThat("Item could not be added to Wishlist", TestUtils.getSuccessMessageContainer().isDisplayed());
        assertThat(TestUtils.getSuccessMessageContainer().getText(), is("Plaid Cotton Shirt has been added to your wishlist. Click here to continue shopping."));

    }


    public void selectAccountButton(String buttonName) {

        TestUtils.mouseClick(By.linkText("ACCOUNT"));

        switch (buttonName) {
            case "My Wishlist": {
                TestUtils.mouseClickOnLink("Wishlist");
                break;
            }
            case "My Cart": {
                break;
            }
            case "Checkout": {
                break;
            }
            case "Log Out": {
                break;
            }
            case "Log In": {
                TestUtils.mouseClick(By.linkText(buttonName));
                LoginForm loginForm = PageFactory.initElements(DriverFactory.getDriver(), LoginForm.class);
                loginForm.login("patribura@mailinator.com", "sakuralove13");
                break;
            }
            case "My Account": {
                break;
            }

        }
    }


    @Test
    public void editWishlistItem() {
        this.selectAccountButton("Log In");
        TestUtils.mouseClick(By.linkText("MY WISHLIST"));
        TestUtils.mouseClick(By.linkText("EDIT"));
        TestUtils.mouseClick(By.id("option79"));
        TestUtils.mouseClick(By.linkText("Update Wishlist"));

        assertThat("Item could not be edited in Wishlist", TestUtils.getSuccessMessageContainer().isDisplayed());
        assertThat(TestUtils.getSuccessMessageContainer().getText(), is("Linen Blazer has been updated in your wishlist."));


        try {
Thread.sleep(500);
        } catch (Exception e){
            System.out.println(e);
        }


    }


}
