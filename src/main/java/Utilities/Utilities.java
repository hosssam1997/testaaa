package Utilities;


import org.apache.commons.lang.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import static jdk.internal.org.objectweb.asm.Opcodes.NULL;

public class Utilities {
    public static long timeOut = 2;//in seconds


    public static WebElement waitUntilWebElementIsPresent(By element, WebDriver driver) throws Exception {
        WebElement x = null;
        if (element != null) {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            try {
                x = wait.until(ExpectedConditions.visibilityOfElementLocated(element));

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return x;
    }


    public static void waitAndClickOnWebElement(By element, WebDriver driver) throws Exception {
        if (element != null) {
            Utilities.waitUntilWebElementIsPresent(element, driver);
            try {
                driver.findElement(element).click();
            } catch (Exception ex) {
                throw new Exception("Can not click on webElement: " + element);
            }
        }
    }


    public static void waitAndEnterTextInWebElement(String text, By element, WebDriver driver) throws Exception {
        if (element != null) {
            Utilities.waitUntilWebElementIsPresent(element, driver);
            try {
                driver.findElement(element).clear();
                driver.findElement(element).sendKeys(text);
            } catch (Exception ex) {
                throw new Exception("Can not enter text in webElement: " + element);
            }
        }
    }

    public static WebElement waitAndScrollUntilFindElement(By element, WebDriver driver) throws Exception {
        WebElement x =null;
        if (element != null) {
            Utilities.waitUntilWebElementIsPresent(element, driver);
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));

            } catch (Exception ex) {
                throw new Exception("Can not enter text in webElement: " + element);
            }
        }
        return x;
    }

}
