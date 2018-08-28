package fasttrackit.org.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductGrid {

    @FindBy(css = ".category-products .products-grid--max-4-col")
    private List<WebElement> productContainers;

    public List<WebElement> getProductContainers() {
        return productContainers;
    }
}
