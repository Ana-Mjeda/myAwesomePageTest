package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    protected WebDriverWait driverWait;

    protected HomePage homePage;

    protected final String baseURL = "https://vue-demo.daniel-avellaneda.com";

    protected final String adminEmail = "admin@admin.com";

    protected final String adminPassword = "12345";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseURL);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
