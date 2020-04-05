package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class PageBase {
    private WebDriver drvier;
    public PageBase(WebDriver driver)
    {
        this.drvier=driver;
        PageFactory.initElements(drvier,this);
    }
    public static void clickOnWebElement(WebElement element)
    {
        element.click();
    }
    public static void insertTextToWebElement(String text, WebElement element)
    {
        element.sendKeys(text);
    }
    public static void scrollToBottom()
    {

    }

}
