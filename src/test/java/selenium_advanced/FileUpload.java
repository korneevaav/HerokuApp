package selenium_advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload {
    private WebDriver driver;

    @Test
    public void uploadFile() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/upload");

        String filePath = System.getProperty("user.dir") + "/src/test/resources/image/cat.jpg";
        driver.findElement(By.id("file-upload")).sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

        // Now check file name
        String actFileName = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actFileName, "cat.jpg");

        driver.close();
    }
}
