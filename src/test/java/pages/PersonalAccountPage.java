package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {
    private WebDriver driver;

    private String url = "https://stellarburgers.nomoreparties.site/account/profile";

    private By constructionButton = By.xpath(".//p[text() = 'Конструктор']");
    private By logoButton = By.xpath("//*[@id=\'root\']/div/header/nav/div/a");
    private By exitButton = By.xpath(".//button[text() = 'Выход']");

    public PersonalAccountPage (WebDriver driver) {
        this.driver = driver;
    }

    public void checkRedirectToPersonalAccount () throws InterruptedException {
        Thread.sleep(5000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(url, currentUrl);
    }

    public void goToConstruction() {
        driver.findElement(constructionButton).click();
    }

    public void clickOnLogo() {
        driver.findElement(logoButton).click();
    }

    public void logOut() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(exitButton));
        driver.findElement(exitButton).click();
    }

    public void checkLogOut() throws InterruptedException {
        Thread.sleep(5000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", currentUrl);
    }
}


