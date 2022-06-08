package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayPage {
    public EbayPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "gh-cat")
    public WebElement allCategoriesDropdown;

    @FindBy(id = "gh-btn")
    public WebElement searchButton;

    @FindBy(css = ".title-banner__layer__info>h1")
    public WebElement heading1;

    @FindBy(css = ".title-banner__layer__info>h2")
    public WebElement heading2;

}
