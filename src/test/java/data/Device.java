package data;

import org.testobject.api.TestObjectClient;
import org.testobject.rest.api.model.DeviceDescriptor;

import java.util.List;

public class Device {

    public DeviceDescriptor.OS platform;
    public String deviceId;

    public void initWithCloudDeviceInformation(String watcherDeviceId) {

        deviceId = watcherDeviceId;

        // Establish a connection with TestObject using your username and password.
        TestObjectClient client = TestObjectClient.Factory.create();
        client.login(System.getenv("TESTOBJECT_USERNAME"), System.getenv("TESTOBJECT_PASSWORD"));

        // Get the device descriptor list from TestObject.
        List<DeviceDescriptor> descriptorList = client.listDevices();

        // Find the device descriptor corresponding to our chosen device and get its platform.
        for (DeviceDescriptor descriptor : descriptorList) {
            if (descriptor.id.equals(watcherDeviceId)) {
                this.platform = descriptor.os;
            }
        }
    }
}