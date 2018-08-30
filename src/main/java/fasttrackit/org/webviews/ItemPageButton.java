package fasttrackit.org.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPageButton {
    @FindBy(linkText = "Add to Wishlist")
    private WebElement addToWishlistButton;

    @FindBy(xpath = "//div[@class='add-to-cart-buttons']/button")
    private WebElement addToCartButton;

    @FindBy (linkText = "VIEW DETAILS")
    private WebElement viewDetailsButton;

    public WebElement getAddToWishlistButton() {
        return addToWishlistButton;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
    public WebElement getViewDetailsButton() {
        return viewDetailsButton;
    }


}
