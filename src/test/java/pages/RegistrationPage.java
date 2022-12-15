package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;


public class RegistrationPage {
    private WebDriver driver;

    private String url = "https://stellarburgers.nomoreparties.site/register";

    private By nameField = By.xpath(".//label[text()='Имя']/following-sibling::input");
    private By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    private By passwordField = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private By signUpButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private By invalidPasswordMessage = By.xpath(".//p[text()='Некорректный пароль']");
    private By signInButton = By.xpath(".//a[text() = 'Войти']");
    private By signInText = By.xpath(".//h2[text()='Вход']");

    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }
    public String generateRandomPostfix() {
        Random random = new Random();
        String postfix = Integer.toString(random.nextInt(10000));
        return postfix;
    }
    public void fillRegistrationInfoAndSignUp(String name, String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signUpButton).click();
    }

    public void checkRegistration() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInText));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", currentUrl);
    }

    public void checkInvalidPassword() {
        boolean isPresent = driver.findElement(invalidPasswordMessage).isDisplayed();
        Assert.assertTrue(isPresent);
    }

    public void signIn () {
        driver.findElement(signInButton).click();
    }


}
