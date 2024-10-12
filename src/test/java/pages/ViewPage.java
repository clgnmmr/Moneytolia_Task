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

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement continueProceed;

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-6'][1]/ul/li")
    public List<WebElement> deliveryList;

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-6'][2]/ul/li")
    public List<WebElement> billingList;

    @FindBy(xpath = "//textarea[@name='message']")
    public WebElement textareaBox;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement paymentButton;

    @FindBy(xpath = "//*[text()='Your order has been placed successfully']")
    public WebElement successMessage;

}
