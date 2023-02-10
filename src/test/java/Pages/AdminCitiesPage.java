package Pages;

import io.netty.buffer.ByteBufHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminCitiesPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button")
    public WebElement newItemButton;

    @FindBy(id = "name")
    public WebElement nameInputField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]/span")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    public WebElement saveMessage;

    @FindBy(id = "search")
    public WebElement searchField;

    @FindBy (xpath = "//*[@id=\"edit\"]/span/i")
    public WebElement editButton;

    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void createNewCity(String city) {
        newItemButton.click();
        this.nameInputField.sendKeys(city);
        saveButton.click();
    }

    public WebElement getSaveMessage() {
        return saveMessage;
    }


   public void searchField(String city){
        searchField.sendKeys(city);
   }

    public void clickEditButton(){
        editButton.click();
    }
}
