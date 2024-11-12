package Test;

import BaseData.BaseTest;
import org.testng.annotations.BeforeMethod;

public class RegisterTest extends BaseTest {
    String loginUrl = "https://practice.automationtesting.in/my-account/";
    @BeforeMethod
    public void loadApplication(){
        utils.getUrl(loginUrl);
    }
}
