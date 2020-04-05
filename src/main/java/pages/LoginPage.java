package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Sign in")//Sign in button at the beginning
    private WebElement signInButton;
    @FindBy(id = "email")
    private WebElement eMailTxtField;
    @FindBy (id = "passwd")
    private WebElement passwordTxtField;
    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;

    public void login(String email, String password) throws InterruptedException {
        PageBase.clickOnWebElement(signInButton);
        Thread.sleep(2000);
        PageBase.insertTextToWebElement(email,eMailTxtField);
        PageBase.insertTextToWebElement(password,passwordTxtField);
        PageBase.clickOnWebElement(submitLoginButton);
    }
}
