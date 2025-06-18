package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Billing extends BaseClass {


    public Billing(WebDriver driver) {
        super(driver);
    }

    By country = By.id("BillingNewAddress_CountryId");
    By city = By.id("BillingNewAddress_City");
    By address1 = By.id("BillingNewAddress_Address1");
    By postalCode = By.id("BillingNewAddress_ZipPostalCode");
    By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
    By continueBilling = new By.ByXpath("//div[@class='buttons']//input[@onclick='Billing.save()']");
    By continueShipping = new By.ByXpath("//div[@class='buttons']//input[@onclick='Shipping.save()']");
    By continueShippingMethod = new By.ByXpath("//div[@class='buttons']//input[@onclick='ShippingMethod.save()']");
    By continuePaymentMethod = new By.ByXpath("//div[@class='buttons']//input[@onclick='PaymentMethod.save()']");
    By continuePaymentInfo = new By.ByXpath("//div[@class='buttons']//input[@onclick='PaymentInfo.save()']");
    By continueConfirmOrder = new By.ByXpath("//div[@class='buttons']//input[@onclick='ConfirmOrder.save()']");
    By lblthankyou = new ByXpath("//div[@class='page-title']");


    public void enterDetailsForBilling(String country,String city, String address1, String postalCode,String phoneNumber) {
        driver.findElement(country).sendKeys(country);
        driver.findElement(city).sendKeys(city);
        driver.findElement(address1).sendKeys(address1);
        driver.findElement(postalCode).sendKeys(postalCode);
        driver.findElement(phoneNumber).sendKeys(phoneNumber);
        driver.findElement(continueBilling).click();
        driver.findElement(continueShipping).click();
        driver.findElement(continueShippingMethod).click();
        driver.findElement(continuePaymentMethod).click();
        driver.findElement(continuePaymentInfo).click();
        driver.findElement(continueConfirmOrder).click();

        if(lblthankyou.getText().equal("Thank you")){
            System.out.println("Successfully validated the Thank You text");
            
        } else {
            System.out.println("Failed validated the Thank You text");
        }
    }
}
