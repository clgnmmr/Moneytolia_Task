package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ProductsPage {
    public ProductsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(className = "col-sm-4")
    public List<WebElement> allProducts;

    @FindBy(xpath = "//div[@class='productinfo text-center']/a[text()='Add to cart']")
    public List<WebElement> allAddCardButtons;

    @FindBy(xpath = "//div[@class='productinfo text-center']//h2")
    public List<WebElement> priceList;

    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    public List<WebElement> productNameList;

    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//p[@class='text-center']/a")
    public WebElement viewCartButton;

}
