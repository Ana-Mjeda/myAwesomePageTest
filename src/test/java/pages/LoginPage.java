package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")
    private WebElement loginErrorMessage;

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginErrorMessage() {
        return loginErrorMessage;
    }

    public void loginForm(String email, String password) {
        this.email.clear();
        this.email.sendKeys(email);

        this.password.clear();
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void waitForErrorMessage() {
        driverWait.until(ExpectedConditions.visibilityOf(getLoginErrorMessage()));
    }

    public void waitForHomeUrl() {
        driverWait.until(ExpectedConditions.urlContains("/home"));
    }

    public void waitForLoginUrl() {
        driverWait.until(ExpectedConditions.urlContains("/login"));
    }

}
