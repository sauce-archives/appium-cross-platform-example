# Appium Cross Platform Example

This example illustrates how to structure a cross platform Appium test. It makes use of the Page Object design pattern described here: [Page Object Tutorial](https://help.testobject.com/docs/guides/appium-advanced-setup/). The tests also make use of the [TestObject Suite Setup](https://help.testobject.com/docs/tools/appium/setups/junit/suites/) which allows tests to be run in parallel on multiple devices.

### Running the Tests

To run the tests on TestObject, you will need to specify the following environment variables:

- `TESTOBJECT_API_KEY`: The API key for the project that you are testing
- `PLATFORM`: Either Android or iOS

In addition, you also need to update the value for `testObjectSuiteId` in the `@TestObject` annotation of the test class.

To run the tests locally, you will only need to specify the `PLATFORM` environment variable and set `testLocally` to `true` in the `@TestObject` annotation of the test class.