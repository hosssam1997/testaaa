package TestCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import Utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bson.assertions.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WindowHandle_Demo {

    public By visitLink = By.linkText("Visit W3Schools.com!");
    public By logo = By.cssSelector(".fa.fa-logo");
    public By seeResultButton = By.cssSelector("button[onclick*='submitTryit(1)'");
    public By seeRe = By.xpath("//div[@id='iframewrapper']//iframe[@id='iframeResult']");



    public static WebElement f(WebDriver driver , By by_obj) throws Exception {

        WebElement x = driver.findElement(by_obj);
        return x;
    }
    @Test
    public void test1() throws Exception {
        WindowHandle_Demo oo = new WindowHandle_Demo();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        SoftAssert s = new SoftAssert();

//1) Navigate to URL
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
        driver.manage().window().maximize();
//        driver.navigate().back();
//        driver.navigate().forward();
        driver.navigate().refresh();

        //2) Get the current window's handle and write to the console window. It must be first window handle.
        Utilities.waitAndClickOnWebElement(oo.seeRe,driver);

        System.out.println("Current Window Handle0: " + driver.getWindowHandle() + "\n");
        //Switch to iframeResult iframe because all elements located in this iframe
//        driver.switchTo().frame("iframeResult");
//        WebElement x = Utilities.waitUntilWebElementIsPresent(oo.seeRe,driver);
        WebElement x = Utilities.waitUntilWebElementIsPresent(oo.seeRe,driver);
        driver.switchTo().frame(x);
        //3) Locate the link and click it
//        WebElement visitLink = driver.findElement(By.linkText("Visit W3Schools.com!"));

//        WebElement visitLink = f(driver,oo.visitLink);
//        visitLink.click();
        Utilities.waitUntilWebElementIsPresent(oo.visitLink, driver);
        Utilities.waitAndClickOnWebElement(oo.visitLink, driver);

        //4) Get all window handles and hold them in a list.
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles); //Set to List Conversion
        //5) Write to total window handle number to the console.
        System.out.println("Total window number: " + windowHandlesList.size() + "\n");
        Thread.sleep(2000);

        //6) Switch to second window
        driver.switchTo().window(windowHandlesList.get(1));
        //7) Get the current window's handle and write to the console window. It must be second window handle.
        System.out.println("Current Window Handle1: " + driver.getWindowHandle() + "\n");
        //8) Check the upper left side logo
//        WebElement logo = driver.findElement(By.cssSelector(".fa.fa-logo"));
//        WebElement logo = f(driver,oo.logo);
        WebElement logo = Utilities.waitUntilWebElementIsPresent(oo.logo, driver);
//        Assert.assertTrue(logo.isDisplayed());
        s.assertTrue(logo.isDisplayed());
        //9) Go back (Switch) to first window
//        Thread.sleep(2000);
        driver.switchTo().window(windowHandlesList.get(0));
        //10) Get the current window's handle and write to the console window. It must be first window handle.
        System.out.println("Current Window Handle2: " + driver.getWindowHandle() + "\n");
        //11) Check the Run Button Text
//        WebElement seeResultButton = driver.findElement(By.cssSelector("button[onclick*='submitTryit(1)'"));
//        WebElement seeResultButton = f(driver,oo.seeResultButton);
        WebElement seeResultButton = Utilities.waitUntilWebElementIsPresent(oo.seeResultButton, driver);

        s.assertTrue(seeResultButton.getText().contains("Run ❯"));
//        Assert.assertTrue(seeResultButton.getText().contains("Run ❯"));
        Thread.sleep(5000);
        driver.quit();
        s.assertAll();
    }
}