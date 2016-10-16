package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AbstractScreen {

    protected final AppiumDriver driver;

    public AbstractScreen(AppiumDriver driver) {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);

    }

    public void hideKeyboard() {

        if (isAndroid()) {
            driver.hideKeyboard();
        } else {
            IOSDriver iosDriver = (IOSDriver) driver;
            iosDriver.hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");
        }

    }

    public boolean isAndroid() {
        return driver instanceof AndroidDriver;
    }

    public boolean isIOS() {
        return driver instanceof IOSDriver;
    }

    public void takeScreenshot() {
        driver.getScreenshotAs(OutputType.BASE64);
    }

    public MobileElement findElementWithTimeOut(By by, int timeOutInSeconds) {
        return (MobileElement) (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public String getAlertTitle() {

        if (isIOS()) {
            return findElementWithTimeOut(By.xpath("//UIAAlert/UIAScrollView/UIAStaticText[1]"), 10).getText();
        } else {
            return findElementWithTimeOut(By.id("android:id/alertTitle"), 10).getText();
        }

    }
}
