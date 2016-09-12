import data.User;
import org.junit.Test;
import org.testobject.appium.common.TestObject;

import static org.junit.Assert.*;

@TestObject(testLocally = true)
public class SignUpTest extends AbstractTest {

    @Test
    public void signUpTest() {
        app.landingScreen().selectSignUp();
        app.signUpScreen().signUpUser(User.VALID_USER);
        assertTrue(app.welcomeScreen().welcomeMessagePresent(User.VALID_USER));
    }
}
