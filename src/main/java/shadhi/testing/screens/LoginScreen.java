package shadhi.testing.screens;


import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.Utility;

public class LoginScreen {
	
	@AndroidFindBy(id="edt_username")
	MobileElement mobileNumber;
	
	@AndroidFindBy(id="edt_password")
	MobileElement password;
	
	@AndroidFindBy(id="btn_login")
	MobileElement loginButton;
	
	public LoginScreen(AndroidDriver<MobileElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void doLogin() throws IOException {
		
		Utility util = new Utility();
		Properties p = util.loadProperties();
		
		mobileNumber.sendKeys(p.getProperty("mobileNumber"));
		password.sendKeys(p.getProperty("password"));
		loginButton.click();
		
	}
	

}
