package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    private WebDriver driver;

    private String url = "https://stellarburgers.nomoreparties.site/login";

    private By signInButton = By.xpath(".//button[text() = 'Войти']");
    private By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    private By passwordField = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private By makeBurgerText = By.xpath(".//h1[text() = 'Соберите бургер']");
    private By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private By loginEmail = By.xpath(".//input[contains(@name, 'name')][contains(@type, 'text')]");

    public void open() {
        driver.get(url);
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCredentialsAndSignIn (String email, String password) throws InterruptedException {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(signInButton).click();
    }

    public void checkSignIn (String expectedEmail) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(makeBurgerText));
        driver.findElement(personalAccountButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail));
        String email = driver.findElement(loginEmail).getAttribute("value");
        Assert.assertEquals(expectedEmail, email);

    }
}
