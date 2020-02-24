package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	//1. Is to call the driver object from test cases to pageobject file(This we have achived through constructor)
	
	//2.How can we concatinate driver with findbyXpath string(This achived through pageFactory concept)
	
	public HomePage(AppiumDriver<AndroidElement> driver) 
	{
		
	  PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	  
	  //AppiumFieldDecorator is use only for appium(android and ios compatibility) no need for selenium
	  //once your above code is execute so It will automatically read all below xpath code and concatenate with driver
	  //here driver initialize below elements(xpath code) and this keyword refer own page(current page).
	  //If you want to refer another page you have to pass that class instead of this keyword.
	  //eg. If you refer Preferences so you have to pass Preference
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement Preferences;

	
	//below code is represent by above code for pageObject 
	//findElementByXpath("//android.widget.TextView[@text='Preference']");
}
