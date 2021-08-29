package shadhi.testing.screens;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MatchesScreen {

	@AndroidFindBy(id = "tvMatches")
	MobileElement matchesButton;

	@AndroidFindBy(id = "btn_send_message")
	MobileElement connectNowButton;
	
	AndroidDriver<MobileElement> driver;

	public MatchesScreen(AndroidDriver<MobileElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver= driver;
	}
	
	public void waitTillScreenFullLoad() {
		
		MatchesScreen matchesScreen = new MatchesScreen(driver);
		new WebDriverWait(driver, 120, 500)
		.ignoring(Exception.class)
		.until(ExpectedConditions.elementToBeClickable(matchesScreen.connectNowButton));
		
	}

}
