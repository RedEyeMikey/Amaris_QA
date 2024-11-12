package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Utils {
    public static WebDriver driver;

    public void getUrl(String url){
        driver.get(url);
    }
    public WebElement find (By locator){
        return driver.findElement(locator);
    }
    public void sendString (By locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }
    public void click (By locator){
        find(locator).click();
    }
    public void submit(By locator){
        find(locator).submit();
    }
    public String getCSSValue (By locator, String cssProperty){
        return find(locator).getCssValue(cssProperty);
    }
    public boolean isSelected (By locator){
        return find(locator).isSelected();
    }
    public boolean isEnabled (By locator){
        return find(locator).isEnabled();
    }
    public boolean isDisplayed (By locator){
        return find(locator).isDisplayed();
    }
    public String getString (By locator){
        return find(locator).getText();
    }
    public void waitPage (int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
    public String toString(Object object){
        return object.toString();
    }
}
