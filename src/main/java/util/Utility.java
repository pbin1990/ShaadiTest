package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Utility {
	
	//String dir = "D:\\Screenshot";
	
	public void takescreenshot(AndroidDriver<MobileElement> driver, String fileName) throws IOException {
		
		Utility util = new Utility();
		Properties p = util.loadProperties();
		
		String dir = p.getProperty("Screenshot_Path");
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		dir = dir + "\\" + date.getYear() + "\\" + date.getMonth() + "\\" + date.getDay();
		File dest = new File("dir");
		if(!dest.exists())
			dest.mkdir();
		
		FileUtils.copyFile(src, new File(dir + "\\" + fileName + ".jpg"));
		
	}
	
	public Properties loadProperties() throws IOException {
		
		FileReader reader=new FileReader("config.properties");  
	      
	    Properties p=new Properties();  
	    p.load(reader);  
	    
	    return p;
		
	}

}
