package TestCases;

import Pages.GooglePage;
import Pages.SearchPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTestCases extends TestBases {

    protected GooglePage googlePage;
    protected SearchPage searchPage;

    @Test
    public void searchByKeywords() throws Exception {

        softAssert = new SoftAssert();

        googlePage = new GooglePage(driver);
        searchPage = googlePage.searchByWord("tests");

        searchPage.searchByWord("test");
        int firstPageCount = searchPage.getLinksCount();
        softAssert.assertNotEquals(firstPageCount, 0, "There are no links in the page");
        searchPage.goToNextPage();


        softAssert.assertAll();
    }

    @Test
    public void compareCountOfPages() throws Exception {
        searchByKeywords();
        int secondPageCount = searchPage.getLinksCount();
        searchPage.goToNextPage();

        int thirdPageCount = searchPage.getLinksCount();

        softAssert.assertEquals(secondPageCount, thirdPageCount, "The 2 pages links is not the same count");
        softAssert.assertAll();
    }

    @Test
    public void checkDifferanceOfSuggestion() throws Exception {

        searchByKeywords();
        webElementList = searchPage.getSuggestionText();
        for (int i = 0; i < webElementList.size(); i++) {
            for (int j = i + 1; j < webElementList.size() - 1; j++) {
                softAssert.assertNotEquals(webElementList.get(j).getText(), webElementList.get(i).getText(),
                        "There is a suggestion duplicated in the list");
            }
        }
        softAssert.assertAll();
    }
}
