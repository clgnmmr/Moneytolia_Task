package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ViewPage {
    public ViewPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//tr[contains(@id, 'product')]")
    public List<WebElement> productList;

    @FindBy(xpath = "//h4/a")
    public List<WebElement> descriptionList;

    @FindBy(xpath = "//td[3]/p")
    public List<WebElement> priceList;

    @FindBy(xpath = "//td[5]/p")
    public List<WebElement> totalPriceList;

    @FindBy(xpath = "//td/button")
    public List<WebElement> quantityList;
}
