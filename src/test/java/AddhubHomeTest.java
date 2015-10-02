import org.junit.Test;
import pages.AddhubHome;
import pages.PostAddPage;

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
        postAddPage.setTitle("Hot Water Bottle");
        postAddPage.postInfo();
        System.out.println(home.getTitle());
    }
}