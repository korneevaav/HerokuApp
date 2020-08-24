package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HerokuApp {
    WebDriver browser;

    @Test
    public void bla() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        /*ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        ChromeOptions options;*/

        /*browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.quit();*/

        /*browser = new ChromeDriver();
        browser.manage().window().setSize(new Dimension(1024, 768));
        browser.quit();*/

        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        browser.findElement(By.name("name")).click();
        browser.quit();


    }
}
