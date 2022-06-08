package scripts;

import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DropdownHandler;
import utilities.Waiter;

public class _07_DropdownTest extends Base{

    /*
    Go to https://www.facebook.com/
    Click on "Create New Account" link
    Enter below information and click on Sign Up button
    First name = John
    Last Name = Doe
    Email address = johndoe55555@gmail.com
    Password = abcd1234
    Birthday = April 1, 1990
    Gender = Male
    Validate below error message is displayed with expected text
    Please choose a more secure password. It should be longer than 6 characters, unique to you, and difficult for others to guess.
     */

    @Test(priority = 1, description = "TC763: Validate Facebook sign in error message for password")
    public void testUnsecurePasswordErrorMessage(){
        driver.get("https://www.facebook.com/");

        facebookPage.createNewAccountLink.click();

        facebookPage.firstNameInputBox.sendKeys("John");
        facebookPage.lastNameInputBox.sendKeys("Doe");
        facebookPage.emailOrPhoneInputBox.sendKeys("johndoe55555@gmail.com");
        facebookPage.emailReEnterInputBox.sendKeys("johndoe55555@gmail.com");
        facebookPage.passwordInputBox.sendKeys("abcd1234");

        // To be able to select an option from dropdown we need an instance of Select class
        //Select monthSelector = new Select(facebookPage.monthDropdown);
        //monthSelector.selectByValue("4"); // Selection by value
        //monthSelector.selectByVisibleText("Apr"); // Selection by visible text
        //monthSelector.selectByIndex(3); // Selection by index

        DropdownHandler.selectOptionByIndex(facebookPage.monthDropdown, 3);

        // Select day as 1
        //Select daySelector = new Select(facebookPage.dayDropdown);
        //daySelector.selectByValue("1");
        DropdownHandler.selectOptionByVisibleText(facebookPage.dayDropdown, "1");

        // Select year as 1990
        //Select yearSelector = new Select(facebookPage.yearDropdown);
        //yearSelector.selectByValue("1990");
        DropdownHandler.selectOptionByValue(facebookPage.yearDropdown, "1990");

        facebookPage.genderRadioButtons.get(1).click();
        facebookPage.signUpButton.click();

        String expectedMessage = "Please choose a more secure password. It should be longer than 6 characters, unique to you, and difficult for others to guess.";

        Waiter.waitUntilTextToBePresentInElement(driver, 60, facebookPage.errorMessage, expectedMessage);
        Assert.assertEquals(facebookPage.errorMessage.getText(), expectedMessage, "Error message has issues");
    }


    @Test(priority = 2, description = "TC578: Validate Expedia dropdowns")
    public void testExpediaDropdowns(){
        driver.get("https://www.expedia.com/");

        expediaPage.moreTravelDropdown.click();
        expediaPage.flights.click();

//        Waiter.pause(60);
        expediaPage.flightTypesDropdown.click();
        expediaPage.flightOptions.get(1).click();
        Assert.assertEquals(expediaPage.flightTypesDropdown.getText(), "Premium economy");
    }

    /*
    1. Go to https://www.ebay.com/
    2. Select “Art” from “All Categories” dropdown
    3. Click on “Search” button
    4. Validate “Welcome to eBay Art” heading1
    5. Validate “Find Prints, Paintings, Posters, and More.” heading2

    NOTE: Validation includes headings to be displayed and texts to be exactly matching above texts
     */

    @Test(priority = 3, description = "TC242: Validate Ebay dropdown")
    public void testEbayDropdown(){
        driver.get("https://www.ebay.com/");

        DropdownHandler.selectOptionByValue(ebayPage.allCategoriesDropdown, "550");
        ebayPage.searchButton.click();
        Assert.assertEquals(ebayPage.heading1.getText(), "Welcome to eBay Art");
        Assert.assertEquals(ebayPage.heading2.getText(), "Find Prints, Paintings, Posters, and More.");

    }
}
