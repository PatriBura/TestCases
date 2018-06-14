package fasttrackit.org.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductGrid {
    @FindBy(linkText = "Add to Wishlist")
    private WebElement addToWishlistLink ;

    public WebElement getAddToWishlistLink() {
        return addToWishlistLink;
    }
}
