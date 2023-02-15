package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import util.FakerUtil;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    String email = FakerUtil.getEmail();

    String password = FakerUtil.getPassword();

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.clickLogin();
    }

    @Test
    public void loginURL() {
        homePage.waitForLoginUrl();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void checkInputTypes() {
        Assert.assertEquals(loginPage.getEmail().getAttribute("type"), "email");
        Assert.assertEquals(loginPage.getPassword().getAttribute("type"), "password");
    }

    @Test
    public void userDoesNotExistsError() {

        loginPage.loginForm(email, password);
        loginPage.waitForErrorMessage();
        Assert.assertEquals(loginPage.getLoginErrorMessage().getText(), "User does not exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

    }

    @Test
    public void wrongPasswordError() {
        loginPage.loginForm(adminEmail, password);

        loginPage.waitForErrorMessage();
        Assert.assertEquals(loginPage.getLoginErrorMessage().getText(), "Wrong password");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void login() {
        loginPage.loginForm(adminEmail, adminPassword);
        loginPage.waitForHomeUrl();
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
        homePage.clickLogout();
    }

    @Test()
    public void logout() {

        loginPage.loginForm(adminEmail, adminPassword);
        Assert.assertTrue(homePage.isLogoutButtonVisible());
        homePage.clickLogoutButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        driver.get(baseURL + "/home");

        loginPage.waitForLoginUrl();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
