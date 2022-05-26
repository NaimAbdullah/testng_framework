package scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_GoogleTest extends Base{

    /*
    TC765: Validate Google search
    1. Go to "https://www.google.com/"
    2. Search for "Selenium"
    3. Validate the results are more than zero
     */

    @Test(priority = 1, description = "TC765: Validate Google search")
    public void testGoogleSearchResults(){
        driver.get("https://www.google.com/");

        googleSearchPage.searchInputBox.sendKeys("Apple" + Keys.ENTER);

        String results = googleSearchResultPage.results.getText();

        Assert.assertTrue(Long.parseLong(results.substring(results.indexOf(" "), results.indexOf("results")-1).replaceAll("[^0-9]", "")) > 0);

    }
}
