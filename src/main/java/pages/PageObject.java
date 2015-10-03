package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by sasinda on 10/1/15.
 */
public class PageObject {

    private String baseUrl;
    protected static WebDriver driver;


    public WebDriver openBrowser() {
        baseUrl = "http://10.128.6.80:9000";
        System.setProperty("webdriver.chrome.driver", this.getClass().getResource("/chromedriver").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(baseUrl);

        return driver;
    }

    public void closeBrowser() {
        driver.close();
    }

    /**
     * switch to the given type of page
     * @param page
     * @param <T>
     * @return
     */
    public <T> T switchTo(Class<T> page)  {
        T p = null;
        try {
            p = page.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        PageFactory.initElements(driver,p);
        return p;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void saveScreenshot(String screenshotFileName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(screenshotFileName));
    }
}
