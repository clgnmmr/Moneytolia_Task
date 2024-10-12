package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.*;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AutomationExerciseStepDef {

    private static final Logger log = LoggerFactory.getLogger(AutomationExerciseStepDef.class);
    HomePage homePage = new HomePage();
    ProductsPage productsPage = new ProductsPage();
    ViewPage viewPage = new ViewPage();
    LoginPage loginPage = new LoginPage();
    SignupPage signupPage=new SignupPage();
    Random random = new Random();

    @Given("User navigate to url {string}")
    public void userNavigateToUrl(String url) {
        Driver.getDriver().get(ConfigurationReader.getProperty(url));
    }

    @And("User verify that home page is visible successfully")
    public void userVerifyThatHomePageIsVisibleSuccessfully() {
        Assert.assertEquals(ConfigurationReader.getProperty("mainUrl"), Driver.getDriver().getCurrentUrl());
        Assert.assertTrue(homePage.pageName.isDisplayed());

    }

    @And("User click {string} button on Menu")
    public void userClickButtonOnMenu(String button) {
        ReusableMethods.bringMenuButton(button).click();
    }

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    List<String> priceList = new ArrayList<>();
    List<Integer> quantityList = new ArrayList<>();
    List<String> totalPriceList = new ArrayList<>();
    List<String> productNameList = new ArrayList<>();

    @When("User hover over product and click Add to cart")
    public void userHoverOverProductAndClickAddToCart() {
        int product = random.nextInt(0, productsPage.allAddCardButtons.size());
        js.executeScript("arguments[0].scrollIntoView(true);", productsPage.allAddCardButtons.get(product));
        productsPage.allAddCardButtons.get(product).click();
        priceList.add(productsPage.priceList.get(product).getText());
        productNameList.add(productsPage.productNameList.get(product).getText());
        quantityList.add(1);
        totalPriceList.add(productsPage.priceList.get(product).getText());
        productsPage.allAddCardButtons.remove(productsPage.allAddCardButtons.get(product));

    }

    @And("User click Continue Shopping button")
    public void userClickContinueShoppingButton() {
        productsPage.continueShoppingButton.click();

    }

    @And("User click View Cart button")
    public void userClickViewCartButton() {
        productsPage.viewCartButton.click();
    }

    @Then("User verify their prices, quantity and total price")
    public void userVerifyTheirPricesQuantityAndTotalPrice() {
        System.out.println("productNameList = " + productNameList);
        System.out.println("priceList = " + priceList);
        System.out.println("quantityList = " + quantityList);

        Assert.assertEquals(productNameList.size(), viewPage.productList.size());
        for (int i = 0; i < viewPage.productList.size(); i++) {
            Assert.assertEquals(productNameList.get(i), viewPage.descriptionList.get(i).getText());
            Assert.assertEquals(priceList.get(i), viewPage.priceList.get(i).getText());
            Assert.assertEquals(String.valueOf(quantityList.get(i)), viewPage.quantityList.get(i).getText());
            Assert.assertEquals(totalPriceList.get(i), viewPage.totalPriceList.get(i).getText());

        }
    }

    @Then("User closes the application")
    public void user_closes_the_application() {
        Driver.closeDriver();
    }


    @And("User fill {string} and {string}")
    public void userFillAnd(String email, String password) {
        loginPage.firstEmailInput.sendKeys(ConfigurationReader.getProperty(email));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty(password));
        loginPage.loginButton.click();
    }

    @And("User verify {string} at top")
    public void userVerifyAtTop(String button) {
        Assert.assertTrue(ReusableMethods.bringMenuButton(button).isDisplayed());
        Assert.assertEquals(button.trim() + " " + ConfigurationReader.getProperty("name"), ReusableMethods.bringMenuButton(button).getText());
    }

    @Given("User create new user {string}, {string}, {string}")
    public void userCreateNewUser(String name, String email, String password) {
        loginPage.nameInput.sendKeys(ConfigurationReader.getProperty(name));
        loginPage.secondEmailInput.sendKeys(ConfigurationReader.getProperty(email));
        loginPage.signupButton.click();

        signupPage.passwordInput.sendKeys(ConfigurationReader.getProperty(password));
        signupPage.firstNameInput.sendKeys(ConfigurationReader.getProperty(name));
        signupPage.lastNameInput.sendKeys(ConfigurationReader.getProperty(name));
        signupPage.addressInput.sendKeys(ConfigurationReader.getProperty(name));
        signupPage.stateInput.sendKeys(ConfigurationReader.getProperty(name));
        signupPage.cityInput.sendKeys(ConfigurationReader.getProperty(name));
        signupPage.zipcodeInput.sendKeys("1234564");
        signupPage.mobileInput.sendKeys("+1547868598");
        js.executeScript("arguments[0].scrollIntoView(true);",signupPage.submitButton);
        signupPage.submitButton.click();

    }

    @And("User click Proceed To Checkout")
    public void userClickProceedToCheckout() {
        viewPage.continueProceed.click();
    }

    @Then("User verify Address Details and Review Your Order")
    public void userVerifyAddressDetailsAndReviewYourOrder() {

        for (int i = 1; i < viewPage.billingList.size(); i += 2) {

            Assert.assertEquals(viewPage.billingList.get(i).getText(), viewPage.deliveryList.get(i).getText());

        }


    }

    Faker faker = new Faker();

    @And("User enter description in comment text area and click Place Order")
    public void userEnterDescriptionInCommentTextAreaAndClickPlaceOrder() {

        viewPage.textareaBox.sendKeys(faker.lorem().characters(250));
        viewPage.placeOrderButton.click();
    }

    @And("User enter payment details: {string}, {string}, {string}, {string}, {string}")
    public void userEnterPaymentDetails(String name, String cardNo, String cvc, String month, String year) {
        ReusableMethods.payPageFields(name).sendKeys(ConfigurationReader.getProperty(name));
        ReusableMethods.payPageFields(cardNo).sendKeys(ConfigurationReader.getProperty(cardNo));
        ReusableMethods.payPageFields(cvc).sendKeys(ConfigurationReader.getProperty(cvc));
        ReusableMethods.payPageFields(month).sendKeys(ConfigurationReader.getProperty(month));
        ReusableMethods.payPageFields(year).sendKeys(ConfigurationReader.getProperty(year));
        js.executeScript("arguments[0].scrollIntoView(true);", viewPage.paymentButton);
        viewPage.paymentButton.click();
    }

    WebDriverWait webDriverWait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(25));
    @Then("User verify success message {string}")
    public void userVerifySuccessMessage(String message) {
        webDriverWait.until(ExpectedConditions.stalenessOf(viewPage.paymentButton));
        Assert.assertTrue(viewPage.successMessage.isDisplayed());
        Assert.assertEquals(ConfigurationReader.getProperty(message),viewPage.successMessage.getText());

    }

    @Then("User Verify {string} and click Continue button")
    public void userVerifyAndClickContinueButton(String message) {
        Assert.assertEquals(ConfigurationReader.getProperty(message),signupPage.deleteAccount.getText());
        signupPage.continueButton.click();
    }


}
