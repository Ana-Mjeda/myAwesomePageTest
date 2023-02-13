package Tests;

import Pages.Languages;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {

    @Test
    public void setLocaleToEs() {
        homePage.clickLanguageButton();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getSpanish()));
        homePage.chooseLanguage(Languages.ES);
        Assert.assertTrue((homePage.getHeader().getText().contains("Página de aterrizaje")));
    }

    @Test
    public void setLocaleToEn() {
        homePage.clickLanguageButton();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getEnglish()));
        homePage.chooseLanguage(Languages.EN);
        Assert.assertTrue((homePage.getHeader().getText().contains("Landing")));
    }

    @Test
    public void setLocaleToFr() {
        homePage.clickLanguageButton();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getFrench()));
        homePage.chooseLanguage(Languages.FR);
        Assert.assertTrue((homePage.getHeader().getText().contains("Page d'atterrissage")));
    }
}
