package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    private final WebDriver driver;
    public By linksFields = By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']");
    
    public By searchField = By.xpath("//input[@class='gLFyf']");
    public By searchButton = By.xpath("//div[@class='zgAlFc']");
    public By nextPage = By.xpath("//a[@id='pnnext']");
    public By suggestionButtons = By.xpath("//div[@class='s75CSd OhScic AB4Wff']");
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getLinksCount() throws Exception {

        int countOfLinks = 0;
        List<WebElement> links = driver.findElements(linksFields);
        countOfLinks = links.size();
        return countOfLinks;
    }

    public SearchPage searchByWord(String word) throws Exception {

        Utilities.waitAndEnterTextInWebElement(word, searchField, driver);
        Utilities.waitAndClickOnWebElement(searchButton, driver);

        return new SearchPage(driver);

    }

    public SearchPage goToNextPage() throws Exception {
        Utilities.waitAndScrollUntilFindElement(nextPage, driver);
        Utilities.waitAndClickOnWebElement(nextPage, driver);

        return new SearchPage(driver);

    }

    public List<WebElement> getSuggestionText() throws Exception {
        Utilities.waitAndScrollUntilFindElement(nextPage, driver);
        Utilities.waitAndClickOnWebElement(nextPage, driver);
        List<WebElement> links;
        links = driver.findElements(suggestionButtons);

        return links;

    }
}
