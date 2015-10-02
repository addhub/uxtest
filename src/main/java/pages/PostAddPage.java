package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by jingxiapang on 10/1/15.
 */
public class PostAddPage extends PageObject {

    @FindBy(id = "title")
    WebElement title_textbox;

    @FindBy(xpath ="" )
    WebElement categoriesList;

    @FindBy(xpath ="" )
    WebElement description;

    @FindBy(xpath = "")
    WebElement postButton;



    public void postInfo() {
        postButton.click();
    }

    public void selectsCategory(String category) {
        categoriesList.findElement(
                By.linkText(category)).click();
    }

    public void setTitle(String title) {
        title_textbox.sendKeys(title);
    }
}
