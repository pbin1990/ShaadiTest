package shadhi.testing;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import shadhi.testing.screens.AppLaunchingScreen;
import shadhi.testing.screens.HomeScreen;
import shadhi.testing.screens.LoginScreen;
import shadhi.testing.screens.MatchesScreen;
import util.Utility;

public class WidgetsCheck {
	
	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	void launchApp() throws IOException {
		
		Utility util = new Utility();
		Properties p = util.loadProperties();
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,org.openqa.selenium.Platform.ANDROID);
		cap.setCapability(MobileCapabilityType.UDID, p.getProperty("UDID"));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, p.getProperty("APP_PACKAGE"));
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, p.getProperty("APP_ACTIVITY"));
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
	}

	@Test
	void loginTest() throws IOException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,org.openqa.selenium.Platform.ANDROID);
		cap.setCapability(MobileCapabilityType.UDID, "ZY2222Q8Q8");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.shaadi.android");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.shaadi.android.ui.main.MainActivity");
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		AppLaunchingScreen launched = new AppLaunchingScreen(driver);
		launched.goToLoginScreen();
		
		LoginScreen login = new LoginScreen(driver);
		login.doLogin();
		
		MatchesScreen matchesScreen = new MatchesScreen(driver);
		matchesScreen.waitTillScreenFullLoad();
		
		HomeScreen home = new HomeScreen(driver);
		home.homeButton.click();
		Thread.sleep(10000);
		home.checkNewMatchesWIdgets();
		home.checkPremiumMatchesWIdgets();
		home.doLogout();
		
	}
	
	@AfterTest
	void quitApp() {
		
		driver.quit();
		
	}

}
