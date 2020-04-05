package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import pages.MyAccountPage;

public class TestBase {
    public WebDriver driver;
    protected LoginPage loginPage;
    protected MyAccountPage myAccountPage;
    public static ChromeOptions chromeOptions;
    @BeforeClass
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com/index.php");
    }
    public static ChromeOptions chromeOptionsAdjustment()
    {
        chromeOptions=new ChromeOptions();
        chromeOptions.setHeadless(true);
        return chromeOptions;
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
