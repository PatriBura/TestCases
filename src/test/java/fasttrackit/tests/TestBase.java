package fasttrackit.tests;

import fasttrackit.DriverFactory;
import org.junit.After;
import org.junit.Before;

public class TestBase {
    @Before
    public void setup() {
        DriverFactory.initDriver();

        DriverFactory.getDriver().get("https://fasttrackit.org/selenium-test");

    }

    @After
    public void tearDown() {
        DriverFactory.getDriver().quit();
    }
}
