package Tests;

import Pages.LoginPage;
import Pages.ProfilePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {

    private ProfilePage profilePage;

    private LoginPage loginPage;

    String email = "admin@admin.com";

    String password = "12345";

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        profilePage = new ProfilePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
    }

    @Test
    public void editProfile() {
        homePage.clickLogin();
        loginPage.loginForm(email, password);
        homePage.clickProfileButton();
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().cellPhone();
        String city = "New York";
        String country = faker.country().name();
        String twitter = "https://github.com/" + faker.name().username().toLowerCase();
        String gitHub = "https://twitter.com/" + faker.name().username().toLowerCase();
        profilePage.editProfile(name, phone, city, country, twitter, gitHub);

        driverWait.until(ExpectedConditions.visibilityOf(profilePage.getMessage()));
        Assert.assertTrue(profilePage.getMessage().getText().contains("Profile saved successfuly"));

        profilePage.clickCloseButton();

        Assert.assertEquals(profilePage.getInputName(), name);
        Assert.assertEquals(profilePage.getInputPhone(), phone);
        Assert.assertEquals(profilePage.getInputCity(), city);
        Assert.assertEquals(profilePage.getInputCountry(), country);
        Assert.assertEquals(profilePage.getInputTwitter(), twitter);
        Assert.assertEquals(profilePage.getInputGitHub(), gitHub);
    }
}
