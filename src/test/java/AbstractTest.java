import io.appium.java_client.AppiumDriver;
import org.junit.Before;
import org.junit.Rule;
import org.testobject.appium.junit.TestObjectTestResultWatcher;
import utility.AppiumDriverBuilder;

public class AbstractTest {

    @Rule
    public TestObjectTestResultWatcher resultWatcher = new TestObjectTestResultWatcher();

    private AppiumDriver driver;
    protected Komoot app;

    @Before
    public void connect() throws Exception {
        this.driver = new AppiumDriverBuilder()
                .withTestResultWatcher(resultWatcher)
                .build();

        resultWatcher.setAppiumDriver(driver);

        app = new Komoot(driver);
    }

}
