package selenium_advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FileDownload {
    private WebDriver driver;

    @Test
    public void downloadFile() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);

        driver.navigate().to("https://www.thinkbroadband.com/download");

        List<WebElement> list = driver.findElements(By.cssSelector("div.module>p>a>img"));

        WebElement element = list.get(list.size()-1);
        element.click();

        // Wait for file download...
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File folder = new File(System.getProperty("user.dir"));

        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File file = null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("5MB.zip")) {
                    file = new File(fileName);
                    found = true;
                }
            }
        }

        Assert.assertTrue(found, "Downloaded document is not found");
        file.deleteOnExit();

        driver.close();
    }
}
