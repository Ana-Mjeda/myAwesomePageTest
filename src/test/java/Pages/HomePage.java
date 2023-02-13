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

    @FindBy (className = "btnLocaleActivation")
    private WebElement languagesButton;

    @FindBy (className = "btnES")
    private WebElement spanish;

    @FindBy (className = "btnEN")
    private WebElement english;

    @FindBy (className = "btnFR")
    private WebElement french;

    @FindBy (xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement header;

    @FindBy (xpath =  "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")
    private WebElement profileButton;

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

    public void clickLanguageButton(){
        languagesButton.click();
    }
    public void chooseLanguage(Languages language) {

        switch (language) {
            case EN:
                english.click();
                break;
            case ES:
                spanish.click();
                break;
            case FR:
                french.click();
                break;
        }
    }

    public WebElement getSpanish() {
        return spanish;
    }

    public WebElement getEnglish() {
        return english;
    }

    public WebElement getFrench() {
        return french;
    }

    public WebElement getHeader() {
        return header;
    }

    public void clickProfileButton(){
        profileButton.click();
    }
}
