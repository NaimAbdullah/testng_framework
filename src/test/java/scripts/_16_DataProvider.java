package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _16_DataProvider extends Base{

    @Test(priority = 1, dataProvider = "searchKeys")
    public void testGoogleSearch(String key) {
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys(key + Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains(key));
    }

    @Test(priority = 2, dataProvider = "getCredentials")
    public void testLogin(String username, String password){
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("Form Authentication");

        heroAppPage.username.sendKeys(username);
        heroAppPage.password.sendKeys(password);
        heroAppPage.loginButton.click();
    }

    @DataProvider()
    public Object[][] getCredentials(){
        return new Object[][]{{"johndoe", "123"}, {"alexsmith", "1234"}, {"tomsmith", "12345"}};
    }


    @DataProvider()
    public Object[] searchKeys(){
        return new Object[]{"Apple", "Orange", "Cucumber", "Gherkin", "Eggplant"};
    }

}
