import org.apache.bcel.generic.Select;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.AddhubHome;
import pages.PostAdSuccess;
import pages.PostAddPage;
import sun.font.TrueTypeFont;

import static org.junit.Assert.*;

/**
 * Created by sasinda on 10/1/15.
 * Modified by Jacqueline on 10/1/15.
 */
public class AddhubHomeTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
    public void openAddhub(){
        AddhubHome home=new AddhubHome();
        home.open();
        PostAddPage postAddPage = home.navigateToPostAddPage();
        postAddPage.setTitle("Mini Cooper");
        postAddPage.setAddress("8th Ave, Manhatten");
        postAddPage.setKeywords("BMW");
        postAddPage.setCountry("US");
        postAddPage.setdescription("Brand new Mini Cooper");
        postAddPage.selectsCategory("Cars");
        postAddPage.setPostal("10011");
        postAddPage.setState("NY");
        postAddPage.setPrice("5000");

        PostAdSuccess postAdSuccess = postAddPage.postInfo();

        System.out.println(home.getTitle());
//        home.closeBrowser();
        assertNotNull(postAdSuccess.getRefId());
        System.out.println(postAdSuccess.getRefId());


    }
}