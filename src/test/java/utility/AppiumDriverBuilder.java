package utility;

import data.Device;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testobject.appium.junit.TestObjectTestResultWatcher;
import org.testobject.rest.api.model.DeviceDescriptor;

public class AppiumDriverBuilder {

    private DesiredCapabilities capabilities;
    private Device device;
    private TestObjectTestResultWatcher resultWatcher;

    public AppiumDriver build(Device testDevice, TestObjectTestResultWatcher watcher) throws Exception {

        capabilities = new DesiredCapabilities();
        device = testDevice;
        resultWatcher = watcher;

        // TestObject's basic mandatory capabilities for a JUnit suite setup.
        capabilities.setCapability("testobject_api_key", resultWatcher.getApiKey());
        capabilities.setCapability("testobject_test_report_id", resultWatcher.getTestReportId());

        // Configure for the cloud.
        device.initWithCloudDeviceInformation(resultWatcher.getTestDeviceId());

        // Provide needed platform version-specific capabilities and instantiate platform-specific AppiumDriver.
        if (device.platform.equals(DeviceDescriptor.OS.IOS)) {
            return new IOSDriver(resultWatcher.getTestObjectOrLocalAppiumEndpointURL(), capabilities);
        } else if (device.platform.equals(DeviceDescriptor.OS.ANDROID)) {
            return new AndroidDriver(resultWatcher.getTestObjectOrLocalAppiumEndpointURL(), capabilities);
        } else {
            throw new Exception("Was unable to read device platform.");
        }
    }

}
