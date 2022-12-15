import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalAccountPage;
import pages.RegistrationPage;

public class redirectionTests {
    private WebDriver driver;
    private String postfix;
    private MainPage mainPage;

    @Before
    public void startUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        postfix = registrationPage.generateRandomPostfix();
        registrationPage.fillRegistrationInfoAndSignUp("username" + postfix, "email"+postfix+"@gmail.com", "1234567");
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.signIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillCredentialsAndSignIn("email"+postfix+"@gmail.com", "1234567");
    }

    @Test
    public void redirectToPersonalAccount() throws InterruptedException {
        mainPage.goToPersonalAccount();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.checkRedirectToPersonalAccount();
    }

    @Test
    public void redirectFromPersonalAccountToConstructionTest() throws InterruptedException {
        mainPage.goToPersonalAccount();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.goToConstruction();
        mainPage.checkRedirect();
    }

    @Test
    public void redirectFromPersonalAccountToConstructionWithLogoTest() throws InterruptedException {
        mainPage.goToPersonalAccount();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickOnLogo();
        mainPage.checkRedirect();
    }

    @Test
    public void redirectLogOutTest() throws InterruptedException {
        mainPage.goToPersonalAccount();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.logOut();
        personalAccountPage.checkLogOut();
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
