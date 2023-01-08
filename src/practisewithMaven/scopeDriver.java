package practisewithMaven;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scopeDriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> w=driver.findElements(By.tagName("a"));
		System.out.println(w.size());
		WebElement foot=driver.findElement(By.cssSelector("div#gf-BIG"));//limiting the WebDriver scope to a sub-section.
		
		System.out.println(foot.findElements(By.tagName("a")).size());
		WebElement subfoot=foot.findElement(By.xpath("//table/tbody/tr/td/ul"));
		for(int i=1;i<subfoot.findElements(By.tagName("a")).size();i++)
		{

			String c=Keys.chord(Keys.CONTROL,Keys.ENTER);
			subfoot.findElements(By.tagName("a")).get(i).sendKeys(c);
			Thread.sleep(5000);
			
	}
		Set<String> s=driver.getWindowHandles();
		Iterator<String> it=s.iterator();
		System.out.println(s);
		System.out.println(it);
		
		while(it.hasNext())//used to check if there are any elements in the next index position.
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		}

	}


