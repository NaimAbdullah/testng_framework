package scripts;

import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _11_FileUpload extends Base{

    /*
    Create a text file in your project called “myFileNaim.txt”
    Go to http://the-internet.herokuapp.com/
    Click on “File Upload” link
    Choose created file to be uploaded to the page
    Click on “Upload” button
    Validate “File Uploaded!” heading3 text
    Validate ”myFileNaim.txt” in the uploaded file list
     */

    @Test(priority = 1, description = "File Upload")
    public void testFileUpload1(){
        driver.get("http://the-internet.herokuapp.com/");
        Waiter.pause(2);
        heroAppPage.clickOnLink("File Upload");
        Waiter.pause(2);
        heroAppPage.chooseFileInput.sendKeys("/Users/naim/IdeaProjects/testng_framework/myFileNaim2.xls");
        Waiter.pause(2);
        heroAppPage.uploadFileButton.click();

        Assert.assertEquals(heroAppPage.fileUploadedH3.getText(), "File Uploaded!");
        Assert.assertEquals(heroAppPage.uploadedFileText.getText(), "myFileNaim2.xls");
    }

    /*
    Go to http://the-internet.herokuapp.com/
    Click on “File Download” link
    Click on “myFileNaim2.xls” link
    Validate “myFileNaim2.xls” file is downloaded in your “Downloads” folder
     */

    @Test(priority = 2, description = "File Download")
    public void testFileDownload(){
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("File Download");
        Waiter.pause(3);

        heroAppPage.downloadFileLink.click();

    }

}










