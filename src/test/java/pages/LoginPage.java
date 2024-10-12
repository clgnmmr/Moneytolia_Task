package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//input[@name='email'])[1]")
    public WebElement firstEmailInput;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    public WebElement secondEmailInput;

    @FindBy(xpath = "(//input[@name='name'])[1]")
    public WebElement nameInput;

    @FindBy(xpath = "(//input[@name='password'])[1]")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[text()='Signup']")
    public WebElement signupButton;

}
