package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
public class LoginTest extends TestBase {
    @Test
    public void userCanLogin() throws InterruptedException {
        loginPage=new LoginPage(driver);
        myAccountPage=new MyAccountPage(driver);
        loginPage.login("test1@hesham.com","p@ssw0rd");
        Thread.sleep(2000);
        System.out.println("Line Before Assert");
        Assert.assertTrue(myAccountPage.signOutButton.isDisplayed());
        System.out.println("Line After Assert");
    }
    @Test(dependsOnMethods = {"userCanLogin"})
    public void userCanLogout()
    {
        myAccountPage=new MyAccountPage(driver);
        myAccountPage.logout();
        Assert.assertTrue(myAccountPage.signInButton.isDisplayed());
    }
}
