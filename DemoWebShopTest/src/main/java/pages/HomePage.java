package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass {


    By loginLink = By.className("ico-login");
    By registerLink = By.className("ico-register");
    By cartLink = By.className("ico-cart");
    By logoutLink = By.className("ico-logout");
    By computerTab = By.linkText("Computers");
    By desktopOption = By.linkText("Desktops");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

    public void clickComputerTab() {
        driver.findElement(computerTab).click();
    }

    public void clickCartLink() {
        driver.findElement(cartLink).click();
    }
    public void clickLogoutLink() {
        driver.findElement(logoutLink).click();
    }

    public void clickDeskopOption() {
        driver.findElement(desktopOption).click();
    }
}

