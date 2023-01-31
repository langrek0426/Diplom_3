package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {
    private WebDriver driver;

    private String url = "https://stellarburgers.nomoreparties.site/forgot-password";

    public By signInButton = By.xpath(".//a[text() = 'Войти']");

    public RecoverPasswordPage (WebDriver driver) {
        this.driver = driver;
    }

    public void open () {
        driver.get(url);
    }

    public void signIn () {
        driver.findElement(signInButton).click();
    }
}
