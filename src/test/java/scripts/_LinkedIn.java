package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class _LinkedIn extends Base{

    @Test
    public void linkedIn() throws InterruptedException {

        Credentials credentials = new Credentials();

        driver.get("https://www.linkedin.com/home");

        credentials.setUsername("Naim");
        credentials.setPassword("123");

        WebElement usernameBox = driver.findElement(By.id("session_key"));
        usernameBox.sendKeys(credentials.getUsername());

        WebElement passwordBox = driver.findElement(By.id("session_password"));
        passwordBox.sendKeys(credentials.getPassword());

        WebElement signinButton = driver.findElement(By.cssSelector(".sign-in-form__submit-button"));
        signinButton.click();

        WebElement searchBox = driver.findElement(By.xpath("//div[@id='global-nav-typeahead']/input"));
        searchBox.sendKeys("Taylor " + Keys.ENTER);

        WebElement seeMore = driver.findElement(By.xpath("//a[text()='See all people results']"));
        seeMore.click();

        // List of all the "Connect" buttons and Text on the page
        List<WebElement> allButtons = driver.findElements(By.xpath("//li[@class='reusable-search__result-container ']//button"));
        List<WebElement> connectText = driver.findElements(By.xpath("//li[@class='reusable-search__result-container ']//button/span"));
        WebElement t;
        WebElement b;

        int cycles = 0;
        for (int i = 0; i < allButtons.size(); i++) {
            t = connectText.get(i);
            b = allButtons.get(i);
            if(t.getText().equals("Connect")) b.click();
            cycles++;
            if(cycles % 5 == 0) Thread.sleep(4000);
        }

        Thread.sleep(5000);
    }
}
