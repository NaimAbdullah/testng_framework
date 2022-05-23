package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_AppleTest extends Base{


    // 2. Validation of test - test
    @Test(priority = 1)
    public void testAppleTitle(){
        driver.get("https://www.apple.com/");

        String expectedTitle = "Apple"; // requirement
        String actualTitle = driver.getTitle(); // development

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 2)
    public void testAppleURL(){
        driver.get("https://www.apple.com/");

        String expectedURL = "https://www.apple.com/";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);
    }

    /*
    @Test(priority = 3)
    public void X(){
        //fail() method is used to fail a test on purpose
        Assert.fail("Failure on purpose");
    }
     */
}
