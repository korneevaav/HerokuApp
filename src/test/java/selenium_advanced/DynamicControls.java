package selenium_advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicControls {
    private WebDriver driver;
    private static final String textGone = "It's gone!";
    private static final String textEnabled = "It's enabled!";

    @Test
    public void isInputEnabled() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        // Find checkbox
        driver.findElement(By.xpath("//form[@id='checkbox-example']/div[@id='checkbox']/input[@type='checkbox']")).click();

        // Find and click button
        driver.findElement(By.xpath("//form[@id='checkbox-example']/button")).click();

        // Wait 3s
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Check text
        if (!driver.findElement(By.xpath("//form[@id='checkbox-example']/p[@id='message']")).getText().equals(textGone)) {
            Assert.fail();
        }

        // Check checkbox exists
        if (!(driver.findElements(By.xpath("//form[@id='checkbox-example']/div[@id='checkbox']/input[@type='checkbox']")).size() == 0)) {
            Assert.fail();
        }

        // Find input
        WebElement input = driver.findElement(By.xpath("//form[@id='input-example']/input[@type='text']"));

        // Check is input enabled
        if (input.isEnabled()) {
            Assert.fail();
        }

        // Find and click button
        driver.findElement(By.xpath("//form[@id='input-example']/button")).click();

        // Wait 3s
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Check text
        if (!driver.findElement(By.xpath("//form[@id='input-example']/p[@id='message']")).getText().equals(textEnabled)) {
            Assert.fail();
        }

        // Check is input enabled
        if (!input.isEnabled()) {
            Assert.fail();
        }

        driver.close();
    }
}
