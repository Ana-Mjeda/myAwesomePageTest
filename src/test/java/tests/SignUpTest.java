package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignUpPage;
import util.FakerUtil;

public class SignUpTest extends BaseTest {

    private SignUpPage signUpPage;

    private String password = "123654";

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
        homePage.clickSignUp();
    }

    @Test
    public void visitSignUpPage() {
        signUpPage.waitForSignupUrl();
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
        signUpPage.fillForm(name, adminEmail, password, password);
        signUpPage.waitForSignupErrorMessage();
        Assert.assertEquals(signUpPage.getSignUpErrorMessage().getText(), "E-mail already exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void signUp() {
        signUpPage.waitForSignupUrl();

        String name = FakerUtil.getName();
        String email = FakerUtil.getEmail();
        signUpPage.fillForm(name, email, password, password);
        signUpPage.waitForVerifyAccountPopup();
        Assert.assertEquals(signUpPage.getVerifyAccountPopUp().getText(), "IMPORTANT: Verify your account");
        signUpPage.closePopUp();
        homePage.clickLogout();
    }
}
