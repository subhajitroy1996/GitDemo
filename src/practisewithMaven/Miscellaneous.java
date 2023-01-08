package practisewithMaven;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
public class Miscellaneous {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();//to delete all cookies
//		driver.manage().deleteCookieNamed("sessionKey");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		File s=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//casting driver to TakesScreenshot interface
		FileUtils.copyFileToDirectory(s, new File("D:\\nirmalapandit.jpeg"));
	}

}
