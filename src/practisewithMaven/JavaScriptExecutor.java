package practisewithMaven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor j=(JavascriptExecutor)driver;//casting driver to javascriptexecutor
		
		j.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		j.executeScript("document.querySelector(\".tableFixHead\").scrollTop=2000");//document.querySelector works like cssSelector
		int sum=0;
		List<WebElement> w=driver.findElements(By.cssSelector(".tableFixHead #product tbody tr td:nth-child(4)"));
		for (int i=0;i<w.size();i++)
		{
			sum=sum+Integer.parseInt(w.get(i).getText());
		}
		
		System.out.println(sum);
		
		String[] s=driver.findElement(By.cssSelector("fieldset .totalAmount")).getText().split(":");
		int s2=Integer.parseInt(s[1].trim());
		System.out.println(s2);
		Assert.assertEquals(sum,s2);
		
	}

}
