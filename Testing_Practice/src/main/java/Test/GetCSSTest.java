package Test;

import BaseData.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetCSSTest extends BaseTest {
    private final String url = "https://practice.automationtesting.in/test-cases/";

    private final By text_long = By.cssSelector("body > div> div:nth-child(2) > div > div >div > div > div > div:nth-child(2) > div > div > div > div > div > div > div > ul > li > div > a");
    private final By text_short= By.cssSelector("div[id='accordion-222-sub_row_1-0-1-0-0'] > ul >li >div > a ");
    @BeforeMethod
    public void loadApplication(){
        utils.getUrl(url);
    }
    @Test
    public void testCSSPrintTextLong(){
        Assert.assertEquals(utils.getString(text_long),"1. Home Page with three Sliders only");
    }
    @Test
    public void testCSSPrintTextShort(){
        Assert.assertEquals(utils.getString(text_short),"1. Home Page with three Sliders only");
    }

}
