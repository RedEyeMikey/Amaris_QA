package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class JSUtils extends Utils {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public void scrollToElement(By locator){
        js.executeScript("arguments[0].scrollIntoView(true);",locator);
    }
}
