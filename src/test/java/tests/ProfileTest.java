package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import util.FakerUtil;

public class ProfileTest extends BaseTest {

    private ProfilePage profilePage;

    private LoginPage loginPage;

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
        loginPage.loginForm(adminEmail, adminPassword);
        homePage.clickProfileButton();
        String name = FakerUtil.getName();
        String phone = FakerUtil.getPhoneNumber();
        String city = "New York";
        String country = FakerUtil.getCountry();
        String twitter = FakerUtil.getTwitter();
        String gitHub = FakerUtil.getGitHub();
        profilePage.editProfile(name, phone, city, country, twitter, gitHub);

        profilePage.waitForMessage();
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
