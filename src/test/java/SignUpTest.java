import data.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testobject.appium.junit.TestObjectAppiumSuite;
import org.testobject.rest.api.appium.common.TestObject;

import static org.junit.Assert.assertTrue;

@RunWith(TestObjectAppiumSuite.class)
@TestObject(testLocally = false, testObjectSuiteId = 7)
public class SignUpTest extends AbstractTest {

    @Test
    public void signUpWithInvalidEmailTest() {
        app.landingScreen().selectSignUp();
        app.signUpScreen().signUpUser(User.INVALID_EMAIL_USER);

        assertTrue(app.signUpScreen().wrongEmailAlertPresent());
    }

    @Test
    public void signUpWithInvalidPasswordTest() {
        app.landingScreen().selectSignUp();
        app.signUpScreen().signUpUser(User.INVALID_PASSWORD_USER);

        assertTrue(app.signUpScreen().wrongPasswordAlertPresent());
    }
}
