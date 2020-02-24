package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	public FormPage(AppiumDriver<AndroidElement> driver) 
	{
		
	  PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//driver.findElementById("com.androidsample.generalstore:id/nameField")
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	//driver.findElementById("com.androidsample.generalstore:id/radioFemale")
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	public WebElement femaleOption;
	
	//driver.findElementById("android:id/text1")
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;



    public WebElement getNameField() 
    {
    	//if you want to print this before nameField call so use this way or if you want some log
       System.out.println("trying to find name field");
    	return nameField;
    }
  
    public WebElement getcountrySelection() 
    {
    	//if you want to print this before nameField call so use this way or if you want some log
       System.out.println("Select country from dropdown");
    	return countrySelection;
    }


	
}