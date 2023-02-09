package Tests;

import Pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{

    private SignUpPage signUpPage;
    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        signUpPage = new SignUpPage(driver, driverWait);
    }

    @Test
    public void visitSignUpPage() throws InterruptedException {
        homePage.clickSingUp();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

}
