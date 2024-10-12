package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.HomePage;
import pages.ProductsPage;
import pages.ViewPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AutomationExerciseStepDef {

    HomePage homePage = new HomePage();
    ProductsPage productsPage = new ProductsPage();
    ViewPage viewPage=new ViewPage();
    Random random=new Random();

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

    List<String> priceList=new ArrayList<>();
    List<Integer> quantityList =new ArrayList<>();
    List<String> totalPriceList=new ArrayList<>();
    List<String> productNameList=new ArrayList<>();

    @When("User hover over product and click Add to cart")
    public void userHoverOverProductAndClickAddToCart() {
        int product=random.nextInt(0,productsPage.allAddCardButtons.size());
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

        Assert.assertEquals(productNameList.size(),viewPage.productList.size());
        for (int i = 0; i < viewPage.productList.size(); i++) {
            Assert.assertEquals(productNameList.get(i),viewPage.descriptionList.get(i).getText());
            Assert.assertEquals(priceList.get(i),viewPage.priceList.get(i).getText());
            Assert.assertEquals(String.valueOf(quantityList.get(i)),viewPage.quantityList.get(i).getText());
            Assert.assertEquals(totalPriceList.get(i),viewPage.totalPriceList.get(i).getText());

        }
    }

    @Then("User closes the application")
    public void user_closes_the_application() {
        Driver.closeDriver();
    }



}
