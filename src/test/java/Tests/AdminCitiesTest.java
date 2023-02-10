package Tests;

import Pages.AdminCitiesPage;
import Pages.LoginPage;
import Pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    private LoginPage loginPage;
    private AdminCitiesPage adminCitiesPage;

    String email = "admin@admin.com";
    String password = "12345";

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
    }

    @Test
    public void visitAdminCitiesPage(){
        loginPage.loginForm(email, password);
        homePage.clickAdminButton();
        homePage.clickCitiesButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        Assert.assertTrue(loginPage.isLogoutButtonVisible());
    }
}
