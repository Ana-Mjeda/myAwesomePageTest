package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.LoginPage;
import util.FakerUtil;

public class AdminCitiesTest extends BaseTest {

    private LoginPage loginPage;

    private AdminCitiesPage adminCitiesPage;

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
        loginPage.loginForm(adminEmail, adminPassword);
        homePage.clickAdminButton();
        homePage.clickCitiesButton();
    }

    @Test
    public void visitAdminCitiesPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        Assert.assertTrue(homePage.isLogoutButtonVisible());
    }

    @Test
    public void createNewCity() {
        String city = FakerUtil.getCity();
        adminCitiesPage.createNewCity(city);
        adminCitiesPage.waitForSavePopupMessage();
        Assert.assertTrue(adminCitiesPage.getPopupSaveMessage().getText().contains("Saved successfully"));
        adminCitiesPage.closeMessage();
    }

    @Test
    public void editCity() {
        String city = FakerUtil.getCity();
        adminCitiesPage.createNewCity(city);
        adminCitiesPage.closeMessage();
        adminCitiesPage.searchField(city);
        adminCitiesPage.clickEditButton();
        adminCitiesPage.inputName(" Edited");
        adminCitiesPage.clickSaveButton();
        adminCitiesPage.waitForSavePopupMessage();
        Assert.assertTrue(adminCitiesPage.getPopupSaveMessage().getText().contains("Saved successfully"));
    }

    @Test
    public void searchCity() {
        String city = FakerUtil.getCity();
        String expectedCity = city + " Edited";
        adminCitiesPage.createNewCity(expectedCity);
        adminCitiesPage.closeMessage();
        adminCitiesPage.searchField(expectedCity);
        Assert.assertEquals(adminCitiesPage.getCityName().getText(), expectedCity);
    }

    @Test
    public void deleteCity() {
        String city = FakerUtil.getCity();
        adminCitiesPage.createNewCity(city);
        adminCitiesPage.closeMessage();
        adminCitiesPage.searchField(city);
        adminCitiesPage.clickDeleteButton();

        adminCitiesPage.waitForWarningDelete();
        adminCitiesPage.clickWarningDeleteButton();

        adminCitiesPage.waitForDeletePopupMessage();
        String text = adminCitiesPage.getPopupDeleteMessage().getText();
        System.out.println(text);
        Assert.assertTrue(text.contains("Deleted successfully"));
    }

    @AfterMethod
    public void afterMethod() {
        homePage.clickLogout();
    }
}
