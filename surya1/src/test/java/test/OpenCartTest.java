package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.HomePage;
import pages.MacPage;

import java.time.Duration;

public class OpenCartTest {

    WebDriver driver;
    HomePage homePage;
    MacPage macPage;

    @BeforeClass
    public void setUp() {
        // If chromedriver is in PATH, you can remove this line
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        // Initialize page objects
        homePage = new HomePage(driver);
        macPage = new MacPage(driver);
    }

    @Test
    public void testAddMacToCart() {
        homePage.goToMacSection();
        macPage.sortByNameAZ();
        macPage.addToCart();

        // Assertions using TestNG
        Assert.assertTrue(macPage.isSuccessMessageDisplayed(), "Success message not displayed");
        Assert.assertTrue(macPage.getSuccessMessageText().contains("MacBook"), "Message should mention MacBook");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
