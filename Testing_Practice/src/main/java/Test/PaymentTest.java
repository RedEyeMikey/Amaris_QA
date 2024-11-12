package Test;

import BaseData.BaseTest;
import org.testng.annotations.BeforeMethod;

public class PaymentTest extends BaseTest {
    String loginUrl = "https://practice.automationtesting.in/checkout/";
    @BeforeMethod
    public void loadApplication(){
        utils.getUrl(loginUrl);
    }
}
