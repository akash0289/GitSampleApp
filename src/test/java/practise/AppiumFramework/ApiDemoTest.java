package practise.AppiumFramework;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObject.HomePage;
import pageObject.Preferences;

public class ApiDemoTest extends Base {

	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void apiDemo(String input) throws IOException, InterruptedException {
		
		//for appium server start
		
		service=startServer();
		
		
		AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Xpath syntax:-
		
		/*  //tagName[@attribute='value']

		 
		 * 
		 */
		
		HomePage h=new HomePage(driver);
		//constructor of class will be invoked when you create object of the class
		
		//if you not create constructor so default constructor will be called
		
		//constructor can be defined with arguments
		
		//1.Create in Home Page> driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		//You can call the methods or variables of the class with the class object
		h.Preferences.click();
		
		
		Preferences p=new Preferences(driver);
		//2.Create in Preference Page> driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		
		p.Dependencies.click();
		
		
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys(input);
		//driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		p.buttons.get(1).click();
		
		service.stop();
		
	}

}
