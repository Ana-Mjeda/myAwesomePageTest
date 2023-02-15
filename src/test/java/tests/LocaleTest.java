package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Languages;

public class LocaleTest extends BaseTest {

    @Test
    public void setLocaleToEs() {
        homePage.clickLanguageButton();
        homePage.waitForSpanish();
        homePage.chooseLanguage(Languages.ES);
        Assert.assertTrue((homePage.getHeader().getText().contains("Página de aterrizaje")));
    }

    @Test
    public void setLocaleToEn() {
        homePage.clickLanguageButton();
        homePage.waitForEnglish();
        homePage.chooseLanguage(Languages.EN);
        Assert.assertTrue((homePage.getHeader().getText().contains("Landing")));
    }

    @Test
    public void setLocaleToFr() {
        homePage.clickLanguageButton();
        homePage.waitForFrench();
        homePage.chooseLanguage(Languages.FR);
        Assert.assertTrue((homePage.getHeader().getText().contains("Page d'atterrissage")));
    }
}
