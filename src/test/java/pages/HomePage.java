package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='shop-menu pull-right']/ul/li/a[text()=' Home']")
    public WebElement homePage;

    @FindBy(xpath = "//div[@class='logo pull-left']")
    public WebElement pageName;

}
