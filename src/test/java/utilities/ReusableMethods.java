package utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReusableMethods {


    public static WebElement bringMenuButton(String button){

        return Driver.getDriver().findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li/a[text()='"+button+"']"));
    }


}
