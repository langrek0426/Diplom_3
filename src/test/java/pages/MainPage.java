package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    private String url = "https://stellarburgers.nomoreparties.site/";

    private By signInButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    private By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private By banTab = By.xpath(".//span[text() = 'Булки']");
    private By sauceTab = By.xpath(".//span[text() = 'Соусы']");
    private By fillingTab = By.xpath(".//span[text() = 'Начинки']");
    private By banText = By.xpath(".//h2[text() = 'Булки']");
    private By sauceText = By.xpath(".//h2[text() = 'Соусы']");
    private By fillingText = By.xpath(".//h2[text() = 'Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void signIn() {
        driver.findElement(signInButton).click();
    }

    public void goToPersonalAccount() {
        driver.findElement(personalAccountButton).click();
    }

    public void checkRedirect() throws InterruptedException {
        Thread.sleep(5000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(url, currentUrl);
    }

    public void clickOnBanTab () {
        driver.findElement(banTab).click();
    }

    public void checkBanTab () {
        boolean isPresent = driver.findElement(banText).isDisplayed();
        Assert.assertTrue(isPresent);
    }

    public void clickOnSauceTab () {
        driver.findElement(sauceTab).click();
    }

    public void checkSauceTab () {
        boolean isPresent = driver.findElement(sauceText).isDisplayed();
        Assert.assertTrue(isPresent);
    }

    public void clickOnFillingTab () {
        driver.findElement(fillingTab).click();
    }

    public void checkFillingTab () {
        boolean isPresent = driver.findElement(fillingText).isDisplayed();
        Assert.assertTrue(isPresent);
    }

}

