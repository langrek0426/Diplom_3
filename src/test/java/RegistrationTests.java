import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;

public class RegistrationTests {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private String postfix;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        postfix = registrationPage.generateRandomPostfix();
    }


    @Test
    public void successfulRegistrationTest() {
        registrationPage.fillRegistrationInfoAndSignUp("username" + postfix, "email"+postfix+"@gmail.com", "12345678");
        registrationPage.checkRegistration();
    }

    @Test
    public void invalidPasswordRegistrationTest() {
        registrationPage.fillRegistrationInfoAndSignUp("username" + postfix, "email"+postfix+"@gmail.com", "12345");
        registrationPage.checkInvalidPassword();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}