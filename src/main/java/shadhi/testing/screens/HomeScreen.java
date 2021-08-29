package shadhi.testing.screens;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.Utility;

public class HomeScreen {

	@AndroidFindBy(id = "tvMyShaadi")
	public MobileElement homeButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Account Settings')]")
	MobileElement accountSettingButton;

	@AndroidFindBy(id = "btn_logout")
	MobileElement logoutButton;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Premium Matches')]")
	MobileElement premiumMatchesElement;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'New Matches')]")
	MobileElement newMatchesElement;

	AndroidDriver<MobileElement> driver;

	public HomeScreen(AndroidDriver<MobileElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	public void doLogout() {

		//homeButton.click();
		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		scrollToAccoutSetting();
		accountSettingButton.click();
		scrollToLogout();
		logoutButton.click();

	}

	public void scrollToAccoutSetting() {

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Account Settings\").instance(0))");

	}

	public void scrollToLogout() {

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Logout\").instance(0))");

	}
	
	public void scrollToPremiumMatchesWIdgets() {

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Recently upgraded Premium members\").instance(0))");

	}
	
	public void checkPremiumMatchesWIdgets() throws IOException {
		boolean bExpected = false;
		//homeButton.click();
		scrollToPremiumMatchesWIdgets();
		Utility util = new Utility();
		util.takescreenshot(driver, "PremiumMatches");
		if(premiumMatchesElement.getText().contains("Premium Matches"))
			bExpected = true;
		new SoftAssert().assertEquals(bExpected, true);
	}
	
	public void scrollToNewMatchesWIdgets() {

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"New Matches.*\").instance(0))");

	}
	
	public void checkNewMatchesWIdgets() throws IOException {
		boolean bExpected = false;
		//homeButton.click();
		//scrollToNewMatchesWIdgets();
		Utility util = new Utility();
		util.takescreenshot(driver, "NewMatches");
		if(newMatchesElement.getText().contains("New Matches"))
			bExpected = true;
		new SoftAssert().assertEquals(bExpected, true);
	}

}
