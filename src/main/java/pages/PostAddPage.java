package pages;

import org.apache.commons.lang.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jingxiapang on 10/1/15.
 */
public class PostAddPage extends PageObject {

    @FindBy(id = "title")
    WebElement title_textbox;

    @FindBy(id = "category" )
    WebElement categoriesList;

    @FindBy(id  ="description" )
    WebElement description;

    @FindBy(id ="keywords" )
    WebElement keywords;

    @FindBy(id ="address" )
    WebElement address;
    @FindBy(id="state" )
    WebElement state;
    @FindBy(id ="country" )
    WebElement country;
    @FindBy(id="zipcode" )
    WebElement postCode;

    @FindBy(id = "price")
    WebElement price;

    @FindBy(id = "submit")
    WebElement postButton;


    public void setTitle(String title) {
        title_textbox.sendKeys(title);
    }

    public void selectsCategory(String category) {
        //categoriesList.findElement(By.linkText(category)).click();

        categoriesList.findElement(By.xpath("//*[@id=\"category\"]/optgroup[1]/option[2]")).click();
    }

    public void setdescription(String desc) {
        description.sendKeys(desc);
    }

    public void setKeywords(String key) {
        keywords.sendKeys(key);
    }
    public void setAddress(String addr) {
        address.sendKeys(addr);
    }
    public void setState(String stateInfo) {
        state.sendKeys(stateInfo);
    }
    public void setCountry(String countryInfo) {
        country.sendKeys(countryInfo);
    }
    public void setPostal(String postalCode) {
        postCode.sendKeys(postalCode);
    }
    public void setPrice(String priceNumber) {
        price.sendKeys(priceNumber);
    }

    public PostAdSuccess postInfo() {
        postButton.click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("refId")));
        return switchTo(PostAdSuccess.class);

    }






}
