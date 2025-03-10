package BaseData;

import Page.LoginPage;
import Utils.JSUtils;
import Utils.Utils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static Utils.Utils.driver;

public class BaseTest {
    private final String DemoQA_URL = "https://demoqa.com/";
    protected Utils utils;
    protected JSUtils jsUtils;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        utils = new Utils();
        jsUtils = new JSUtils();
        loginPage = new LoginPage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

