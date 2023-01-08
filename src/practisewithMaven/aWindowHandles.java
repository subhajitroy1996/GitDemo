package practisewithMaven;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class aWindowHandles {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		JavascriptExecutor js=( JavascriptExecutor)driver;
		driver.findElement(By.cssSelector("input.a-button-input")).click();
//		js.executeScript("window.scrollBy(0,500)");
//		Thread.sleep(2000);
//		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		WebElement w=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
//		w.sendKeys("samsung");
//		js.executeScript("arguments[0].sendkeys('toy')",w );
//		js.executeScript("document.getElementById('twotabsearchtextbox').sendKeys('samsung')");
		
	}

}
