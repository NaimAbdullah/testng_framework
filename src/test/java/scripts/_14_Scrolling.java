package scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _14_Scrolling extends Base{

    @Test
    public void testScrolling(){
        driver.get("https://www.techglobalschool.com/");
        Waiter.pause(3);

//        actions.moveToElement(tgHomePage.registerForIntroButton).perform();
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Waiter.pause(3);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", tgHomePage.faceBookIcon);
        Waiter.pause(10);
    }
}
