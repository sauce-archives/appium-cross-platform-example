package utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testobject.appium.junit.TestObjectTestResultWatcher;

public class AppiumDriverBuilder {
    private TestObjectTestResultWatcher resultWatcher;

    public AppiumDriverBuilder withTestResultWatcher(TestObjectTestResultWatcher resultWatcher) {
        this.resultWatcher = resultWatcher;
        return this;
    }

    public AppiumDriver build() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("testobject_api_key", resultWatcher.getApiKey());
        capabilities.setCapability("testobject_test_report_id", resultWatcher.getTestReportId());

        capabilities.setCapability("deviceName", "testDevice");

        String platform = System.getenv("PLATFORM");

        if (platform.equalsIgnoreCase("ios")) {
            return new IOSDriver(resultWatcher.getTestObjectOrLocalAppiumEndpointURL(), capabilities);
        } else if (platform.equalsIgnoreCase("android")) {
            return new AndroidDriver(resultWatcher.getTestObjectOrLocalAppiumEndpointURL(), capabilities);
        } else {
            throw new Exception("Unable to read device platform.");
        }
    }
}
