package PragatiTraining.AutomationFrameworkAPI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import PragatiTraining.AutomationFrameworkAPI.Utilities.Utils;

public class WebTest {
	
	public HashMap<String,WebElement>ObjectRepo=new HashMap<String,WebElement>();
	RemoteWebDriver D;
	public void StartTest(String BrowserName) {
		
		StartBrowser(BrowserName);
		OpenURL();
	}
	public void CreateObjectRepository(String ObjectRepositoryFileName) {
		
		String ObjectRepositoryFilePath=Utils.EnvWars.get("C:\\PragatiSoftwareTesting\\link\\EnvWars.csv")+"\\"+ObjectRepositoryFileName+"EnvWars.csv";
	try {
		FileReader FR=new FileReader(ObjectRepositoryFilePath);
		BufferedReader BR=new BufferedReader(FR);
		String Line=BR.readLine();
		while(Line!=null) {
			String []pieces=Line.split(",");
			String LogicalName=pieces[0];
			//ObjectRepo.put(LogicalName, E);
		}
		
	    }
	catch(FileNotFoundException ex) {
		System.out.println("Plz check if file at location"+ObjectRepositoryFileName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Problem in reading file exists at location :"+ObjectRepositoryFileName);
	}
	
	}
	public void StartBrowser(String BrowserName) {
		
		switch(BrowserName) 
		{
		     case "CHROME" :
		    	 //Start chromeDriver
		    	 System.setProperty("webdriver.chrome.driver",Utils.EnvWars.get("DRIVERS_PATH")+Utils.EnvWars.get("CHROMEDRIVER"));
		         D=new ChromeDriver();
		    	 break;
		     case "FIREFOX" :	
		    	 //Start Firefox Driver
		    	 D=new FirefoxDriver();
		    	       
		         
		}
	}
	
	public void OpenURL() {
		
		D.get(Utils.EnvWars.get("APPLICATION_URL"));
		
	}
	public void EnterText(WebElement E,String ValueToType) {
		E.clear();
		E.sendKeys(ValueToType);
	}
	
	public void AppendText()
	{
		System.out.println("Hello !!");
		}
	public void ClickElement(WebElement E)
	{
		E.click();
	}

}
