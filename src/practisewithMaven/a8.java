package practisewithMaven;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class a8 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert a=new SoftAssert();
		for(int i=0;i<driver.findElements(By.cssSelector("div#gf-BIG a")).size();i++)
		{String url=driver.findElements(By.cssSelector("div#gf-BIG a")).get(i).getAttribute("href");
		HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		int code=conn.getResponseCode();
		a.assertTrue(code<400,"Broken link:"+driver.findElements(By.cssSelector("div#gf-BIG a")).get(i).getAttribute("href"));
		}
		a.assertAll();
		
	}

}
