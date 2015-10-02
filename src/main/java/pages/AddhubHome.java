package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;

/**
 * Created by sasinda on 10/1/15.
 * Modified by Jacqueline on 10/1/15.
 */
public class AddhubHome extends PageObject {

    @FindBy(id="usr")
    WebElement userName_editbox;
    @FindBy(id="pwd")
    WebElement password_editbox;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement login_button;
    @FindBy(xpath ="//*[@id='searchmap']/div[2]/a)" )
    WebElement postAdd_button;

    public AddhubHome open(){
        driver=openBrowser();
        PageFactory.initElements(driver,this);
        return this;
    }
    /*login() enters the provided username and password into the corrsponding field and submit the form.
        *It does this by searching the form field elements on the page by their HTML ids and send characters to the elements
        */
    public void login(String username, String pw) {
        userName_editbox.sendKeys(username);
        password_editbox.sendKeys(pw);
        login_button.click();
    }





    public PostAddPage navigateToPostAddPage() {
        postAdd_button.click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
        return switchTo(PostAddPage.class);
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









    public WebDriver getDriver() {
        return driver;
    }
}


