package selenium_advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenu {
    private WebDriver driver;
    private static final String expAlertText = "You selected a context menu";

    @Test
    public void isAlertTextValid() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/context_menu");

        // Find element
        WebElement element = driver.findElement(By.id("hot-spot"));

        // Perform right click
        new Actions(driver).contextClick(element).perform();

        // Get alert text
        String actAlertText = driver.switchTo().alert().getText();

        // Close alert
        driver.switchTo().alert().accept();

        // Assert alert text
        Assert.assertEquals(actAlertText, expAlertText);
    }
}
