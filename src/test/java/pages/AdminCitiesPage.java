package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button")
    private WebElement newItemButton;

    @FindBy(id = "name")
    private WebElement nameInputField;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div")
    private WebElement popupSaveMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div")
    private WebElement popupDeleteMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]/button/span")
    private WebElement closeMessage;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"edit\"]/span/i")
    private WebElement editButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")
    private WebElement cityName;

    @FindBy(xpath = "//*[@id=\"delete\"]/span/i")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@class='v-btn__content'][normalize-space()='Delete']")
    private WebElement warningDelete;

    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void createNewCity(String city) {
        newItemButton.click();
        this.nameInputField.sendKeys(city);
        saveButton.click();
    }

    public void inputName(String name) {
        nameInputField.sendKeys(name);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public WebElement getPopupSaveMessage() {
        return popupSaveMessage;
    }

    public WebElement getPopupDeleteMessage() {
        return popupDeleteMessage;
    }

    public void closeMessage() {
        closeMessage.click();
    }

    public void searchField(String city) {
        searchField.sendKeys(city);
    }

    public void clickEditButton() {
        editButton.click();
    }

    public WebElement getCityName() {
        return cityName;
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public WebElement getWarningDelete() {
        return warningDelete;
    }

    public void clickWarningDeleteButton() {
        warningDelete.click();
    }

    public void waitForSavePopupMessage() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
    }

    public void waitForDeletePopupMessage() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
    }

    public void waitForWarningDelete() {
        driverWait.until(ExpectedConditions.visibilityOf(getWarningDelete()));
    }
}

