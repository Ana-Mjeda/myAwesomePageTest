package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")
    private WebElement signUpErrorMessage;

    @FindBy(className = "dlgVerifyAccount")
    private WebElement verifyAccountPopUp;

    @FindBy (className = "btnClose")
    private WebElement closePopUp;

    public SignUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public void fillForm(String name, String email, String password, String confirmPassword) {
        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        signUpButton.click();
    }

    public WebElement getSignUpErrorMessage() {
        return signUpErrorMessage;
    }

    public void waitForSignupUrl() {
        driverWait.until(ExpectedConditions.urlContains("/signup"));
    }

    public void waitForSignupErrorMessage() {
        driverWait.until(ExpectedConditions.visibilityOf(getSignUpErrorMessage()));
    }

    public WebElement getVerifyAccountPopUp() {
        return verifyAccountPopUp;
    }

    public void waitForVerifyAccountPopup() {
        driverWait.until(ExpectedConditions.visibilityOf(getVerifyAccountPopUp()));
    }

    public void closePopUp(){
        closePopUp.click();
    }
}
