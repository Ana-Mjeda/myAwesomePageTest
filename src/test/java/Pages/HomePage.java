package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]/span")
    private WebElement singUpButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement verifyAccountPopUp;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span")
    private WebElement adminButton;

    @FindBy(xpath = "//*[@id=\"list-item-117\"]")
    private WebElement citiesButton;

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickSingUp() {
        singUpButton.click();
    }

    public WebElement getVerifyAccountPopUp() {
        return verifyAccountPopUp;
    }

    public void clickAdminButton() {
        adminButton.click();
    }

    public void clickCitiesButton() {
        citiesButton.click();
    }

}
