package practisewithMaven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class j7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(	JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=1000");
		List<WebElement> t=driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[4]"));
		int sum=0;
		for(WebElement w:t)
		{
			sum=sum+Integer.parseInt(w.getText());
		}
		System.out.println(sum);
		Assert.assertEquals(sum, Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(" ")[3]));
	}
	
}
