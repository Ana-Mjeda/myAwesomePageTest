package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    private void assertLogin() {
        driverWait.until(ExpectedConditions.urlContains("/login"));
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
