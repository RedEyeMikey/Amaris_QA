package Test;
import BaseData.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    String loginUrl = "https://practice.automationtesting.in/my-account/";
    private By username = By.id("username");
    private By password = By.id("password");
    private By submitButton = By.xpath("//input[@type='submit']");
    private By errorMessage = By.xpath("//ul[@class='woocommerce-error']//li");
    private By lostPassword = By.linkText("Lost your password?");
    private By resetPasswordButton = By.xpath("//input[@class='woocommerce-Button button']");
    @BeforeMethod
    public void loadApplication(){
        utils.getUrl(loginUrl);
    }
    @Test
    public void insertOnlyUsername(){
        utils.sendString(username,"aaaaa");
        utils.click(submitButton);
        String message = utils.getString(errorMessage);
        Assert.assertEquals(message,"Error: Password is required.");
    }
    @Test
    public void insertOnlyPassword(){
        utils.sendString(password,"aaaaa");
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
        utils.waitPage(5);
        Assert.assertTrue(utils.find(resetPasswordButton).isDisplayed());
    }
}