package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.clickLogin();
    }
    @Test
    public void loginURL(){
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void checkInputTypes() {
        Assert.assertEquals(loginPage.getEmail().getAttribute("type"), "email");
        Assert.assertEquals(loginPage.getPassword().getAttribute("type"), "password");
    }

    @Test
    public void userDoesNotExistsError(){
        String email = faker.internet().safeEmailAddress();
        String password = faker.internet().password();
        loginPage.loginForm(email, password);

        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getLoginErrorMessage()));
        Assert.assertEquals(loginPage.getLoginErrorMessage().getText(), "User does not exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void wrongPasswordError(){
        String email = "admin@admin.com";
        String password = faker.internet().password();
        loginPage.loginForm(email, password);

        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getLoginErrorMessage()));
        Assert.assertEquals(loginPage.getLoginErrorMessage().getText(), "Wrong password");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
}
