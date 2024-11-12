package BaseData;

import Test.LoginTest;
import Test.PaymentTest;
import Test.RegisterTest;
import Test.ShoppingTest;
import Utils.Utils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static Utils.Utils.driver;

public class BaseTest {
    protected Utils utils;
    protected LoginTest loginTest;
    protected RegisterTest registerTest;
    protected PaymentTest paymentTest;
    protected ShoppingTest shoppingTest;
    private final String DemoQA_URL = "https://demoqa.com/";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        utils = new Utils();
        loginTest = new LoginTest();
        registerTest = new RegisterTest();
        paymentTest = new PaymentTest();
        shoppingTest = new ShoppingTest();


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

