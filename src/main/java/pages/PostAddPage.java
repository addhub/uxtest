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

    @FindBy(xpath ="" )
    WebElement keywords;

    @FindBy(xpath ="" )
    WebElement address;
    @FindBy(xpath ="" )
    WebElement state;
    @FindBy(xpath ="" )
    WebElement country;
    @FindBy(xpath ="" )
    WebElement postCode;

    @FindBy(xpath ="" )
    WebElement price;

    @FindBy(xpath = "")
    WebElement postButton;


    public void setTitle(String title) {
        title_textbox.sendKeys(title);
    }

    public void selectsCategory(String category) {
        categoriesList.findElement(
                By.linkText(category)).click();
    }

    public void setdescription(String desc) {
        title_textbox.sendKeys(desc);
    }

    public void setKeywords(String key) {
        title_textbox.sendKeys(key);
    }
    public void setAddress(String addr) {
        title_textbox.sendKeys(addr);
    }
    public void setState(String stateInfo) {
        title_textbox.sendKeys(stateInfo);
    }
    public void setCountry(String countryInfo) {
        title_textbox.sendKeys(countryInfo);
    }
    public void setPostal(String postCode) {
        title_textbox.sendKeys(postCode);
    }
    public void setPrice(String price) {
        title_textbox.sendKeys(price);
    }

    public void postInfo() {
        postButton.click();
    }


}
