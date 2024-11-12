package Test;

import BaseData.BaseTest;
import org.testng.annotations.BeforeMethod;

public class ShoppingTest extends BaseTest {
    String loginUrl = "https://practice.automationtesting.in/shop/";
    @BeforeMethod
    public void loadApplication(){
        utils.getUrl(loginUrl);
    }
}


