import data.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testobject.appium.junit.TestObjectAppiumSuite;
import org.testobject.rest.api.appium.common.TestObject;

import static org.junit.Assert.*;

@RunWith(TestObjectAppiumSuite.class)
@TestObject(testLocally = false, testObjectSuiteId = 7)
public class SignUpTest extends AbstractTest {

    @Test
    public void signUpTest() {
        app.landingScreen().selectSignUp();
        app.signUpScreen().signUpUser(User.VALID_USER);
        assertTrue(app.welcomeScreen().welcomeMessagePresent(User.VALID_USER));
    }
}
