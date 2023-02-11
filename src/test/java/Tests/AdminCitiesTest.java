package Tests;

import Pages.AdminCitiesPage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    private LoginPage loginPage;

    private AdminCitiesPage adminCitiesPage;

    String email = "admin@admin.com";

    String password = "12345";

    String city = "East Ariane";

    String editedCity = "East Ariane Edited";

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.clickLogin();
        loginPage.loginForm(email, password);
        homePage.clickAdminButton();
        homePage.clickCitiesButton();
    }

    @Test
    public void visitAdminCitiesPage() {

        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        Assert.assertTrue(loginPage.isLogoutButtonVisible());
    }

    @Test
    public void createNewCity() {
        adminCitiesPage.createNewCity(city);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        Assert.assertTrue(adminCitiesPage.getPopupMessage().getText().contains("Saved successfully"));
    }

    @Test
    public void editCity() {
        adminCitiesPage.searchField(city);
        adminCitiesPage.clickEditButton();
        adminCitiesPage.nameInputField.sendKeys(" Edited");
        adminCitiesPage.saveButton.click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        Assert.assertTrue(adminCitiesPage.getPopupMessage().getText().contains("Saved successfully"));
    }

    @Test
    public void searchCity() {
        adminCitiesPage.searchField(editedCity);
        Assert.assertEquals(adminCitiesPage.getCityName().getText(), editedCity);
    }

    @Test
    public void deleteCity() {
        adminCitiesPage.searchField(editedCity);
        Assert.assertEquals(adminCitiesPage.getCityName().getText(), editedCity);
        adminCitiesPage.clickDeleteButton();

        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getWarningDelete()));
        adminCitiesPage.clickWarningDeleteButton();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        Assert.assertTrue(adminCitiesPage.getPopupMessage().getText().contains("Deleted successfully"));
    }
}
