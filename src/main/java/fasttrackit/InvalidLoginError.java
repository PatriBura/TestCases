package fasttrackit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvalidLoginError {

    @FindBy(css = ".messages .error-msg span")
    private WebElement loginError ;

    public WebElement getLoginError() {
        return loginError;
    }
}

