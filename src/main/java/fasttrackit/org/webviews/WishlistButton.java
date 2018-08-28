package fasttrackit.org.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishlistButton {
    @FindBy(linkText = "Add to Wishlist")
    private WebElement addToWishlistLink ;

    public WebElement getAddToWishlistLink() {
        return addToWishlistLink;
    }
}
