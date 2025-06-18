package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BaseClass {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    By myAccount = new By.ByXPath("//div[@class='header']//a[@class='account']");
    By orders = new By.ByXPath("//div[@class='block block-account-navigation']//a[contains(text(),'Orders')]");
    By lblOrderNumber = new By.ByXPath("//div[@class='order-list']//div//div//strong");
    By lblOrderStatus = new BY.ByXPath("//div[@class='order-list']//ul//li[1]");

    public void validateOrderCreated() {
        driver.findElement(myAccount).click();
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