package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CartPage extends BaseClass{
private final HomePage homePage;

    public CartPage(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    By item1 = new By.ByXPath("//div[@data-productid='72']");
    By item2 = new By.ByXPath("//div[@data-productid='16']");
    By item3 = new By.ByXPath("//div[@data-productid='74']");
    By item4 = new By.ByXPath("//div[@data-productid='75']");
    By addCart = new By.ByXPath("//div[@class='add-to-cart-panel']//input[@value='Add to cart']");
    By processer = new By.ByXPath("//ul[@class='option-list']//label[contains(text(),'Slow')]");
    By hdd = new By.ByXPath("//ul[@class='option-list']//label[contains(text(),'320 GB')]");
    By totalPrice = new By.ByXPath("//span[@class='product-price order-total']");
    By removeItem = new By.ByXPath("//tr[@class='cart-item-row'][1]//input");
    By updateShoppingCart = new By.ByXPath("//input[@value='Update shopping cart']");
    By checkout = By.id("checkout");
    By termsAndCon = By.id("termsofservice");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));

    WebElement sortBy = driver.findElement(By.xpath("//select[@id='products-orderby']"));
    Select select = new Select(sortBy);
    By desktopOption = By.linkText("Desktops");


    public void clickDeskopOption() {
        driver.findElement(desktopOption).click();
    }

    public void sortByAll() {
//        select.selectByIndex(0);
//        sortBy = wait.until(ExpectedConditions.elementToBeClickable(sortBy));
//        select.selectByIndex(1);
//        sortBy = wait.until(ExpectedConditions.elementToBeClickable(sortBy));
//        select.selectByIndex(2);
////        wait.until(ExpectedConditions.elementToBeClickable(sortBy));
//        select.selectByIndex(3);
////        wait.until(ExpectedConditions.elementToBeClickable(sortBy));
//        select.selectByIndex(4);
////        wait.until(ExpectedConditions.elementToBeClickable(sortBy));
//        select.selectByIndex(5);

    }


    public void addDesktopsToCart() {
//        Item1
        driver.findElement(item1).click();
        driver.findElement(addCart).click();
        clickDeskopOption();

//        Item2
        driver.findElement(item2).click();
        driver.findElement(hdd).click();
        driver.findElement(addCart).click();
        clickDeskopOption();

//        Item 3
        driver.findElement(item3).click();
        driver.findElement(addCart).click();
        clickDeskopOption();

//        Item 4
        driver.findElement(item4).click();
        driver.findElement(processer).click();
        driver.findElement(addCart).click();
        homePage.clickCartLink();

//        Validation
        validateTotalBeforeItemRemoved();
    }

    public void removeOneItem() {
        driver.findElement(removeItem).click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,500)");
        driver.findElement(updateShoppingCart).click();
    }

    public void validateTotalBeforeItemRemoved() {
        String value = driver.findElement(totalPrice).getText();
        if(value.equals("4695.00")){
            System.out.println("Successfully validated the total price");
        }else {
            System.out.println("failed validated the total price");
        }
    }

    public void validateTotalAfterItemRemoved() {
        String value = driver.findElement(totalPrice).getText();
        if(value.equals("3895.00")){
            System.out.println("Successfully validated the total price after an item removed");
        }else {
            System.out.println("failed validated the total priceafter an item removed");
        }
    }

    public void proceedToCheckout() {
        driver.findElement(termsAndCon).click();
        driver.findElement(checkout).click();
    }
}
