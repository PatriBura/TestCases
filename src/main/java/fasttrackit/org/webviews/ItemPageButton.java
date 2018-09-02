package fasttrackit.org.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPageButton {
    @FindBy (xpath = "//div[@class='buttons-set buttons-set2']/button[3]")
    private WebElement updateWishlistButton;

    @FindBy(linkText = "Add to Wishlist")
    private WebElement addToWishlistButton;

    @FindBy(xpath = "//div[@class='add-to-cart-buttons']/button")
    private WebElement addToCartButton;

    @FindBy (linkText = "VIEW DETAILS")
    private WebElement viewDetailsButton;

    @FindBy (xpath = "//div[@class='buttons-set buttons-set2']/button[2]")
    private WebElement addAllToCartButton;

    public WebElement getAddToWishlistButton() {
        return addToWishlistButton;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
    public WebElement getViewDetailsButton() {
        return viewDetailsButton;
    }
    public WebElement getUpdateWishlistButton() {
        return updateWishlistButton;
    }
    public WebElement getAddAllToCartButton() { return addAllToCartButton; }



}
