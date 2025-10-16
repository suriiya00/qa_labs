package surya1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class lab9 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Launch browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testMacProductPageFlow() {
        // Step 1: Open URL
        driver.get("https://demo.opencart.com");

        // Step 2: Click "Desktops" and then "Mac"
        WebElement desktopsMenu = driver.findElement(By.linkText("Desktops"));
        desktopsMenu.click();
        WebElement macLink = driver.findElement(By.linkText("Mac (1)"));
        macLink.click();

        // Step 3: Sort by "Name (A - Z)"
        Select sortDropdown = new Select(driver.findElement(By.id("input-sort")));
        sortDropdown.selectByVisibleText("Name (A - Z)");

        // Step 4: Click "Add to Cart"
        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(@onclick,'cart.add')]"));
        addToCartButton.click();

        // Step 5: Validate success alert
        WebElement successAlert = driver.findElement(By.className("alert-success"));
        Assert.assertTrue(successAlert.isDisplayed(), "Success alert should be displayed");
        Assert.assertTrue(successAlert.getText().contains("MacBook"), "Alert text should contain 'MacBook'");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
