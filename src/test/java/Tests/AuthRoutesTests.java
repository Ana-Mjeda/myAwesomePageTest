package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest{

    @Test
    public void unauthorizedHomePageRedirectsToLogin(){
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
    @Test
    public void unauthorizedProfilePageRedirectsToLogin(){
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
    @Test
    public void unauthorizedAdminCitiesPageRedirectsToLogin(){
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
    @Test
    public void unauthorizedAdminUsersPageRedirectsToLogin(){
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
