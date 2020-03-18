package practise.AppiumFramework;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities 
{
	  AndroidDriver<AndroidElement> driver;
	public Utilities(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
	}
	
	public void scrollToText(String text)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
	
	//scroll whole page
/* MobileElement el = (MobileElement) driver
					    .findElementByAndroidUIAutomator("new UiScrollable("
					        + "new UiSelector().scrollable(true)).scrollIntoView("                      
					        + "new UiSelector().textContains(\"Country of Play School\"));");
			 // el.click();
			
			 //scroll when resourceId is known 
			   MobileElement elementToClick = (MobileElement) driver
					    .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
					        + ".resourceId(\"android:id/content\")).scrollIntoView("
					        + "new UiSelector().text(\"textName\"));");
					//elementToClick.click();*/
}
