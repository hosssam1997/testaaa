package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class TestBases {
    protected WebDriver driver;
    protected String webUrl = "http://www.google.com";
    protected SoftAssert softAssert;
    protected List<WebElement> webElementList;
    String timeStamp = new SimpleDateFormat("MM dd yyyy_ HH mm ss").format(Calendar.getInstance().getTime());




    @BeforeSuite
    public void browserInitialization() {

//        System.setProperty("webdriver.chrome.driver", "driver/New Folder/chromedriver.exe");
        WebDriverManager.chromedriver().setup();


        driver = new ChromeDriver();
        driver.get(webUrl);
        driver.manage().window().maximize();


    }

@AfterMethod
public void ReopenGoogle(){

    driver.get(webUrl);
    driver.manage().window().maximize();

}

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
