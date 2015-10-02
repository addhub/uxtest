package pages;

import javafx.print.PageOrientation;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;

/**
 * Created by sasinda on 10/1/15.
 * Modified by Jacqueline on 10/1/15.
 */
public class AddhubHome extends PageObject{

    private String baseUrl;
    private WebDriver driver;


    public AddhubHome openBrowser() {
        baseUrl = "http://10.128.14.59:9000";
        System.setProperty("webdriver.chrome.driver", this.getClass().getResource("/chromedriver").getPath());
        driver = new ChromeDriver();
        driver.get(baseUrl);
        return this ;

    }

    /*login() enters the provided username and password into the corrsponding field and submit the form.
    *It does this by searching the form field elements on the page by their HTML ids and send characters to the elements
    */
    public void login(String username, String pw){
        WebElement userName_editbox = driver.findElement(By.id("usr"));
        WebElement password_editbox = driver.findElement(By.id("pwd"));
        WebElement submit_button = driver.findElement(By.xpath("//input[@value='Login']"));

        userName_editbox.sendKeys(username);
        password_editbox.sendKeys(pw);

        submit_button.click();
    }


    private WebElement postButton;
    private WebElement addButton;
    private WebElement categoriesList;


    public void postInfo() {
        postButton.click();
    }

    public void selectsCategory(String category) {
        categoriesList.findElement(
                By.linkText(category)).click();
    }

    public void navigateToPostAddPage(){

        WebElement submit_add = driver.findElement(By.xpath("//*[@id='searchmap']/div[2]/a)"));
        submit_add.click();

    }

    /**
     * grabs the status text and saves that into status.txt file. Else @throws IOException
     **/
    public void getText() throws IOException {
        String text = driver.findElement(By.xpath("//div[@id='case_login']/h3")).getText();
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("status.txt"), "utf-8"));
        writer.write(text);
        writer.close();

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


