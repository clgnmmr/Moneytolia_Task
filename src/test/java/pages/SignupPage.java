package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignupPage {
    public SignupPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@name='first_name']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='last_name']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='address1']")
    public WebElement addressInput;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement stateInput;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement cityInput;

    @FindBy(xpath = "//input[@name='zipcode']")
    public WebElement zipcodeInput;

    @FindBy(xpath = "//input[@name='mobile_number']")
    public WebElement mobileInput;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement submitButton;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement deleteAccount;

    @FindBy(xpath = "//a[text()='Continue']")
    public WebElement continueButton;

}
