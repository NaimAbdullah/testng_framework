package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _13_Tables extends Base{

    /*
    Go to http://the-internet.herokuapp.com/
    Click on “Sortable Data Tables” link
    Validate the table 1 headers to be displayed as below
    Last Name
    First Name
    Email
    Due
    Web Site
    Action
     */

    @Test(priority = 1, description = "Tables | headers")
    public void testTableHeaders(){
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("Sortable Data Tables");
        Waiter.pause(3);

        String[] expectedHeaderText = {"Last Name", "First Name", "Email", "Due",
                "Web Site", "Action"};

        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(heroAppPage.headers.get(i).getText(), expectedHeaderText[i]);
        }
    }

    /*
    Go to http://the-internet.herokuapp.com/
    Click on “Sortable Data Tables” link
    Validate the table 1 row 1 to be displayed as below
    Smith
    John
    jsmith@gmail.com
    $50.00
    http://www.jsmith.com
    edit delete
     */

    @Test(priority = 2, description = "Tables | Table 1 Row 1")
    public void testRow1(){
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("Sortable Data Tables");
        Waiter.pause(3);

        String[] row1 = {"Smith",
                "John",
                "jsmith@gmail.com",
                "$50.00",
                "http://www.jsmith.com",
                "edit delete"};

        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(heroAppPage.firstRow.get(i).getText(), row1[i]);
        }
    }

    /*
    Go to http://the-internet.herokuapp.com/
    Click on “Sortable Data Tables” link
    Validate the table 1 column 2 (First Name) to be displayed as below
    John
    Frank
    Jason
    Tim
     */

    @Test(priority = 3, description = "Tables | Table 1 First Names")
    public void testTable1FirstNames(){
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("Sortable Data Tables");
        Waiter.pause(3);

        String[] firstNameTexts = {"John",
                "Frank",
                "Jason",
                "Tim"};

        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(heroAppPage.table1FirstNames.get(i).getText(), firstNameTexts[i]);
        }
    }

    /*
    Go to http://the-internet.herokuapp.com/
    Click on “Sortable Data Tables” link
    Validate each cell has value (not empty)
     */

    @Test(priority = 4, description = "Tables | allCells")
    public void testAllCells(){
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("Sortable Data Tables");
        Waiter.pause(3);

        for (WebElement element : heroAppPage.allCells) {
            Assert.assertNotEquals(element.getText(), "");
        }
    }


}
