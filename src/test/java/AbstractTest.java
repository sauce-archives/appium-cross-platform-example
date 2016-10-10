import data.Device;
import io.appium.java_client.AppiumDriver;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.testobject.appium.junit.TestObjectTestResultWatcher;
import utility.AppiumDriverBuilder;

public class AbstractTest {

    @Rule
    public TestName testName = new TestName();
    
    @Rule
    public TestObjectTestResultWatcher resultWatcher = new TestObjectTestResultWatcher();

    private AppiumDriver driver;
    protected Komoot app;

    @Before
    public void connect() throws Exception {

        Device device = new Device();
        this.driver = new AppiumDriverBuilder().build(device, resultWatcher);

        resultWatcher.setAppiumDriver(driver);

        app = new Komoot(driver);
    }

}
