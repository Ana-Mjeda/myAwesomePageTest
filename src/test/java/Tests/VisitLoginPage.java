package Tests;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VisitLoginPage extends BaseTest{

    private HomePage homePage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
    }
    @Test
    public void loginURL(){
        homePage.clickLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
}
