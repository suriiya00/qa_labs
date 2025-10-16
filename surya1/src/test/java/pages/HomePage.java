package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(linkText = "Desktops")
    WebElement desktopsMenu;

    @FindBy(linkText = "Mac (1)")
    WebElement macLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToMacSection() {
        desktopsMenu.click();  // Open the dropdown
        macLink.click();       // Go to Mac section
    }
}
