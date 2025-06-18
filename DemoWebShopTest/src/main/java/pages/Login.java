package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BaseClass{

    public Login(WebDriver driver) {
        super(driver);
    }

    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By loginButton = new By.ByXPath("//input[@value='Log in']");

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

    }
}
