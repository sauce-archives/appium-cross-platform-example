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

        this.driver = new AppiumDriverBuilder()
                .withTestResultWatcher(resultWatcher)
                .build();

        resultWatcher.setAppiumDriver(driver);
        
        System.out.println(this.driver.getCapabilities().getCapability("testobject_test_report_url"));
		System.out.println(this.driver.getCapabilities().getCapability("testobject_test_live_view_url"));


        app = new Komoot(driver);

    }

}
