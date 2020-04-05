package tests;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
public class LoginTestUsingPhantomJS extends TestBase {
    @BeforeClass
    public void setUp()
    {
        System.setProperty("phantomjs.binary.path",System.getProperty("user.dir")+"\\drivers\\phantomjs.exe");
      /*  DesiredCapabilities caps= new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,System.setProperty("phantomjs.binary.path",System.getProperty("user.dir")+"\\drivers\\phantomjs.exe"));
        String[] phantomJsArgs={"--web=security=no","--ignore-ssl=yes"};
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,phantomJsArgs); */
        driver = new PhantomJSDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com/index.php");
    }
    @Test(priority = 0)
    public void userCanLogin() throws InterruptedException {
        loginPage=new LoginPage(driver);
        myAccountPage=new MyAccountPage(driver);
        loginPage.login("test1@hesham.com","p@ssw0rd1");
        Assert.assertTrue(myAccountPage.signOutButton.isDisplayed(),"Congratulation, Login test is successful");
    }
    @Test(priority = 1)
    public void userCanLogout()
    {
        myAccountPage=new MyAccountPage(driver);
        myAccountPage.logout();
        Assert.assertTrue(myAccountPage.signInButton.isDisplayed(),"Congratulation, Logout test is successful");
    }
}
