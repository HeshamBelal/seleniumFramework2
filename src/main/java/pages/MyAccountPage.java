package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{
    @FindBy (linkText = "Sign out")
    public WebElement signOutButton;
    @FindBy (linkText = "Sign in")
    public WebElement signInButton;
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    public void logout()
    {
        PageBase.clickOnWebElement(signOutButton);
    }
}
