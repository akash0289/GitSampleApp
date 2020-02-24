package practise.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	//for appium server start
	public AppiumDriverLocalService startServer() 
	{
		boolean flag=checkIfServerIsRunning(4723);
		if(!flag) {
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port) {
		
		boolean isServerRunning=false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		}catch(IOException e){
			//If Control comes here, then it means that the port is in use
			isServerRunning=true;
		}finally {
			serverSocket=null;
		}
		return isServerRunning;
	}
	
	public static void startEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("C:\\Users\\MV\\eclipse-workspace\\AppiumFramework\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}
	
public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
	//by this method we can get file path
	//System.getProperty("user.dir")
	
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\practise\\AppiumFramework\\global.properties");
	Properties prop=new Properties();
	//load properties file
	prop.load(fis);
	//Print or get key
	
	
	
		File f=new File("src");
		File fs= new File(f,(String) prop.get(appName));
		
		DesiredCapabilities cap = new DesiredCapabilities();
		String device=(String) prop.get("device");
		//String device=System.getProperty("deviceName");
		if(device.contains("emulator"))
		{
			startEmulator();
		}
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE_DIR, "C:\\Users\\MV\\Downloads\\chromedriver_win32 (1)");
		
		
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         return driver;
	}
     
    public static void getScreenshot(String s) throws IOException
    {
    	
    	File scrfile=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	//1.>FileUtils.copyFile(scrfile,new File("C:\\Users\\MV\\Screenshots\\defectScreen.png"));
    	//2.>FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\defectScreen.png"));
    	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
    	
    
     }
}
