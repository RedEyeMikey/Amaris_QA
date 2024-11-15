package Test;
import BaseData.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    String loginUrl = "https://practice.automationtesting.in/my-account/";


    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By submitButton = By.xpath("//input[@type='submit']");
    private final By errorMessage = By.xpath("//ul[@class='woocommerce-error']//li");
    private final By lostPassword = By.linkText("Lost your password?");
    private final By resetPasswordButton = By.xpath("//input[@class='woocommerce-Button button']");

    @BeforeMethod
    public void loadApplication(){
        utils.getUrl(loginUrl);
    }
    @Test
    public void insertOnlyUsername(){
        utils.sendString(username,"aaaaaaaa");
        utils.click(submitButton);
        String message = utils.getString(errorMessage);
        Assert.assertEquals(message,"Error: Password is required.");
    }
    @Test
    public void insertOnlyPassword(){
        utils.sendString(password,"aaaaaaaa");
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
        utils.sendString(username, "aaaaaaaa");
        utils.sendString(password, "aaaaaaaa");
        utils.click(submitButton);
        String message = utils.getString(errorMessage);
        Assert.assertEquals(message,"Error: The password you entered for the username aaaaaaaa is incorrect. Lost your password?");
    }
    @Test
    public void jumpToLostPassword(){
        utils.click(lostPassword);
        Assert.assertTrue(utils.find(resetPasswordButton).isDisplayed());
    }
}
