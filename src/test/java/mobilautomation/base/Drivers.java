package mobilautomation.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.MobilePlatform;
import mobilautomation.utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public enum Drivers {
    ANDROID {
        @Override
        public AppiumDriver browserConfigureOptions() {
            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options
                        .setPlatformName("Android")
                        .setAppPackage(ConfigReader.getProperty("appPackage"))
                        .setAppActivity(ConfigReader.getProperty("appActivity"))
                        .setUdid(ConfigReader.getProperty("androidDeviceId"))
                        .setNoReset(false)
                        .setNewCommandTimeout(Duration.ofSeconds(30000))
                        .eventTimings()
                        .setCapability("disableWindowAnimation", true);
                options.setCapability("autoGrantPermissions", true);
                options.setCapability("unicodeKeyboard", false);
                options.setCapability("resetKeyboard", false);
                options.setCapability("language", "tr");
                options.setCapability("locale", "TR");

                AndroidDriver driver = new AndroidDriver(new URL(ConfigReader.getProperty("localURL")), options);
                driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 5);
                return driver;
            } catch (MalformedURLException e) {
                throw new RuntimeException("Driver cannot Set", e);
            }
        }
    },

    IOS {
        @Override
        public AppiumDriver browserConfigureOptions() {
            try {
                XCUITestOptions options = new XCUITestOptions();
                options.includeSafariInWebviews();
                options.connectHardwareKeyboard();
                options.setPlatformName(MobilePlatform.IOS);
                options.setAutomationName("XCUITest");
                options.setDeviceName("iPhone");
                options.setBundleId(ConfigReader.getProperty("ios.bundleId"));
                options.setUdid(ConfigReader.getProperty("ios.udid"));
                options.setNoReset(false);
                options.setPlatformVersion(ConfigReader.getProperty("ios.platformVersion"));
                options.setCommandTimeouts(Duration.ofMinutes(3));
                options.setNewCommandTimeout(Duration.ofMinutes(3));
                options.setCapability("shouldTerminateApp", true);
                options.setCapability("setNotificationListener", true);
                options.setUseNewWDA(false);
                options.setUsePrebuiltWda(true);

                IOSDriver driver = new IOSDriver(new URL(ConfigReader.getProperty("localURL")), options);
                driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 5);
                return driver;
            } catch (MalformedURLException e) {
                throw new RuntimeException("Driver cannot Set", e);
            }
        }
    };

    public abstract AppiumDriver browserConfigureOptions();
}
