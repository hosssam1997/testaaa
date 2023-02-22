package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage {

    private final WebDriver driver;
    public By searchField = By.xpath("//input[@class='gLFyf']");
    public By searchButton = By.xpath("//input[@class='gNO89b']");
    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage searchByWord(String word) throws Exception {

        Utilities.waitAndEnterTextInWebElement(word, searchField, driver);
        Utilities.waitAndClickOnWebElement(searchButton, driver);

        return new SearchPage(driver);

    }

}
