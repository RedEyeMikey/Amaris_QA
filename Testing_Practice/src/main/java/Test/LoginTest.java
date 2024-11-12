package Test;
import BaseData.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    String loginUrl = "https://practice.automationtesting.in/my-account/";
    private By username = By.id("username");
    private By password = By.id("password");
    private By submitButton = By.xpath("//input[@type='submit']");
    private By errorMessage = By.xpath("//ul[@class='woocommerce-error']//li");
    @BeforeMethod
    public void loadApplication(){
        utils.getUrl(loginUrl);
    }
    @Test
    public void insertOnlyUsername(){
        utils.sendString(loginTest.username,"aaaaa");
        utils.click(submitButton);
        String message = utils.getString(errorMessage);
        Assert.assertEquals(message,"Error: Password is required.");
    }
    @Test
    public void insertOnlyPassword(){
        utils.sendString(loginTest.password,"aaaaa");
        utils.click(submitButton);
        String message = utils.getString(errorMessage);
        Assert.assertEquals(message,"Error: Username is required.");
    }
    @Test
    public void noInput(){
        utils.click(submitButton);
        String message = utils.getString(errorMessage);
        Assert.assertEquals(message,"Error: Username is required.");
    }
    @Test
    public void inputWrongPassword(){
        utils.sendString(loginTest.username, "aaaaaaaa");
        utils.sendString(loginTest.password, "aaaaaaa");
        utils.click(submitButton);
        String message = utils.getString(errorMessage);
        Assert.assertEquals(message,"Error: The password you entered for the username aaaaaaaa is incorrect. Lost your password?");
    }
}
