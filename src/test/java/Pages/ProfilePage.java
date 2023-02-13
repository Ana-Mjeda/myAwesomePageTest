package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(id = "phone")
    private WebElement inputPhone;

    @FindBy(id = "city")
    private WebElement inputCity;

    @FindBy(id = "country")
    private WebElement inputCountry;

    @FindBy(id = "urlTwitter")
    private WebElement inputTwitter;

    @FindBy(id = "urlGitHub")
    private WebElement inputGitHub;

    @FindBy(className = "btnSave")
    private WebElement btnSave;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement message;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/button/span")
    private WebElement closeButton;

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void chooseCity(String city) {
        inputCity.click();
        inputText(inputCity, city);
        inputCity.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void editProfile(String name, String phone, String city, String country, String twitter, String gitHub) {
        inputText(inputName, name);
        inputText(inputPhone, phone);
        chooseCity(city);
        inputText(inputCountry, country);
        inputText(inputTwitter, twitter);
        inputText(inputGitHub, gitHub);

        btnSave.click();
    }

    private void inputText(WebElement element, String name) {
        element.click();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(name);
    }

    public WebElement getMessage() {
        return message;
    }

    public String getInputName() {
        return getAttributeValue(inputName);
    }

    public String getInputPhone() {
        return getAttributeValue(inputPhone);
    }

    public String getInputCity() {
        return getAttributeValue(inputCity);
    }

    public String getInputCountry() {
        return getAttributeValue(inputCountry);
    }

    public String getInputTwitter() {
        return getAttributeValue(inputTwitter);
    }

    public String getInputGitHub() {
        return getAttributeValue(inputGitHub);
    }

    private String getAttributeValue(WebElement webElement) {
        return webElement.getAttribute("value");
    }

    public void clickCloseButton(){
        closeButton.click();
    }
}
