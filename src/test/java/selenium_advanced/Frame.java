package selenium_advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Frame {
    private WebDriver driver;
    private static final String expText = "Your content goes here.";

    @Test
    public void isFrameTextValid() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/iframe");

        // Switch driver to frame
        driver.switchTo().frame("mce_0_ifr");

        String actText = driver.findElement(By.xpath("//body[@id='tinymce']/p")).getText();

        Assert.assertEquals(actText, expText);

        driver.close();
    }
}
