package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends  BaseClass {

    // Constructor
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    By gender = By.id("gender-male");
    By firstNameField = By.id("FirstName");
    By lastNameField = By.id("LastName");
    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By confirmPassField = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");

    public void register(String firstName, String lastName, String email, String password) {
        driver.findElement(gender).click();
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPassField).sendKeys(password);
        driver.findElement(registerButton).click();

    }
}

