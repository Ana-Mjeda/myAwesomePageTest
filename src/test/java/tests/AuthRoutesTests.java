package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AuthRoutesTests extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
    }

    private void assertLogin() {
        loginPage.waitForLoginUrl();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void unauthorizedHomePageRedirectsToLogin() {
        driver.get(baseURL + "/home");
        assertLogin();
    }

    @Test
    public void unauthorizedProfilePageRedirectsToLogin() {
        driver.get(baseURL + "/profile");
        assertLogin();
    }

    @Test
    public void unauthorizedAdminCitiesPageRedirectsToLogin() {
        driver.get(baseURL + "/admin/cities");
        assertLogin();
    }

    @Test
    public void unauthorizedAdminUsersPageRedirectsToLogin() {
        driver.get(baseURL + "/admin/users");
        assertLogin();
    }
}
