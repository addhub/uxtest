package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by sasinda on 10/1/15.
 */
public class AddhubHome {

    private String baseUrl;
    private WebDriver driver;


    public AddhubHome openBrowser() {
        baseUrl = "http://www.google.com";
        System.setProperty("webdriver.chrome.driver", this.getClass().getResource("/chromedriver").getPath());
        driver = new ChromeDriver();
        driver.get(baseUrl);
        return this ;

    }

    public void closeBrowser(){
        driver.close();
    }

    public String getTitle(){
        return driver.getTitle();
    }


    public void saveScreenshot(String screenshotFileName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(screenshotFileName));
    }

    public WebDriver getDriver() {
        return driver;
    }
}


