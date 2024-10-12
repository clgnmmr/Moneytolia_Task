package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
    public static String apiTest;

    @After
    public void tearDown(Scenario scenario) throws Exception {
        if (apiTest.equals("OFF")) {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshots");
                Driver.closeDriver();
            }
        }
    }

}
