package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by jingxiapang on 10/2/15.
 */
public class PostAdSuccess extends PageObject {
    @FindBy(id="refId")
    private WebElement refId;

    public String getRefId(){
        return refId.getText();

    }



}
