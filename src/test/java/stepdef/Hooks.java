package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeTest() {
        if (BaseTest.driver == null) {
            BaseTest.setupDriver();
        } else {
            BaseTest.driver.manage().deleteAllCookies();
        }
    }

    @After
    public void afterTest() {

        if (BaseTest.driver != null) {
            BaseTest.driver.quit();
            BaseTest.driver = null;
        }
    }
}
