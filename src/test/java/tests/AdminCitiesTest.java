package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.LoginPage;

public class AdminCitiesTest extends BaseTest {

    private LoginPage loginPage;

    private AdminCitiesPage adminCitiesPage;

    private static final String ADMIN_EMAIL = "admin@admin.com";

    private static final String ADMIN_PASSWORD = "12345";

    private static final String CITY = "East Ariane";

    private static final String EDITED_CITY = "East Ariane Edited";

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
        loginPage.loginForm(ADMIN_EMAIL, ADMIN_PASSWORD);
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
        adminCitiesPage.createNewCity(CITY);
        adminCitiesPage.waitForPopupMessage();
        Assert.assertTrue(adminCitiesPage.getPopupMessage().getText().contains("Saved successfully"));
    }

    @Test
    public void editCity() {
        adminCitiesPage.searchField(CITY);
        adminCitiesPage.clickEditButton();
        adminCitiesPage.inputName(" Edited");
        adminCitiesPage.clickSaveButton();
        adminCitiesPage.waitForPopupMessage();
        Assert.assertTrue(adminCitiesPage.getPopupMessage().getText().contains("Saved successfully"));
    }

    @Test
    public void searchCity() {
        adminCitiesPage.searchField(EDITED_CITY);
        Assert.assertEquals(adminCitiesPage.getCityName().getText(), EDITED_CITY);
    }

    @Test
    public void deleteCity() {
        adminCitiesPage.searchField(EDITED_CITY);
        Assert.assertEquals(adminCitiesPage.getCityName().getText(), EDITED_CITY);
        adminCitiesPage.clickDeleteButton();

        adminCitiesPage.waitForWarningDelete();
        adminCitiesPage.clickWarningDeleteButton();

        adminCitiesPage.waitForPopupMessage();
        Assert.assertTrue(adminCitiesPage.getPopupMessage().getText().contains("Deleted successfully"));
    }
}
