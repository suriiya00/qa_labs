package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MacPage {

    WebDriver driver;

    @FindBy(id = "input-sort")
    WebElement sortDropdown;

    @FindBy(xpath = "//button[contains(@onclick,'cart.add')]")
    WebElement addToCartButton;

    @FindBy(className = "alert-success")
    WebElement successAlert;

    public MacPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sortByNameAZ() {
        new Select(sortDropdown).selectByVisibleText("Name (A - Z)");
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        return successAlert.isDisplayed();
    }

    public String getSuccessMessageText() {
        return successAlert.getText();
    }
}
