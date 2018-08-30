package fasttrackit.tests.wishlist;


import fasttrackit.DriverFactory;
import fasttrackit.LoginForm;
import fasttrackit.org.webviews.ItemPageButton;
import fasttrackit.tests.TestBase;
import fasttrackit.tests.TestUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class WishlistTest extends TestBase {
    @Test
    public void accountLogin(){
        TestUtils.mouseClick(By.linkText("ACCOUNT"));
        TestUtils.mouseClick(By.linkText("Log In"));
        LoginForm loginForm = PageFactory.initElements(DriverFactory.getDriver(), LoginForm.class);
        loginForm.login("patribura@mailinator.com", "sakuralove13");
        assertThat(TestUtils.getMessageContainer("welcome-msg").getText(),is("Welcome, Patri Bura!"));

    }

    @Test
    public void addItemToWishlist() {

        this.selectAccountSubcategory("Log In");
        this.selectItemSubcategory("MEN", "Shirts");
        assertThat("Item could not be added to Wishlist", TestUtils.getMessageContainer("success-msg").isDisplayed());
        assertThat(TestUtils.getMessageContainer("success-msg").getText(), is("Plaid Cotton Shirt has been added to your wishlist. Click here to continue shopping."));

    }


    @Test
    public void editWishlistItem() {
        this.selectAccountSubcategory("Log In");
        TestUtils.mouseClick(By.linkText("MY WISHLIST"));
        TestUtils.mouseClick(By.linkText("EDIT"));
        TestUtils.mouseClick(By.id("option79"));
        String productName = TestUtils.diplayProductName().getText();
        TestUtils.mouseClick(By.linkText("Update Wishlist"));
        assertThat("Item could not be edited in Wishlist", TestUtils.getMessageContainer("success-msg").isDisplayed());
        assertThat(TestUtils.getMessageContainer("success-msg").getText().toLowerCase(), is(productName.toLowerCase() + " has been updated in your wishlist."));


        delay();

    }


    @Test
    public void checkForDuplicateWishlistItems() {
        String productName = "nolita cami";
        selectAccountSubcategory("Log In");
        TestUtils.mouseOverAndClickLast(By.linkText("WOMEN"), By.linkText("Tops & Blouses"));
        List<WebElement> list = TestUtils.getProductList();


        for (WebElement element : list) {
            WebElement nameAnchor = element.findElement(By.cssSelector(".product-info .product-name a"));
            if (nameAnchor.getText().toLowerCase().equals(productName)) {
                List<WebElement> productActions = element.findElements(By.cssSelector(".product-info .actions .add-to-links li"));
                WebElement addToWishlistLink = productActions.stream()
                        .filter(action -> action.getText().equals("Add to Wishlist"))
                        .findFirst().orElse(null);
                addToWishlistLink.click();
                break;

            }
        }
        List<WebElement> wishListProduct = TestUtils.getWishlistProducts();

        int wishlistSize = wishListProduct.size();
        assertThat("No item was added to the wishlist", wishlistSize > 0);


        int counter = 0;
        for(int row = 1; row <= wishlistSize; row++) {
            WebElement productAnchor = DriverFactory.getDriver().findElement(By.xpath("//*[@class='fieldset']/table/tbody/tr["+ row +"]/td[2]/h3/a"));
            if (productAnchor.getText().toLowerCase().equals(productName)) {
                counter = counter + 1;
            }

        }

        assertThat("Item was added " + counter + " times", counter <= 1);

        delay();
    }
    @Test
    public void addItemToCart(){
        TestUtils.mouseOverAndClickLast(By.linkText("MEN"), By.linkText("Shirts"));
        ItemPageButton displayPageButton = PageFactory.initElements(DriverFactory.getDriver(), ItemPageButton.class);
        displayPageButton.getViewDetailsButton().click();
        TestUtils.mouseClick(By.id("option28"));
        TestUtils.mouseClick(By.id("option79"));
        String productName = TestUtils.diplayProductName().getText();
        ItemPageButton itemPageButton = PageFactory.initElements(DriverFactory.getDriver(), ItemPageButton.class);
        itemPageButton.getAddToCartButton().click();

        delay();
        assertThat(TestUtils.getMessageContainer("success-msg").getText().toLowerCase(), is(productName.toLowerCase() + " was added to your shopping cart."));

    }


    private void selectAccountSubcategory(String buttonName) {

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


    private void selectItemSubcategory(String category, String subcategory) {
        TestUtils.mouseOverAndClickLast(By.linkText(category), By.linkText(subcategory));
        ItemPageButton wishlistButton = PageFactory.initElements(DriverFactory.getDriver(), ItemPageButton.class);
        wishlistButton.getAddToWishlistButton().click();

    }

    private void delay() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
