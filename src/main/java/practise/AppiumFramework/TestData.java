package practise.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="InputData")
	public Object[][] getDataforEditField()
	{
		//2 sets of data
		Object[][] obj=new Object[][]
				{
			{"hello"},{"@hadhh2397327"}
				};
				
				return obj;
	}
	
	

}
