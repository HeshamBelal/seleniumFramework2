package tests;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
public class LoginTestUsingHeadless extends TestBase {
    @BeforeClass
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(TestBase.chromeOptionsAdjustment());
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com/index.php");
    }
    @Test
    public void userCanLogin() throws InterruptedException {
        loginPage=new LoginPage(driver);
        myAccountPage=new MyAccountPage(driver);
        loginPage.login("test1@hesham.com","p@ssw0rd");
        Assert.assertTrue(myAccountPage.signOutButton.isDisplayed(),"Congratulation, Login test is successful");
    }
    @Test(dependsOnMethods = {"userCanLogin"})
    public void userCanLogout()
    {
        myAccountPage=new MyAccountPage(driver);
        myAccountPage.logout();
        Assert.assertTrue(myAccountPage.signInButton.isDisplayed(),"Congratulation, Logout test is successful");
    }
}
