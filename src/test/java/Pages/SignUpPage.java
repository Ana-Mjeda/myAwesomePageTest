package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage{

    @FindBy(id = "name")
    private WebElement name;
    @FindBy (id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy (id = "confirmPassword")
    private WebElement confirmPassword;

    public SignUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
}
