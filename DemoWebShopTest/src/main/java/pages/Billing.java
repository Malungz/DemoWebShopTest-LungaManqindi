package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions; 


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
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));


    public void enterDetailsForBilling(String country,String city, String address1, String postalCode,String phoneNumber) {
        driver.findElement(this.country).sendKeys(country);
        driver.findElement(this.city).sendKeys(city);
        driver.findElement(this.address1).sendKeys(address1);
        driver.findElement(this.postalCode).sendKeys(postalCode);
        driver.findElement(this.phoneNumber).sendKeys(phoneNumber);
        driver.findElement(continueBilling).click();
        wait.until(ExpectedConditions.elementToBeClickable(continueShipping)); 
        driver.findElement(continueShipping).click(); 
        wait.until(ExpectedConditions.elementToBeClickable(continueShippingMethod)); 
        driver.findElement(continueShippingMethod).click(); 
        wait.until(ExpectedConditions.elementToBeClickable(continuePaymentMethod)); 
        driver.findElement(continuePaymentMethod).click(); 
        wait.until(ExpectedConditions.elementToBeClickable(continuePaymentInfo)); 
        driver.findElement(continuePaymentInfo).click(); 
        wait.until(ExpectedConditions.elementToBeClickable(continueConfirmOrder)); 
        driver.findElement(continueConfirmOrder).click();


        if(lblthankyou.getText().equal("Thank you")){
            System.out.println("Successfully validated the Thank You text");
            
        } else {
            System.out.println("Failed validated the Thank You text");
        }
    }
}
