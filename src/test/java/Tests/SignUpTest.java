package Tests;

import Pages.SignUpPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    private SignUpPage signUpPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        signUpPage = new SignUpPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.clickSingUp();
    }

    @Test
    public void visitSignUpPage() {
        driverWait.until(ExpectedConditions.urlContains("/signup"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void checkInputTypes() {
        Assert.assertEquals(signUpPage.getName().getAttribute("type"), "text");
        Assert.assertEquals(signUpPage.getEmail().getAttribute("type"), "email");
        Assert.assertEquals(signUpPage.getPassword().getAttribute("type"), "password");
    }

    @Test
    public void displayErrorWhenUserExists() {
        String name = "Test Test";
        String email = "admin@admin.com";
        String password = "123654";
        String confirmPassword = "123654";
        signUpPage.fillForm(name, email, password, confirmPassword);
        driverWait.until(ExpectedConditions.visibilityOf(signUpPage.getSignUpErrorMessage()));
        Assert.assertEquals(signUpPage.getSignUpErrorMessage().getText(), "E-mail already exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void signUp() throws InterruptedException {
        String name = faker.name().name();
        String email = faker.internet().safeEmailAddress();
        String password = "123654";
        String confirmPassword = "123654";
        signUpPage.fillForm(name, email, password, confirmPassword);
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getVerifyAccountPopUp()));
        Assert.assertEquals(homePage.getVerifyAccountPopUp().getText(), "IMPORTANT: Verify your account");
    }
}
