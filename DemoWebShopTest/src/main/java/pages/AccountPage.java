package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions; 


public class AccountPage extends BaseClass {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    By myAccount = new By.ByXPath("//div[@class='footer']//a[@class='account']");
    By orders = new By.ByXPath("//div[@class='block block-account-navigation']//a[contains(text(),'Orders')]");
    By lblOrderNumber = new By.ByXPath("//div[@class='order-list']//div//div//strong");
    By lblOrderStatus = new BY.ByXPath("//div[@class='order-list']//ul//li[1]");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));

    public void validateOrderCreated() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccount)); 
        driver.findElement(myAccount).click();
        wait.until(ExpectedConditions.elementToBeClickable(orders)); 
        driver.findElement(orders).click();

        if(lblOrderNumber.getText().contains("Order Number")){
            System.out.println("Successfully validated the Order Number text");
            
        } else {
            System.out.println("Failed validated the Order Number text");
        }

        if(lblOrderStatus.getText().contains("Order status: Pending")){
            System.out.println("Successfully validated the Order status: Pending text");
            
        } else {
            System.out.println("Failed validated the Order status: Pending text");
        }
    }

}
