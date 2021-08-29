package shadhi.testing.screens;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppLaunchingScreen {

	@AndroidFindBy(id = "btn_morph_login")
	MobileElement loginButton;
	
	AndroidDriver<MobileElement> driver;

	public AppLaunchingScreen(AndroidDriver<MobileElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	public void goToLoginScreen() {

		loginButton.click();
		waitTillScreenFullLoad();

	}

	public void waitTillScreenFullLoad() {

		LoginScreen login = new LoginScreen(driver);
		new WebDriverWait(driver, 120, 500).ignoring(Exception.class)
				.until(ExpectedConditions.elementToBeClickable(login.mobileNumber));

	}

}
