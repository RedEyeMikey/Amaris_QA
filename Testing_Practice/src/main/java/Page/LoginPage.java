package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;
    @FindBy (id = "username")
    WebElement username;
    @FindBy (id = "password")
    WebElement password;
    @FindBy (xpath = "")
    WebElement submitButton;

}
