package practise.AppiumFramework;



import java.io.IOException;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import pageObject.CheckOutPage;
import pageObject.FormPage;


public class EcommerceTest4 extends Base {
	
	
	@Test
	public void totalValidation() throws IOException, InterruptedException {
		
		//for start appium server
		service=startServer();
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
		FormPage formPage=new FormPage(driver);
		//formPage.nameField.sendKeys("Hello");
		//another way to call variables if you want to print or perform another things before call this variables
		formPage.getNameField().sendKeys("hello");
		
		driver.hideKeyboard();
		//driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		
		formPage.femaleOption.click();
		
		//click dropdown button/scroll till value//click on value
		//driver.findElementById("android:id/text1").click();
		
		//formPage.countrySelection.click();
		formPage.getcountrySelection().click();
		                                                                                                                                                          //PutAnyTextHere
		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText +"\").instance(0))"));
		//use below code instead of this>driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));");
		Utilities u=new Utilities(driver);
		u.scrollToText("Aruba");
		
		
		driver.findElementByXPath("//*[@text='Aruba']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(4000);
		
		int count=driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		double sum=0;
		
		CheckOutPage checkOutPage=new CheckOutPage(driver);
		
		
		for(int i=0;i<count;i++) {
			//String amount1=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
			String amount1=checkOutPage.productList.get(i).getText();
			double amount=getAmount(amount1);
			sum=sum+amount;
		}
		
		//1st time amount is eg. 1 so sum is 1  ,when i=0;
		//2nd time amount is 2 so sum is 3      ,when i=1;
		//3rd time amount is 4 so sum is 7      ,when i=2;  we are getting all products value i.e. added in cart.
		
		
		System.out.println(sum+"sum of products");
		
		//String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		
		String total=checkOutPage.totalAmount.getText();
		
		total = total.substring(1);
		
		double totalValue=Double.parseDouble(total);
		
		System.out.println(totalValue+"total value of products");
		
		//Assert.assertEquals(sum, totalValue);
		
		service.stop();
		

	}
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
		//taskkill /F /IM node.exe
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(4000);
	}
	
	public static double getAmount(String value) {
		
		value=value.substring(1);
		double amount2value=Double.parseDouble(value);
		return amount2value;
		
	}


}

