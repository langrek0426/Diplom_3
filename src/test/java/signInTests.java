import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RecoverPasswordPage;
import pages.RegistrationPage;


public class signInTests {
    private WebDriver driver;
    private String postfix;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        postfix = registrationPage.generateRandomPostfix();
        registrationPage.fillRegistrationInfoAndSignUp("username" + postfix, "email"+postfix+"@gmail.com", "1234567");
    }

    @Test
    public void signInMainPageTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.signIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillCredentialsAndSignIn("email"+postfix+"@gmail.com", "1234567");
        loginPage.checkSignIn();
    }

    @Test
    public void signInPersonalAccountTest () throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.goToPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillCredentialsAndSignIn("email"+postfix+"@gmail.com", "1234567");
        loginPage.checkSignIn();
    }

    @Test
    public void signInFromRegistrationPageTest () throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.signIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillCredentialsAndSignIn("email"+postfix+"@gmail.com", "1234567");
        loginPage.checkSignIn();
    }

    @Test
    public void signInFromRecoverPasswordPageTest () throws InterruptedException {
        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);
        recoverPasswordPage.open();
        recoverPasswordPage.signIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillCredentialsAndSignIn("email"+postfix+"@gmail.com", "1234567");
        loginPage.checkSignIn();
        System.out.println(5);
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
