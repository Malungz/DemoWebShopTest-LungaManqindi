package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.CartPage;
import pages.HomePage;
import pages.Login;
import pages.RegisterPage;
import pages.Billing;
import pages.AccountPage;

public class LocalRunner {

    public static void main (String [] arg) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        HomePage home = new HomePage(driver);
        RegisterPage register = new RegisterPage(driver);
        Login login = new Login(driver);
        Billing bill = new Billing(driver); 
        AccountPage account = new AccountPage(driver);

        int randomNo = (int)(Math.random() * 1000);

       home.clickRegisterLink();
       register.register("John"+randomNo, "Doe", "john"+randomNo+".doe@mail.com", "Test1234");
       home.clickLogoutLink();

        home.clickLoginLink();
       login.login("john"+randomNo+".doe@mail.com", "Test1234");
        // login.login("john30.doe@mail.com", "Test1234");

        home.clickComputerTab();
        home.clickDeskopOption();
        CartPage cart = new CartPage(driver);

        cart.sortByAll();
        cart.addDesktopsToCart();
        cart.validateTotalBeforeItemRemoved();
        cart.removeOneItem();
        cart.validateTotalAfterItemRemoved();
        cart.proceedToCheckout();

        bill.enterDetailsForBilling("South Africa","Cape Town","7 Sagwityi","7784","0987654321"); 
        account.validateOrderCreated();

        driver.quit();
    }
}
