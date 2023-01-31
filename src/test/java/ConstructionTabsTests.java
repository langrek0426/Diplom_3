import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class ConstructionTabsTests {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    public void banTabTest() {
        mainPage.clickOnSauceTab();
        mainPage.clickOnBanTab();
        mainPage.checkBanTab();
    }

    @Test
    public void sauceTabTest() {
        mainPage.clickOnSauceTab();
        mainPage.checkSauceTab();
    }
    @Test
    public void fillingTabTest() {
        mainPage.clickOnFillingTab();
        mainPage.checkFillingTab();
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
